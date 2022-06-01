package com.example.workmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.workmanager.adapters.CurrencyAdapter
import com.example.workmanager.databinding.FragmentHomeBinding
import com.example.workmanager.db.AppDatabase
import com.example.workmanager.db.Currency
import com.example.workmanager.service.CurencyWork
import java.util.concurrent.TimeUnit

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var appDatabase: AppDatabase
    lateinit var list: List<Currency>
    lateinit var currencyAdapter: CurrencyAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        appDatabase = AppDatabase.getInstance(requireContext())
        list = ArrayList()
        list = appDatabase.currencyDao().getAll()

        currencyAdapter = CurrencyAdapter(list)
        binding.vRv.adapter = currencyAdapter



        return binding.root
    }

}