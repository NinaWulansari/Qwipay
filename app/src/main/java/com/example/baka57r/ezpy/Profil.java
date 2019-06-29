package com.example.baka57r.ezpy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Profil extends AppCompatActivity {

    String data1,data2,data3,data4,data5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle bundle = getIntent().getExtras();
        data1 = bundle.getString("param1");
        data2 = bundle.getString("param2");
        data3 = bundle.getString("param3");
        data4 = bundle.getString("param4");
        data5 = bundle.getString("param5");

        TextView mTextView1 = (TextView) findViewById(R.id.qid);
        mTextView1.setText("Welcome "+data5);
        TextView mTextView2 = (TextView) findViewById(R.id.nama_user);
        mTextView2.setText("Welcome "+data1);
        TextView mTextView3 = (TextView) findViewById(R.id.email_user);
        mTextView3.setText("Welcome "+data4);
    }
}
