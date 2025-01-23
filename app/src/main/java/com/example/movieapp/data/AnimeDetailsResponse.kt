package com.example.movieapp.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class AnimeDetailsResponse(
    val data : DataResponse,
) : Parcelable

@Parcelize
@Keep
data class DataResponse(
    val mal_id: Int,
    val images : ImagesResponse,
    val title : String,
    val episodes : Int,
    val rating : String,
    val score : Double,
    val synopsis : String,
    val producers : List<Producers>,
    val genres : List<Genres>
) : Parcelable

@Parcelize
@Keep
data class ImagesResponse(
    val jpg : JpgResponse
) : Parcelable

@Parcelize
@Keep
data class JpgResponse(
    val image_url : String
) : Parcelable


@Parcelize
@Keep
data class Producers(
    val name : String
) : Parcelable

@Parcelize
@Keep
data class Genres(
    val name : String
) : Parcelable
