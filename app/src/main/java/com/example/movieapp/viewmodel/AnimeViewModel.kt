package com.example.movieapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.AnimeDetailsResponse
import com.example.movieapp.data.AnimeSeriesResponse
import com.example.movieapp.other.Resource
import com.example.movieapp.repository.AnimeRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AnimeViewModel(private val animeRepository: AnimeRepository) : ViewModel() {

    companion object {
        const val TAG = "AnimeViewModel"
    }

    val showProgress = MutableLiveData<Boolean>()
    val animeSeriesData = MutableLiveData<Resource<AnimeSeriesResponse>>()
    val animeDetailsData = MutableLiveData<Resource<AnimeDetailsResponse>>()

    init {
        getAnimeSeries()
    }

    private fun getAnimeSeries() = viewModelScope.launch {
        showProgress.postValue(true)
        val response = animeRepository.getAnimeSeries()
        Log.d(TAG, "Anime series: $response")
        animeSeriesData.postValue(handleAnimeSeriesResponse(response))
    }

    private fun handleAnimeSeriesResponse(response: Response<AnimeSeriesResponse>) : Resource<AnimeSeriesResponse> {
        if (response.isSuccessful) {
            showProgress.postValue(false)
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        showProgress.postValue(false)
        return Resource.Error(response.message())
    }


    fun getAnimeDetails(animeId: Int) = viewModelScope.launch {
        showProgress.postValue(true)
        val response = animeRepository.getAnimeDetails(animeId)
        Log.d(TAG, "Anime details: $response")
        animeDetailsData.postValue(handleAnimeDetailsResponse(response))

    }

    private fun handleAnimeDetailsResponse(response: Response<AnimeDetailsResponse>) : Resource<AnimeDetailsResponse> {
        if (response.isSuccessful) {
            showProgress.postValue(false)
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        showProgress.postValue(false)
        return Resource.Error(response.message())
    }
}