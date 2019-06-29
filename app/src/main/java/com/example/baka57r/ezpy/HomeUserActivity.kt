package com.example.baka57r.ezpy

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import android.widget.Toast
import android.widget.AdapterView
import kotlinx.android.synthetic.main.app_bar.*

class HomeUserActivity : AppCompatActivity() {

    internal var images = intArrayOf(R.drawable.iconscan, R.drawable.icon_top_up,
            R.drawable.iconriwayat, R.drawable.icon_account)

    internal var title = arrayOf("Scan", "Isi saldo", "Riwayat", "QID")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        user_name.text = "Deryan Everesta"
        user_name.setTextColor(Color.WHITE)

        val adapter = HomeAdapter(this, title, images)
        gridviewHome.adapter = adapter

        gridviewHome.setOnItemClickListener(AdapterView.OnItemClickListener { parent, v, position, id -> Toast.makeText(this@HomeUserActivity, "Image Position: $position", Toast.LENGTH_SHORT).show() })

        gridviewHome.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent: Intent
            when (position) {
                0 -> {
                    intent = Intent(this, ScanPembeli::class.java)
                    startActivity(intent)
                }
                1 -> {
                    intent = Intent(this, InputTopup::class.java)
                    startActivity(intent)
                }
                2 -> {
                    intent = Intent(this, LogPembeli::class.java)
                    startActivity(intent)
                }
                else ->{
                    intent = Intent(this, Profil::class.java)
                    startActivity(intent)
                }

            }
        }


    }

}