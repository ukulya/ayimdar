package com.kay.progayim.data.network

import com.kay.progayim.data.models.ResponseDto
import io.reactivex.Observable
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    fun getCharacters(): Observable<ResponseDto>
}