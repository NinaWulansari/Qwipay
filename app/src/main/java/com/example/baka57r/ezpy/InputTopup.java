package com.example.baka57r.ezpy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class InputTopup extends AppCompatActivity {

    String angkatampung = "";
    String aaaa = "";
    EditText editText;
    String data1,data2,data3,data4,data5;

    String value1, value2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_topup);

        Bundle bundle = getIntent().getExtras();

        editText = (EditText)findViewById(R.id.TextInputTopup);

        data1 = bundle.getString("param1"); //nama
        data2 = bundle.getString("param2"); //token
        data3 = bundle.getString("param3"); //role
        data4 = bundle.getString("param4"); //email
        data5 = bundle.getString("param5"); //id

        Log.i("TAG", "datetopup: "+data1 + " "+data2 + " "+data3+ " "+data4 + " "+data5);
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

    public void isi_topup(View v)
    {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(TopUp.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        TopUp api = retrofit.create(TopUp.class);

        String nominal = editText.getText().toString();


//        SharedPreferences prefs = getSharedPreferences("DataUser", MODE_PRIVATE);
//
//        String name = prefs.getString("name", "");//"No name defined" is the default value.
//        String email = prefs.getString("email", "");//"No name defined" is the default value.

//        Toast tost = Toast.makeText(getApplicationContext(),"name :" + name + "email: "+ email + "token" +data2 ,Toast.LENGTH_LONG);
//        tost.show();

        Call<ResponseBody> call = api.getTopup(data4, nominal,"Bearer "+data2);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast tost = Toast.makeText(getApplicationContext(),"success :" +response ,Toast.LENGTH_LONG);
                tost.show();
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

        Intent dashboard = new Intent(InputTopup.this,DashboardUser.class) ;
        dashboard.putExtra("param1", data1);
        dashboard.putExtra("param2", data2);
        dashboard.putExtra("param3", data3);
        dashboard.putExtra("param4", data4);
        dashboard.putExtra("param5", data5);
        startActivity(dashboard);
    }
}
