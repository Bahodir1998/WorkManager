package com.example.workmanager.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClicent {

    fun getRetrofit(baseUrl: String): Retrofit {
        val build = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

        return build
    }
}