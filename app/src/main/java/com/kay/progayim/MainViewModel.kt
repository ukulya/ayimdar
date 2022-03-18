package com.kay.progayim

import android.app.Application
import androidx.lifecycle.*
import com.kay.progayim.extensions.toCharacterEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.net.UnknownHostException

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    val charactersLiveData: LiveData<List<CharacterEntity>> =
        getApplication<App>().database.characterDao().getAll()

    val episodesCounterViaMap: LiveData<Int> = Transformations.map(charactersLiveData) {
        if (it.isEmpty()) 0 else it[0].episode.count()
    }

    private val _event = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = _event

    private val _episodesNumber = MediatorLiveData<Int>()
    val episodesNumber: LiveData<Int>
    get()= _episodesNumber


    init {
        loadCharacters()
        _episodesNumber.addSource(charactersLiveData){
            _episodesNumber.value = if(it.isEmpty()) 0 else it[0].episode.count()
        }
    }

    private fun loadCharacters() {
        _event.value = Event.ShowLoadingToast
        compositeDisposable.add(
            getApplication<App>().githubApi.getCharacters()
                .subscribeOn(Schedulers.io())
                .map {
                    Thread.sleep(5000)
                    it
                }
                .map {
                    val listEp = mutableListOf<CharacterEntity>()
                    it.results.forEach {
                        listEp.add(it.toCharacterEntity())
                    }
                    listEp.toList()
                }
                .map {
                    getApplication<App>().database.characterDao().insertList(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { _event.value = Event.ShowFinishedLoadingToast }
                .subscribe({}, {
                    handleError(it)
                })
        )
    }

    private fun handleError(it: Throwable) {
        _event.value = when (it) {
            is UnknownHostException -> Event.ShowToast(R.string.no_internet)
            else -> Event.ShowToast(R.string.unknown_error)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun deleteEpisodes(){
        getApplication<App>().database.characterDao().deleteAll()
    }

    fun clearEvents() {
        _event.value = null
    }

}