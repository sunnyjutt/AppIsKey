package com.example.appiskey.network

import com.example.appiskey.models.GetImagesDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("api")
    suspend fun getImagesDetail(
        @Query("key") key: String,
        @Query("q") q: String,
        @Query("image_type") image_type: String,
        @Query("pretty") pretty: Boolean
    ): Response<GetImagesDetail>


}