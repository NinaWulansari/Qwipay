package com.example.baka57r.ezpy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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


public class DashboardUser extends AppCompatActivity {

    ViewPager viewPager;
    CarouselView carouselView;

    int[] sampleImages = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, R.drawable.ezpaylogo2};
    String value1, value3, value2, value4, value5;

    String hasil1,hasil2,hasil3,hasil4,hasil5;
    final String SHARED_PREFS = "sharedPrefs";
    final String TEXT = "text";
    final String SWITCH = "switch";
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_user);

//        if(flag == 0) {
            Bundle bundle = getIntent().getExtras();

            value1 = bundle.getString("param1");
            value2 = bundle.getString("param2");
            value3 = bundle.getString("param3");
            value4 = bundle.getString("param4");
            value5 = bundle.getString("param5");

            Log.i("TAG", "datetir: "+value1 + " "+value2 + " "+value3+ " "+value4 + " "+value5);

            TextView mTextView2 = (TextView) findViewById(R.id.textsatu);
            mTextView2.setText("Welcome "+value1);
//            flag = 1;

//        }
//        else if(flag == 1)
//        {
//            SharedPreferences result = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
//            value1 = result.getString(TEXT,"test aja");
//            value2 = result.getString(SWITCH, "test aja");
//            Toast tost = Toast.makeText(getApplicationContext(), "pindah dari selain login "+value1+"   "+value2,Toast.LENGTH_LONG);
//            tost.show();
//
//        }
        Retrofit retrofit = new Retrofit.Builder().baseUrl(SaldoApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        SaldoApi api = retrofit.create(SaldoApi.class);

        Call<ResponseBody> call = api.getSaldo(value4,"Bearer "+value2);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                //loading.dismiss();
                if(response.isSuccessful()) {

                    try {

                        JSONObject jsonRes = new JSONObject(response.body().string());

                        hasil1 = jsonRes.getString("_id");
                        hasil2 = jsonRes.getString("email");
                        hasil3 = jsonRes.getString("name");
                        hasil4 = jsonRes.getString("jumlah_uang");
                        hasil5 = jsonRes.getString("__v");

                        TextView mTextView1 = (TextView) findViewById(R.id.textView);
                        TextView mTextView2 = (TextView) findViewById(R.id.textsatu);
                        mTextView1.setText("Welcome " + hasil3);
                        mTextView2.setText("Saldo " + hasil4);
                        //Intent dashboard = new Intent(MainActivity.this, DashboardUser.class);
                        //dashboard.putExtra("param1",hasil);
                        //dashboard.putExtra("param2",input2);
                        //startActivity(dashboard);
                        //Intent intent = new Intent(mContext, MainActivity.class);
                        //intent.putExtra("result_nama", nama);
                        //startActivity(intent);

                    } catch (JSONException e) {
                        Toast tost1 = Toast.makeText(getApplicationContext(), "ngok", Toast.LENGTH_LONG);
                        tost1.show();
                        e.printStackTrace();
                    } catch (IOException e) {
                        Toast tost2 = Toast.makeText(getApplicationContext(), "pret", Toast.LENGTH_LONG);
                        tost2.show();
                        e.printStackTrace();
                    }
                } else {
                    //loading.dismiss();
                    Toast tostt = Toast.makeText(getApplicationContext(), "okegagal", Toast.LENGTH_LONG);
                    tostt.show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast tost = Toast.makeText(getApplicationContext(),"Welcome bruhh " ,Toast.LENGTH_LONG);
                tost.show();
            }
        });

//        viewPager = (ViewPager) findViewById(R.id.viewPager);
//
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
//        viewPager.setAdapter(viewPagerAdapter);
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    public void coba_pindah_layer3(View v)
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


                        SharedPreferences.Editor editor = getSharedPreferences("DataUser", MODE_PRIVATE).edit();
                        editor.clear().commit();

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

        Intent dashboard = new Intent(DashboardUser.this,MainActivity.class) ;
        startActivity(dashboard);
    }

    public void pindah_ke_topup(View v)
    {
        Intent dashboard = new Intent(DashboardUser.this,InputTopup.class) ;
        dashboard.putExtra("param1",value1);
        dashboard.putExtra("param2",value2);
        dashboard.putExtra("param3",value3);
        dashboard.putExtra("param4",value4);
        dashboard.putExtra("param5",value5);
        startActivity(dashboard);
    }

    public void pindah_ke_profil(View v)
    {
        Intent dashboard = new Intent(DashboardUser.this,Profil.class) ;
//        SharedPreferences prefs = getSharedPreferences("DataUser", MODE_PRIVATE);
//
//        String name = prefs.getString("name", "");//"No name defined" is the default value.
//        String email = prefs.getString("email", "");//"No name defined" is the default value.
//        String id = prefs.getString("id", "");//"No name defined" is the default value.

        dashboard.putExtra("param1",value1);
        dashboard.putExtra("param2",value2);
        dashboard.putExtra("param3",value3);
        dashboard.putExtra("param4",value4);
        dashboard.putExtra("param5",value5);
        startActivity(dashboard);
    }

    public void pindah_ke_log(View v)
    {
//        Toast tost2 = Toast.makeText(getApplicationContext(),"Data Param2 "+ value2,Toast.LENGTH_SHORT);
//        tost2.show();
        Intent dashboard = new Intent(DashboardUser.this,LogPembeli.class) ;
        dashboard.putExtra("param1",value1);
        dashboard.putExtra("param2",value2);
        dashboard.putExtra("param3",value3);
        dashboard.putExtra("param4",value4);
        dashboard.putExtra("param5",value5);
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(TEXT, value1);
//        editor.putString(SWITCH, value2);
//        editor.apply();
        startActivityForResult(dashboard, 100);
    }

    public void pindah_ke_scan(View v)
    {
        Intent dashboard = new Intent(DashboardUser.this,ScanPembeli.class) ;
        dashboard.putExtra("param1",value1);
        dashboard.putExtra("param2",value2);
        dashboard.putExtra("param3",value3);
        dashboard.putExtra("param4",value4);
        dashboard.putExtra("param5",value5);
        startActivity(dashboard);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK){
            String value12 = data.getStringExtra("param1");
            String value22 = data.getStringExtra("param2");
//            Toast tost = Toast.makeText(getApplicationContext(), "pindah dari activity log "+value12+"   "+value22,Toast.LENGTH_LONG);
//            tost.show();
            Retrofit retrofit = new Retrofit.Builder().baseUrl(SaldoApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            SaldoApi api = retrofit.create(SaldoApi.class);

            Call<ResponseBody> call = api.getSaldo(value12,"Bearer "+value22);
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
                            Toast tost = Toast.makeText(getApplicationContext(), hasil1+hasil2+hasil3+hasil4+hasil5,Toast.LENGTH_LONG);
                            tost.show();
                            Log.i("TAG", "dataeveret: "+hasil2+hasil4);

                            TextView mTextView1 = (TextView) findViewById(R.id.textView);
                            TextView mTextView2 = (TextView) findViewById(R.id.textsatu);
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
        }
    }


}
