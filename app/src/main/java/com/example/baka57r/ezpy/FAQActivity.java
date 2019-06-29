package com.example.baka57r.ezpy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FAQActivity extends AppCompatActivity {
    ExpandableListView expListView;
    DetailFAQAdapter listAdapter;
    HashMap<String, List<String>> listDataChild;
    private android.support.v7.widget.Toolbar toolbar;
    private android.widget.TextView title;
    private android.widget.ImageButton faq;
    private android.widget.ImageButton cancel;

    public String[] listDataHeader = {
            "Apa saya harus menggunakan e-mail utama?", "Mengapa e-mail saya dianggap tidak valid?",
            "Apa saya harus memberikan nomor handphone?", "Mengapa no. handphone saya dianggap tidak valid?",
    };

    public String[] dataAnswer = {
            "Dalam proses registrasi, mohon gunakan E-mail aktif/paling sering digunakan. E-mail tersebut akan digunakan untuk masuk ke Qwipay",
            "Pastikan kamu menggunakan E-mail aktif dengan penulisan yang lengkap.\nContoh: Qwipay-help@qwipay.com",
            "Ya, Harus no Handphone dibutuhkan dalam proses register akun qwipay",
            "Pastikan kamu menggunakan nomor aktif dengan format penulisan +62xxx atau 08xxx",
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_ic);
        title = (android.widget.TextView) findViewById(R.id.titleSearch);
        faq = (android.widget.ImageButton) findViewById(R.id.faq_button);
        cancel = (android.widget.ImageButton) findViewById(R.id.cancel_button);

        faq.setVisibility(android.view.View.GONE);
        cancel.setVisibility(android.view.View.INVISIBLE);

        title.setText("Bantuan");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;


        expListView.setIndicatorBounds(width - GetPixelFromDips(50), width - GetPixelFromDips(10));

        listDataChild = new HashMap<String, List<String>>();

        for (int i = 0; i < listDataHeader.length; i++) {
            String answers = dataAnswer[i];
            String questions = listDataHeader[i];

            List<String> restData = new ArrayList<String>();
            restData.add(answers);

            listDataChild.put(questions, restData);
            listAdapter = new DetailFAQAdapter(FAQActivity.this, Arrays.asList(listDataHeader), listDataChild);
            expListView.setAdapter(listAdapter);
        }
    }

    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
}
