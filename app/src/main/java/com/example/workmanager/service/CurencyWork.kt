package com.example.workmanager.service

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.workmanager.db.AppDatabase
import com.example.workmanager.db.Currency
import com.example.workmanager.retrofit.Common
import com.example.workmanager.utils.NetworkHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurencyWork(var context: Context,workerParameters: WorkerParameters):Worker(context,workerParameters) {
    lateinit var list: ArrayList<Currency>
    lateinit var appDatabase: AppDatabase
    override fun doWork(): Result {

        uploadCurencies()

        return Result.success()
    }

    private fun uploadCurencies() {
        var retrofitservice = Common.retrofitService
        retrofitservice.getCurrencies().enqueue(object : Callback<List<Currency>>{
            override fun onResponse(
                call: Call<List<Currency>>?,
                response: Response<List<Currency>>?
            ) {
                list = ArrayList()
                val networkHelper = NetworkHelper(context)
                appDatabase = AppDatabase.getInstance(context)
                if (networkHelper.isNetworkConnected()){
                    list.addAll(response?.body()!! as ArrayList<Currency>)
                    if (appDatabase.currencyDao().getAll().isEmpty()){
                        for (curency in list){
                            appDatabase.currencyDao().insertAll(curency)
                        }
                    }else{
                        for (curency in list){
                            appDatabase.currencyDao().insertAll(curency)
                        }
                    }
                }else if (appDatabase.currencyDao().getAll().isEmpty()){
                    Toast.makeText(context, "Please check your connection", Toast.LENGTH_SHORT).show()
                }

            }


            override fun onFailure(call: Call<List<Currency>>?, t: Throwable?) {

            }

        })
    }
}