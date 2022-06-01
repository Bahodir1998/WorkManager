package com.example.workmanager

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.workmanager.databinding.FragmentSplashBinding
import com.example.workmanager.service.CurencyWork
import java.util.concurrent.TimeUnit

class SplashFragment : Fragment() {


    lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater)

        val workRequest: WorkRequest = PeriodicWorkRequest.Builder(
            CurencyWork::class.java,15,
            TimeUnit.MINUTES).build()
        WorkManager.getInstance(requireContext()).enqueue(workRequest)
        val handler = Handler()

        binding.imgLogo.startAnimation(AnimationUtils.loadAnimation(requireContext(),R.anim.splash_anim))
        handler.postDelayed(runnable, 2000)

        return binding.root
    }

    var runnable = object : Runnable {
        override fun run() {
            val controller = Navigation.findNavController(binding.root)
            controller.popBackStack(R.id.splashFragment, true)
            controller.navigate(R.id.homeFragment)

        }

    }
}