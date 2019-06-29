package com.example.baka57r.ezpy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by baka57r on 09/11/2018.
 */

public interface HeroApi {

    String BASE_URL = "https://www.simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Heroretro>> getHeroes();

}
