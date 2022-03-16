package com.kay.progayim

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.kay.progayim.extensions.toCharacterEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application): AndroidViewModel(application) {


    private val compositeDisposable: CompositeDisposable  =  CompositeDisposable()


    val charactersLiveData: LiveData<List<CharacterEntity>> =
        getApplication<App>().database.characterDao().getAll()

    //должен быть приватным
    val event =  MutableLiveData<Int>()


    init {
        loadCharacters()
    }

    fun loadCharacters(){
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
                    it
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{
                    event.value = 404
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}