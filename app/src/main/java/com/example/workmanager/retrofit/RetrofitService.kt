package com.example.workmanager.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("/uzc/arkhiv-kursov-valyut/json/")
    fun getCurrencies(): Call<List<com.example.workmanager.db.Currency>>
}