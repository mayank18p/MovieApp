package com.example.movieapp.repository

import com.example.movieapp.other.RetrofitInstance

class AnimeRepository {

    suspend fun getAnimeSeries() = RetrofitInstance.apiService.getAnimeSeries()

    suspend fun getAnimeDetails(animeId: Int) = RetrofitInstance.apiService.getAnimeDetails(animeId)
}