package com.kay.progayim

import com.kay.progayim.extensions.toCharacterEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class GetCharacterUseCase(
    private val rickAndMortyRepo: RickAndMortyRepo
) {
    operator fun invoke(): Observable<Unit> {
        return rickAndMortyRepo.getCharacters()
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
                rickAndMortyRepo.insertList(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}