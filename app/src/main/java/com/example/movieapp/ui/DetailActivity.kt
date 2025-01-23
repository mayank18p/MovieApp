package com.example.movieapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movieapp.data.AnimeDetailsResponse
import com.example.movieapp.databinding.DetailActivityBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailActivityBinding

    private var animeDetailsResponse: AnimeDetailsResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    private fun getData() {
        animeDetailsResponse =  intent.getParcelableExtra<AnimeDetailsResponse>("data")
        setDataToViews()
    }

  private fun setDataToViews() {
       binding.animeData = animeDetailsResponse
       binding.executePendingBindings()

       Glide.with(this).load(animeDetailsResponse?.data?.images?.jpg?.image_url).into(binding.poster)
  }
}