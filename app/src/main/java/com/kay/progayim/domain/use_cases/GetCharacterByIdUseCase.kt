package com.kay.progayim.domain.use_cases

import com.kay.progayim.data.models.CharacterEntity
import com.kay.progayim.data.repo.RickAndMortyRepo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class GetCharacterByIdUseCase(
    private val repo: RickAndMortyRepo
) {

    operator fun invoke(id: Long): Single<CharacterEntity> {
        return repo.getCharacterById(id)
            .map {
                Thread.sleep(2000)
                it
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}