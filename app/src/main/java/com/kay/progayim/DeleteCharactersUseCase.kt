package com.kay.progayim

import io.reactivex.Completable

class DeleteCharactersUseCase(
    private val rickAndMortyRepo: RickAndMortyRepo
) {
    operator fun invoke(): Completable {
        return rickAndMortyRepo.deleteCharacters()
    }
}