package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var timerRunning = false
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startTimer.setOnClickListener {
            if(timerRunning){
                startTimer.text = "Resume"
            }else{
                startTimer.text = "Pause"
            }
            StartTimer()
        }

        resetTImer.setOnClickListener {
            startTimer.text = "Start"
            ResetTimer()
        }
    }

    private fun ResetTimer() {
        timerRunning = false
        MyCanvas.start = false
        MyCanvas.secondX = 0F
        MyCanvas.secondY = -300F
        MyCanvas.minuteX = 0F
        MyCanvas.minuteY = -60F
        MyCanvas.startTime = 0
        pauseTime = 0
    }

    private fun StartTimer() {
       if(timerRunning){
           timerRunning = false
           MyCanvas.start = false
           pauseTime = System.currentTimeMillis()

       }else{
           timerRunning = true
           MyCanvas.start = true
           if (MyCanvas.startTime == 0L) {
               MyCanvas.startTime = System.currentTimeMillis()
           }else{
               MyCanvas.startTime += System.currentTimeMillis() - pauseTime
           }
       }
    }
}