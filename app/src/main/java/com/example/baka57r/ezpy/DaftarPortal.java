package com.example.baka57r.ezpy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class DaftarPortal extends AppCompatActivity {

    String data1,data2,data3,data4;
    String hasil1,hasil2,hasil3,hasil4,hasil5;
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_ic);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HalamanAwalActivity.class));
                finish();
            }
        });

    }

    public void klik_faq(View v){
        Intent dashboard = new Intent(DaftarPortal.this, FAQActivity.class);
        startActivity(dashboard);
    }

    public void klikdaftar(View v)
    {
        EditText input_nama   = (EditText)findViewById(R.id.nama);
        data1 = input_nama.getText().toString();
        EditText input_email   = (EditText)findViewById(R.id.email);
        data2 = input_email.getText().toString();
        EditText input_pass   = (EditText)findViewById(R.id.password);
        data3 = input_pass.getText().toString();
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogrup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        data4 = radioButton.getText().toString();
        EditText no_hp = (EditText)findViewById(R.id.phone);
        hasil5 = no_hp.getText().toString();

        if(data4.equals("Penjual"))
            data4 = "1";
        else if(data4.equals("Pembeli"))
            data4 = "2";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(DaftarApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        DaftarApi api = retrofit.create(DaftarApi.class);

        Call<ResponseBody> call = api.getDaftar(data1, data2, data3, data4);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){

                    try {
                        JSONObject json = new JSONObject(response.body().string());
                        hasil1 = json.getString("_id");
                        hasil2 = json.getString("email");
                        hasil3 = json.getString("name");
                        hasil4 = json.getString("role");

                        Toast.makeText(DaftarPortal.this,"DAFTAR BERHASIL!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DaftarPortal.this, MainActivity.class);
                        startActivity(intent);

                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }


                }else {
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast tost = Toast.makeText(getApplicationContext(),"GAGAL RESPONSE RETROFIT" ,Toast.LENGTH_LONG);
                tost.show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
