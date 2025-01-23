package com.example.movieapp.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class AnimeSeriesResponse(
    val data : List<Data>,
) : Parcelable

@Parcelize
@Keep
data class Data(
    val mal_id: Int,
    val title : String,
    val episodes : Int,
    val score : Double,
    val images : Images
) : Parcelable

@Parcelize
@Keep
data class Images(
    val jpg : Jpg
) : Parcelable

@Parcelize
@Keep
data class Jpg(
    val image_url : String
) : Parcelable
