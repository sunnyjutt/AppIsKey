package com.example.appiskey.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.appiskey.databinding.ImagesDetailLayoutBinding
import com.example.appiskey.models.GetImagesDetail

typealias ImageCallback = (String) -> Unit

class ImagesDetailAdapter(
    private val context: Context,
    private val list: List<GetImagesDetail.Hit?>?,
    private val imageClickCallback: ImageCallback,
) : Adapter<ImagesDetailAdapter.ImagesHolder>() {

    inner class ImagesHolder(private val binding: ImagesDetailLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: GetImagesDetail.Hit) {
            Glide.with(context).load(item.largeImageURL).into(binding.ivLargeImage)
            binding.tvUser.text = item.user
            binding.tvTags.text = item.tags
            binding.tvLikes.text = item.likes.toString()

            binding.ivLargeImage.setOnClickListener {
                handleProductClick(item.largeImageURL)
            }
        }

        private fun handleProductClick(largeImageURL: String?) {
            largeImageURL?.let {
                imageClickCallback(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesHolder {
        val binding =
            ImagesDetailLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImagesHolder(binding)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: ImagesHolder, position: Int) {
        val item = list?.getOrNull(position)
        item?.let {
            holder.onBind(it)
        }
    }
}