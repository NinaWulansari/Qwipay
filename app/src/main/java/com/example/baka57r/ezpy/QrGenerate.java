package com.example.baka57r.ezpy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QrGenerate extends AppCompatActivity {

    String data1,data2,data3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generate);

        Bundle bundle = getIntent().getExtras();

        data1 = bundle.getString("param1");
        data2 = bundle.getString("param2");
        data3 = bundle.getString("param4");

        String gabung = data1 + " " + data3;

        ImageView imageView = (ImageView) findViewById(R.id.qrnya);

        if (data3 != null) {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            try {
                BitMatrix bitMatrix = multiFormatWriter.encode(gabung, BarcodeFormat.QR_CODE, 400, 400);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                imageView.setImageBitmap(bitmap);
            } catch (WriterException r) {
                r.printStackTrace();
            }
        }

    }

    public void kembalikedash(View v)
    {
        Intent dashboard = new Intent(QrGenerate.this,DashboardPenjual.class) ;
        dashboard.putExtra("param1",data1);
        dashboard.putExtra("param2",data2);
        startActivity(dashboard);
    }
}
