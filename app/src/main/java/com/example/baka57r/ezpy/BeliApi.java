package com.example.baka57r.ezpy;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by baka57r on 06/01/2019.
 */

public interface BeliApi {
//    String BASE_URL = "http://192.168.100.169:3000/api/v1/";
    String BASE_URL = "http://10.10.29.160:3040/api/v1/";

    @FormUrlEncoded
    @POST("transaksi")
    Call<ResponseBody> getBeli(@Field("pembeli") String user,
                                @Field("penjual") String penjuall,
                                @Field("nominal") String nominall,
                                @Header("Authorization") String auths);
}
