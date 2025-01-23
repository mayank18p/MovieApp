package com.example.movieapp.interfaces

import com.example.movieapp.data.AnimeDetailsResponse
import com.example.movieapp.data.AnimeSeriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("top/anime")
    suspend fun getAnimeSeries(): Response<AnimeSeriesResponse>

    @GET("anime/{anime_id}")
    suspend fun getAnimeDetails(@Path("anime_id") animeId: Int): Response<AnimeDetailsResponse>
}