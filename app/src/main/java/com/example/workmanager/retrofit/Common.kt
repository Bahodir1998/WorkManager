package com.example.workmanager.retrofit

object Common {

    val BASE_URL = "https://cbu.uz/"

    val retrofitService:RetrofitService
    get() = RetrofitClicent.getRetrofit(BASE_URL).create(RetrofitService::class.java)
}