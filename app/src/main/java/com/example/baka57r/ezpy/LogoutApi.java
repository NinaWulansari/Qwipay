package com.example.baka57r.ezpy;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by baka57r on 06/01/2019.
 */

public interface LogoutApi {
    //String BASE_URL = "http://ezpy.advlop.com/api/v1/user/";
    String BASE_URL = "http://10.10.29.160:3040/api/v1/user/";

    //@FormUrlEncoded
    @GET("logoutApi")
    Call<ResponseBody> getOut(@Header("Authorization") String auths);
}
