package com.zhainfotech.mvpdagger.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIAdapter {

    private FoodService foodService;
    private static APIAdapter instance;

    public static APIAdapter getInstance() {
        if(instance == null) {
            instance = new APIAdapter();
        }
        return instance;
    }

    public APIAdapter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

//        Picasso picasso = new Picasso.Builder(this).build();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        foodService = retrofit.create(FoodService.class);
    }

    public FoodService getFoodService() {
        return foodService;
    }
}
