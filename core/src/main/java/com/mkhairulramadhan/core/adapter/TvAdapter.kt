package com.mkhairulramadhan.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mkhairulramadhan.core.R
import com.mkhairulramadhan.core.databinding.ListItemBinding
import com.mkhairulramadhan.core.domain.model.TvModel

class TvAdapter: RecyclerView.Adapter<TvAdapter.ListViewHolder>() {

    private var listMoviesTvs = ArrayList<TvModel>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: TvModel)
    }

    fun setData(listMoviesTv: List<TvModel>){
        this.listMoviesTvs = listMoviesTv as ArrayList<TvModel>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        listMoviesTvs[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int = listMoviesTvs.size

    inner class ListViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TvModel) {
            Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/original/${data.posterImage}")
                .apply(RequestOptions.placeholderOf(R.drawable.loading_image).error(R.drawable.error_image).override(130,165))
                    .centerCrop()
                    .into(binding.imageList)
            binding.titleList.text = data.name
            binding.languageList.text = data.language
            binding.yearList.text = data.year
            binding.starList.text = data.star
            binding.synopsisList.text = data.synopsis
            itemView.setOnClickListener{onItemClickCallback?.onItemClicked(data)}
        }
    }
}