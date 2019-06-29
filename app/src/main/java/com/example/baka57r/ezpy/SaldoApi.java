package com.example.baka57r.ezpy;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by baka57r on 01/01/2019.
 */

public interface SaldoApi {
    //String BASE_URL = "http://192.168.100.169:3000/api/v1/saldo/";
    String BASE_URL = "http://10.10.29.160:3040/api/v1/saldo/";

    //@FormUrlEncoded
    @GET("{email}")
//    Call<ResponseBody> getSaldo(@Path(value = "nama",encoded = true) String name,@Header("Authorization") String auths);
    Call<ResponseBody> getSaldo(@Path("email") String nama, @Header("Authorization") String auths);
}





















