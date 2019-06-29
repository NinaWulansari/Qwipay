package com.example.baka57r.ezpy;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    DatabaseReference databases = FirebaseDatabase.getInstance().getReference("Users").getRef();
    //DatabaseReference databases2 =  databases.child("Users");


    Button button;
    int flag = 0;
    String valueu,valuep,valuess,input_userstr,input_passstr,input_statusstr;
    String input1,input2,input3,input4,input5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awal_activity);


        if(ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
        {

        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (shouldShowRequestPermissionRationale(android.Manifest.permission.CAMERA)) {
                    Toast.makeText(MainActivity.this, "PERLU BUAT SAVE IMAGE", Toast.LENGTH_SHORT).show();
                }
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.CAMERA)) {
                    Toast.makeText(MainActivity.this, "PERLU BUAT SAVE IMAGE", Toast.LENGTH_SHORT).show();

                }
            }


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                requestPermissions(new String[]{android.Manifest.permission.CAMERA}, 1);
            }
            else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.CAMERA}, 1);

            }
        }
    }

    public void onDaftar(View v)
    {
        Intent dashboard = new Intent(MainActivity.this, DaftarPortal.class);
        startActivity(dashboard);
    }

    //@Override
    public void onGet(View v)
    {

        Intent dashboard = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(dashboard);
    }
}
