package com.example.baka57r.ezpy

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.baka57r.ezpy.R.id.toolbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.custom_toolbar.*
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        titleSearch!!.text = "Log in"
        titleSearch!!.setTextColor(Color.WHITE)
        setSupportActionBar(toolbar_ic)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        toolbar_ic.setNavigationOnClickListener(View.OnClickListener {
            startActivity(Intent(applicationContext, HalamanAwalActivity::class.java))
            finish()
        })

        val sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            toolbar_ic.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.headerkecil) )
        } else {
            toolbar_ic.setBackground(ContextCompat.getDrawable(this, R.drawable.headerkecil))
        }

        faq_button.setOnClickListener {
            val i = Intent(this@LoginActivity, FAQActivity::class.java)
            startActivity(i)
            finish()
        }

        login.setOnClickListener {

            val retrofit = Retrofit.Builder().baseUrl(LoginApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

            val api = retrofit.create(LoginApi::class.java)

            val input_userstr = email_user.text.toString()
            val input_passstr = password.text.toString()

            val call = api.getLogin(input_userstr, input_passstr)
            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {

                        try {
                            val jsonRes = JSONObject(response.body()!!.string())
                            val input1 = jsonRes.getString("Nama")
                            val input2 = jsonRes.getString("token")
                            val input3 = jsonRes.getString("Role")
                            val input4 = jsonRes.getString("Email")
                            val input5 = jsonRes.getString("Id")

                            if (input3 == "2") {
                                val dashboard = Intent(this@LoginActivity, HomeUserActivity::class.java)
                                dashboard.putExtra("param1", input1)
                                dashboard.putExtra("param2", input2)
                                dashboard.putExtra("param3", input3)
                                dashboard.putExtra("param4", input4)
                                dashboard.putExtra("param5", input5)
                                startActivity(dashboard)
                            } else if (input3 == "1") {
                                val dashboard = Intent(this@LoginActivity, DashboardPenjual::class.java)
                                dashboard.putExtra("param1", input1)
                                dashboard.putExtra("param2", input2)
                                dashboard.putExtra("param3", input3)
                                dashboard.putExtra("param4", input4)
                                dashboard.putExtra("param5", input5)
                                startActivity(dashboard)
                            }

                        } catch (e: JSONException) {
                            e.printStackTrace()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }

                    } else {

                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    val tost = Toast.makeText(applicationContext, "Please check your connection", Toast.LENGTH_LONG)
                    tost.show()
                }
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}