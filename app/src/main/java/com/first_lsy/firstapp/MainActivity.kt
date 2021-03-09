package com.first_lsy.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this)
        adView.loadAd(AdRequest.Builder().build())


        loadData()

        ResultButton.setOnClickListener{

            saveData(probf.text.toString().toInt(), prob2.text.toString().toInt())

            startActivity<Result1Activity>(
                    "prob1" to probf.text.toString(),
                    "prob2" to prob2.text.toString()




            )
        }
    }

    override fun onPause(){
        adView.pause()
        super.onPause()
    }

    override fun onResume() {
        adView.resume()
        super.onResume()
    }

    override fun onDestroy() {
        adView.destroy()
        super.onDestroy()
    }

    private fun loadData() {
        val pref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        val prob1 = pref.getInt("KEY_PROB1",0)
        val prob2 = pref.getInt("KEY_PROB2",0)
    }

    private fun saveData(prob1: Int, prob2: Int) {
        val pref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_PROB1",prob1)
                .putInt("KEY_PROB2",prob2)
                .apply()

    }
}