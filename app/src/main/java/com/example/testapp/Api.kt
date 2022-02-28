package com.example.testapp

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import io.reactivex.Single

interface Api {

    @GET("episodes")
    fun getEpisodes(): Observable<List<Item>>

    @GET("episodes/{id}")
    fun getEpisodeById(@Path("id") id: Long): Single<List<Item>>
}