package com.example.baka57r.ezpy;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by baka57r on 01/01/2019.
 */

public interface LoginApi {
    //String BASE_URL = "http://ezpy.advlop.com/api/v1/user/";
    String BASE_URL = "http://10.10.29.160:3040/api/v1/user/";

    @FormUrlEncoded
    @POST("LoginApi")
    Call<ResponseBody> getLogin(@Field("email") String user,
                                @Field("password") String password);
}