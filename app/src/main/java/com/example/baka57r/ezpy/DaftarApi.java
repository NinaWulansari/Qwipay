package com.example.baka57r.ezpy;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by baka57r on 03/01/2019.
 */

public interface DaftarApi {
//    String BASE_URL = "http://ezpy.advlop.com/api/v1/user/";
    String BASE_URL = "http://10.10.29.160:3040/api/v1/user/";

    @FormUrlEncoded
    @POST("create")
    Call<ResponseBody> getDaftar(@Field("name") String namaa,
                                @Field("email") String emaill,
                                @Field("password") String passwordd,
                                @Field("role") String rolee);
}
