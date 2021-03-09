package com.first_lsy.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result1.*
import java.util.Random

class Result1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result1)

        val random = Random()


        //input numbers
        val prob1 = intent.getStringExtra("prob1")?.toInt()
        val prob2 = intent.getStringExtra("prob2")?.toInt()




        when { prob1?.times(random.nextInt(100))!! >= prob2?.times(random.nextInt(100))!! ->
            imageView.setImageResource(
                    R.drawable.ic_baseline_filter_1_24)
            else ->
                imageView.setImageResource(
                        R.drawable.ic_baseline_filter_2_24 )
        }










    }


}