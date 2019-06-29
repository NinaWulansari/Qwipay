package com.example.baka57r.ezpy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InputTransaksiPenjual extends AppCompatActivity {

    String angkatampung = "";
    String aaaa = "";
    EditText editText;
    String data1,data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_transaksi_penjual);

        Bundle bundle = getIntent().getExtras();

        editText = (EditText)findViewById(R.id.TextInputJual);

        data1 = bundle .getString("param1");
        data2 = bundle .getString("param2");
        /*
        final ListView listView = findViewById(R.id.listcoba);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(HeroApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        HeroApi api = retrofit.create(HeroApi.class);

        Call<List<Heroretro>> call = api.getHeroes();

        call.enqueue(new Callback<List<Heroretro>>() {
            @Override
            public void onResponse(Call<List<Heroretro>> call, Response<List<Heroretro>> response) {
                List<Heroretro> heroes = response.body();
                String[] heroNames = new String[heroes.size()+10];
                String[] heroRealNames = new String[heroes.size()+10];

                for(int i = 0; i < (heroes.size()+10); i++) {
                    if (i < heroes.size()) {
                        heroNames[i] = heroes.get(i).getName();
                        heroRealNames[i] = heroes.get(i).getRealname();
                    } else {
                        heroNames[i] = "aku juga test" + String.valueOf(i);
                        heroRealNames[i] = "unknown";
                    }
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,heroRealNames));
            }

            @Override
            public void onFailure(Call<List<Heroretro>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        */
    }

    public void insatu(View v)
    {
        angkatampung = angkatampung+"1";
        editText.setText(angkatampung);
    }
    public void indua(View v)
    {
        angkatampung = angkatampung+"2";
        editText.setText(angkatampung);
    }
    public void intiga(View v)
    {
        angkatampung = angkatampung+"3";
        editText.setText(angkatampung);
    }
    public void inempat(View v)
    {
        angkatampung = angkatampung+"4";
        editText.setText(angkatampung);
    }
    public void inlima(View v)
    {
        angkatampung = angkatampung+"5";
        editText.setText(angkatampung);
    }
    public void inenam(View v)
    {
        angkatampung = angkatampung+"6";
        editText.setText(angkatampung);
    }
    public void intujuh(View v)
    {
        angkatampung = angkatampung+"7";
        editText.setText(angkatampung);
    }
    public void indelapan(View v)
    {
        angkatampung = angkatampung+"8";
        editText.setText(angkatampung);
    }
    public void insembilan(View v)
    {
        angkatampung = angkatampung+"9";
        editText.setText(angkatampung);
    }
    public void insepuluh(View v)
    {
        angkatampung = angkatampung+"0";
        editText.setText(angkatampung);
    }
    public void hps(View v)
    {
        if (angkatampung.length() >1 ) {
            angkatampung = angkatampung.substring(0, angkatampung.length() - 1);
            editText.setText(angkatampung);
        }
        else if (angkatampung.length() <=1 ) {
            angkatampung = "";
            editText.setText("");
        }
    }

    public void tampil_qrcode(View v)
    {
        Intent dashboard = new Intent(InputTransaksiPenjual.this,QrGenerate.class) ;
        dashboard.putExtra("param1",data1);
        dashboard.putExtra("param2",data2);
        dashboard.putExtra("param4",angkatampung);
        startActivity(dashboard);
    }

}
