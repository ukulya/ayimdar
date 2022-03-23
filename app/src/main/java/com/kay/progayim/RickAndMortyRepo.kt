package com.kay.progayim

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class RickAndMortyRepo(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao
) {

    fun getCharacters(): Observable<ResponseDto> {
        return rickAndMortyApi.getCharacters()
            .subscribeOn(Schedulers.io())
    }

    fun insertList(characterList: List<CharacterEntity>){
        characterDao.insertList(characterList)
    }

    fun deleteCharacters(): Completable {
        return characterDao.deleteAll()
            .subscribeOn(Schedulers.io())
    }
}