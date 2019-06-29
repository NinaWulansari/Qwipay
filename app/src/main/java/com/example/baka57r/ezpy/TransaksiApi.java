package com.example.baka57r.ezpy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by baka57r on 05/01/2019.
 */

public interface TransaksiApi {
    //String BASE_URL = "http://ezpy.advlop.com/api/v1/transaksi/";
    String BASE_URL = "http://10.10.29.160:3040/api/v1/transaksi/";

    //@FormUrlEncoded
    @GET("tanggal")
    Call<List<TransaksiEzpy>> getTransaksi(@Query("pembeli") String name, @Header("Authorization") String auths);

    @GET("tanggal")
    Call<List<TransaksiEzpy>> getTransaksi2(@Query("penjual") String name, @Header("Authorization") String auths);
}