package com.example.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.data.Data
import com.example.movieapp.databinding.AnimeListItemBinding
import com.example.movieapp.interfaces.ClickListener

class AnimeListAdapter(
    private var context: Context,
    private var listener: ClickListener,
    private var data : List<Data>
) : RecyclerView.Adapter<AnimeListAdapter.AnimeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListViewHolder {
        return AnimeListViewHolder(AnimeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AnimeListViewHolder, position: Int) {
        holder.onBind(data[position], context, listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    class AnimeListViewHolder(private val binding: AnimeListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Data, context: Context, listener: ClickListener) {
            binding.animeSeries = data

            Glide.with(context).load(data.images.jpg.image_url).into(binding.poster)

            binding.poster.setOnClickListener {
                listener.click(data.mal_id)
            }

            binding.executePendingBindings()
        }
    }

}