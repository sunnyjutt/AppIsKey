package com.example.appiskey.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
//    https://pixabay.com/api/?key=38437071-5f1d14114d464cb7440d92ebd&q=kitten&image_type=photo&pretty=true
    private const val BASE_URL = "https://pixabay.com/"

    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}