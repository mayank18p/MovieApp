package com.example.movieapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.adapter.AnimeListAdapter
import com.example.movieapp.data.AnimeSeriesResponse
import com.example.movieapp.databinding.HomeActivityBinding
import com.example.movieapp.interfaces.ClickListener
import com.example.movieapp.other.Resource
import com.example.movieapp.repository.AnimeRepository
import com.example.movieapp.viewmodel.AnimeViewModel
import com.example.movieapp.viewmodel.AnimeViewModelFactory

class HomeActivity : AppCompatActivity(), ClickListener {

    private lateinit var binding: HomeActivityBinding

    private lateinit var viewModel: AnimeViewModel
    private lateinit var animeListAdapter: AnimeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = AnimeRepository()
        val factory = AnimeViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(AnimeViewModel::class.java)

        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.animeSeriesData.observe(this) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        setAnimeSeriesAdapter(it)
                    }
                }

                is Resource.Error -> {
                    response.message?.let {
                        Toast.makeText(this@HomeActivity, it, Toast.LENGTH_LONG).show()
                    }
                }

                is Resource.Loading -> {

                }
            }

        }
    }

    private fun setAnimeSeriesAdapter(response: AnimeSeriesResponse) {
        animeListAdapter = AnimeListAdapter(this@HomeActivity, this, response.data)
        binding.recyclerView.adapter = animeListAdapter
    }

    override fun click(animeId: Int) {
        viewModel.getAnimeDetails(animeId)

        viewModel.animeDetailsData.observe(this) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        val intent = Intent(this@HomeActivity, DetailActivity::class.java)
                        intent.putExtra("data", it)
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent)
                    }
                }

                is Resource.Error -> {
                    response.message?.let {
                        Toast.makeText(this@HomeActivity, it, Toast.LENGTH_LONG).show()
                    }
                }

                is Resource.Loading -> {

                }
            }

        }
    }
}