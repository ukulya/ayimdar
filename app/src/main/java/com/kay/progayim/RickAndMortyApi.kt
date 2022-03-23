package com.kay.progayim

import io.reactivex.Observable
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    fun getCharacters(): Observable<ResponseDto>
}