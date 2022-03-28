package com.kay.progayim.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kay.progayim.App
import com.kay.progayim.data.repo.RickAndMortyRepo
import com.kay.progayim.domain.use_cases.GetCharacterByIdUseCase
import com.kay.progayim.ui.Event
import io.reactivex.disposables.CompositeDisposable

class DetailsViewModel(application: Application) : AndroidViewModel(application)  {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private  var id: Long = -1
    fun setId(id: Long?){
        this.id = id ?: -1
    }

    private val _event = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = _event


    private val rickAndMortyRepo = RickAndMortyRepo(
        getApplication<App>().rickAndMortyApi,
        getApplication<App>().database.characterDao()
    )

    private val getCharacterByIdUseCase: GetCharacterByIdUseCase =
        GetCharacterByIdUseCase(rickAndMortyRepo)

    fun fetchCharacter(){
        compositeDisposable.add(
            getCharacterByIdUseCase(id)
                .subscribe({
                           _event.value = Event.FetchedCharacter(it)
                },{

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}