package com.example.testapp

import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("episodes")
    fun getEpisodes(): Observable<List<Item>>

    @GET("episodes/$id")
    fun getEpisodeById(): Observable<List<Item>>
}