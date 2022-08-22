package com.example.meals.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.meals.R

@BindingAdapter("urlToImage")
fun urlToImage(view:ImageView,s:String?){
    val options = RequestOptions.placeholderOf(R.drawable.downloading).error(R.drawable.error)
    Glide.with(view).setDefaultRequestOptions(options).load(s ?: "").into(view)
}