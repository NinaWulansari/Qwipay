package com.example.baka57r.ezpy;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardPenjual extends AppCompatActivity {

    ViewPager viewPager;
    CarouselView carouselView;
    String value1,value2,value3,value4,value5;
    String hasil1,hasil2,hasil3,hasil4,hasil5;

    int[] sampleImages = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ezpaylogo2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_penjual);

        Bundle bundle = getIntent().getExtras();

        value1 = bundle.getString("param1");
        value2 = bundle.getString("param2");
        value3 = bundle.getString("param3");
        value4 = bundle.getString("param4");
        value5 = bundle.getString("param5");

        Retrofit retrofit = new Retrofit.Builder().baseUrl(SaldoApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        SaldoApi api = retrofit.create(SaldoApi.class);

        Call<ResponseBody> call = api.getSaldo(value4,"Bearer "+value2);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    //loading.dismiss();
                    try {
                        JSONObject jsonRes = new JSONObject(response.body().string());
                        hasil1 = jsonRes.getString("_id");
                        hasil2 = jsonRes.getString("email");
                        hasil3 = jsonRes.getString("name");
                        hasil4 = jsonRes.getString("jumlah_uang");
                        hasil5 = jsonRes.getString("__v");
//                        Toast tost = Toast.makeText(getApplicationContext(), hasil1+hasil2+hasil3+hasil4+hasil5,Toast.LENGTH_LONG);
//                        tost.show();

                        TextView mTextView1 = (TextView) findViewById(R.id.textViews);
                        TextView mTextView2 = (TextView) findViewById(R.id.textdua);
                        mTextView1.setText("Welcome "+hasil3);
                        mTextView2.setText("Saldo "+hasil4);
                        //Intent dashboard = new Intent(MainActivity.this, DashboardUser.class);
                        //dashboard.putExtra("param1",hasil);
                        //dashboard.putExtra("param2",input2);
                        //startActivity(dashboard);
                        //Intent intent = new Intent(mContext, MainActivity.class);
                        //intent.putExtra("result_nama", nama);
                        //startActivity(intent);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }else {
                    //loading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast tost = Toast.makeText(getApplicationContext(),"Welcome bruhh " ,Toast.LENGTH_LONG);
                tost.show();
            }
        });

        carouselView = (CarouselView) findViewById(R.id.carouselView2);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    public void coba_pindah_logoutjual(View v)
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(LogoutApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        LogoutApi api = retrofit.create(LogoutApi.class);

        Call<ResponseBody> call = api.getOut("Bearer "+value2);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    //loading.dismiss();
                    try {
                        JSONObject jsonRes = new JSONObject(response.body().string());
//                        hasil1 = jsonRes.getString("_id");
//                        hasil2 = jsonRes.getString("email");
//                        hasil3 = jsonRes.getString("name");
//                        hasil4 = jsonRes.getString("jumlah_uang");
//                        hasil5 = jsonRes.getString("__v");
//                        Toast tost = Toast.makeText(getApplicationContext(), hasil1+hasil2+hasil3+hasil4+hasil5,Toast.LENGTH_LONG);
//                        tost.show();
//
//                        TextView mTextView1 = (TextView) findViewById(R.id.textView);
//                        TextView mTextView2 = (TextView) findViewById(R.id.textsatu);
//                        mTextView1.setText("Welcome "+hasil3);
//                        mTextView2.setText("Saldo "+hasil4);
                        //Intent dashboard = new Intent(MainActivity.this, DashboardUser.class);
                        //dashboard.putExtra("param1",hasil);
                        //dashboard.putExtra("param2",input2);
                        //startActivity(dashboard);
                        //Intent intent = new Intent(mContext, MainActivity.class);
                        //intent.putExtra("result_nama", nama);
                        //startActivity(intent);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }else {
                    //loading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast tost = Toast.makeText(getApplicationContext(),"Welcome bruhh " ,Toast.LENGTH_LONG);
                tost.show();
            }
        });
        Intent dashboard = new Intent(DashboardPenjual.this,MainActivity.class) ;
        startActivity(dashboard);
    }

    public void pindah_ke_logjual(View v)
    {
        Intent dashboard = new Intent(DashboardPenjual.this,LogPenjual.class) ;
        dashboard.putExtra("param1",value1);
        dashboard.putExtra("param2",value2);
        startActivity(dashboard);
    }

    public void pindah_ke_input_jual(View v)
    {
        Intent dashboard = new Intent(DashboardPenjual.this,InputTransaksiPenjual.class) ;
        dashboard.putExtra("param1",value1);
        dashboard.putExtra("param2",value2);
        dashboard.putExtra("param3",value3);
        dashboard.putExtra("param4",value4);
        dashboard.putExtra("param5",value5);
        startActivity(dashboard);
    }


}
