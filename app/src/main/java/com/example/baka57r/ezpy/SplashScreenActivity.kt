package com.example.baka57r.ezpy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import java.util.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
                val i = Intent(this@SplashScreenActivity, HalamanAwalActivity::class.java)
                startActivity(i)
                finish()
        }, TIME_OUT.toLong())
    }

    companion object {
        val TIME_OUT = 2000
    }
}