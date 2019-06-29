package com.example.baka57r.ezpy

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.awal_activity.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import com.koushikdutta.ion.Ion
import java.io.FileOutputStream

class HalamanAwalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.awal_activity)

        signin.setOnClickListener {
            val i = Intent(this@HalamanAwalActivity, LoginActivity::class.java)
            startActivity(i)
            finish()
        }

        signup.setOnClickListener{
            val i = Intent(this@HalamanAwalActivity, DaftarPortal::class.java)
            startActivity(i)
            finish()
        }
    }

}