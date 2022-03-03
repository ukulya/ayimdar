package com.example.testapp

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import io.reactivex.Single

interface Api {

    @GET("character")
    fun getEpisodes(): Observable<List<Item>>

    @GET("character/{id}")
    fun getEpisodeById(@Path("id") id: Long): Single<List<Item>>
}