package com.example.baka57r.ezpy;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.zxing.client.android.Intents;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.security.AccessController.getContext;

public class ScanPembeli extends AppCompatActivity {

    SurfaceView surfaceView;
    CameraSource cameraSource;
    TextView textView;
    BarcodeDetector barcodeDetector;
    String data1,data2;
    String hasil1,hasil2,hasil3,hasil4,hasil5,hasil6,hasil7,hasil8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_pembeli);

        getSupportActionBar().setTitle("SCAN QR CODE");

        Bundle bundle = getIntent().getExtras();

        data1 = bundle .getString("param1");
        data2 = bundle .getString("param2");

        surfaceView = (SurfaceView) findViewById(R.id.kamera1);
        textView = (TextView) findViewById(R.id.text1);

        barcodeDetector = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.QR_CODE).build();
        cameraSource = new CameraSource.Builder(this, barcodeDetector).setRequestedPreviewSize(640, 480).build();

        if(ContextCompat.checkSelfPermission(ScanPembeli.this, Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED)
        {

        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    Toast.makeText(ScanPembeli.this, "PERLU BUAT SAVE IMAGE", Toast.LENGTH_SHORT).show();
                }
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(ScanPembeli.this, Manifest.permission.CAMERA)) {
                    Toast.makeText(ScanPembeli.this, "PERLU BUAT SAVE IMAGE", Toast.LENGTH_SHORT).show();

                }
            }


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
            }
            else {
                ActivityCompat.requestPermissions(ScanPembeli.this, new String[]{Manifest.permission.CAMERA}, 1);

            }
        }


        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {

                try {
                    cameraSource.start(surfaceHolder);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            /*@Override
            public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
                if(requestCode == 1){
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        //cameraSource.start(surfaceView.getHolder());
                    }
                    else{
                        Toast.makeText(ScanPembeli.this,"GA DISETUJUI!",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    ScanPembeli.super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                }
            }*/

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes = detections.getDetectedItems();

                if(qrCodes.size()!=0)
                {

                    textView.post(new Runnable() {
                        @Override
                        public void run() {

                            Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(1000);
                            textView.setText(qrCodes.valueAt(0).displayValue);
                            String test = qrCodes.valueAt(0).displayValue.toString();
                            final String[] splitStr = test.split("\\s+");
                            cameraSource.stop();
                            AlertDialog.Builder alert1 = new AlertDialog.Builder(ScanPembeli.this);
                            alert1.setMessage("Penjual "+splitStr[0]+" Nominal "+splitStr[1]+"?").setCancelable(false)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i)
                                        {
                                            Retrofit retrofit = new Retrofit.Builder().baseUrl(BeliApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

                                            BeliApi api = retrofit.create(BeliApi.class);

                                            Call<ResponseBody> call = api.getBeli(data1,splitStr[0],splitStr[1],"Bearer "+data2);
                                            call.enqueue(new Callback<ResponseBody>() {
                                                @Override
                                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                                    if(response.isSuccessful()){
                                                        //loading.dismiss();
                                                        try {
                                                            JSONObject jsonRes = new JSONObject(response.body().string());
                                                            hasil1 = jsonRes.getString("_id");
                                                            hasil2 = jsonRes.getString("penjual");
                                                            hasil3 = jsonRes.getString("pembeli");
                                                            hasil4 = jsonRes.getString("tgl_transaksi");
                                                            hasil5 = jsonRes.getString("bulan_transaksi");
                                                            hasil6 = jsonRes.getString("tahun_transaksi");
                                                            hasil7 = jsonRes.getString("jumlah_transaksi");
                                                            hasil8 = jsonRes.getString("__v");
//                                                          Toast tost = Toast.makeText(getApplicationContext(), hasil1+hasil2+hasil3+hasil4+hasil5,Toast.LENGTH_LONG);
//                                                          tost.show();
                                                            Toast tost = Toast.makeText(getApplicationContext(),"Transaksi dengan Penjual : "+hasil2+" sejumlah : Rp "+hasil7+
                                                                    " pada tanggal "+hasil4+"-"+hasil5+"-"+hasil6+" \nBERHASIL !!!",Toast.LENGTH_LONG);
                                                            tost.show();
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

                                            Intent dashboard = new Intent(ScanPembeli.this,DashboardUser.class) ;
                                            dashboard.putExtra("param1",data1);
                                            dashboard.putExtra("param2",data2);

                                            startActivity(dashboard);
                                        }
                                    })
                                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i)
                                        {
                                            dialogInterface.cancel();
                                            try {
                                                cameraSource.start(surfaceView.getHolder());
                                                textView.setText("SCAN LAGI !!!");
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }

                                        }
                                    });
                            AlertDialog alert = alert1.create();
                            alert.setTitle("KONFIRMASI");
                            alert.show();



                        }
                    });
                }
            }
        });
    }
}
