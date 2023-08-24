package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import com.example.timer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding

    private var seconds = 0
    private var isRunning = false
    private var wasRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener { onClickStart() }
        binding.buttonStop.setOnClickListener { onClickStop() }
        binding.buttonReset.setOnClickListener { onClickReset() }
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds")
            isRunning = savedInstanceState.getBoolean("isRunning")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
        runTimer()

    }

    override fun onStop() {
        super.onStop()
        wasRunning = isRunning
        isRunning = false

    }

    override fun onStart() {
        super.onStart()
        isRunning = wasRunning
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("seconds", seconds)
        outState.putBoolean("isRunning", isRunning)
        outState.putBoolean("wasRunning", wasRunning)
    }

    private fun onClickStart() {
        isRunning = true
    }

    private fun onClickStop() {
        isRunning = false
    }

    private fun onClickReset() {
        isRunning = false
        seconds = 0
    }

    private fun runTimer() {

        val handler = Handler()

        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60
        var timeSec = "$secs"
        var timeMinute = "$minutes"
        var timeHours = "$hours"
        if (secs < 10) {
            timeSec = "0$secs"
        }
        if (minutes < 10) {
            timeMinute = "0$minutes"
        }
        if (hours < 10) {
            timeHours = "0$hours"
        }
        val time = "$timeHours:$timeMinute:$timeSec"
        binding.textViewTimer.text = time

        if (isRunning) {
            seconds++
        }

        handler.postDelayed({ runTimer()}, 1000)
    }
}