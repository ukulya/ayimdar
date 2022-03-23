package com.kay.progayim

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.net.UnknownHostException

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val rickAndMortyRepo = RickAndMortyRepo(
        getApplication<App>().rickAndMortyApi,
        getApplication<App>().database.characterDao()
    )

    private val getCharacterUseCase = GetCharacterUseCase(rickAndMortyRepo)

    private val deleteCharactersUseCase = DeleteCharactersUseCase(rickAndMortyRepo)

    val charactersLiveData: LiveData<List<CharacterEntity>> =
        getApplication<App>().database.characterDao().getAll()

    val episodesCounterViaMap: LiveData<Int> = Transformations.map(charactersLiveData) {
        if (it.isEmpty()) 0 else it[0].episode.count()
    }

    private val _event = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = _event

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        _event.value = Event.ShowLoadingToast
        compositeDisposable.add(
            getCharacterUseCase()
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
        compositeDisposable.add(
            deleteCharactersUseCase()
                .subscribe()
        )
    }

    fun clearEvents() {
        _event.value = null
    }

}