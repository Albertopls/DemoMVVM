package com.example.demoapp.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageNetwork(context: Context, url:String){

    Glide.with(context).load(url).into(this)
}