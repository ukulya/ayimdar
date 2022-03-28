package com.kay.progayim.domain.use_cases

import androidx.lifecycle.LiveData
import com.kay.progayim.data.models.CharacterEntity
import com.kay.progayim.data.repo.RickAndMortyRepo

class GetCharactersAsLiveDataUseCase(
   private val  repo: RickAndMortyRepo
) {
    operator fun invoke(): LiveData<List<CharacterEntity>> {
        return repo.getCharactersAsLive()
    }
}