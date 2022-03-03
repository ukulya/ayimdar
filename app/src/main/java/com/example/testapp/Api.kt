package com.example.testapp

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import io.reactivex.Single

interface Api {

    @GET("character")
    fun getAllCharacters(): Observable<Response>

    @GET("character/{id}")
    fun getEpisode(@Path("id") id: Long? ): Single<Character>
}