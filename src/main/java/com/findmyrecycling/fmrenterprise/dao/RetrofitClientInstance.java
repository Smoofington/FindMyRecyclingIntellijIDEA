package com.findmyrecycling.fmrenterprise.dao;

import org.springframework.data.repository.NoRepositoryBean;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    
    private static String BASE_URL = "https://github.com/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            String BASE_URL = "";
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
}
