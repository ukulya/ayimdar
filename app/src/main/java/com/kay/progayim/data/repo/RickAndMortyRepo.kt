package com.kay.progayim.data.repo

import com.kay.progayim.data.models.CharacterEntity
import com.kay.progayim.data.models.CharacterDto
import com.kay.progayim.data.network.RickAndMortyApi
import com.kay.progayim.data.storage.CharacterDao
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RickAndMortyRepo(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao
) {

    fun getCharacters(): Observable<List<CharacterDto>> {
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

    fun getCharacterById(id: Long): Single<CharacterEntity> {
        return characterDao.getById(id)
            .subscribeOn(Schedulers.io())
    }

    fun getCharactersAsLive() = characterDao.getAll()
}