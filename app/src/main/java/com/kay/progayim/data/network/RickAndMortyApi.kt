package com.kay.progayim.data.network

import com.kay.progayim.data.models.CharacterDto
import io.reactivex.Observable
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("characters")
    fun getCharacters(): Observable<List<CharacterDto>>
}