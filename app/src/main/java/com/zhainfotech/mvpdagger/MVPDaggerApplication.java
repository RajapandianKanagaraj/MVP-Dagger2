package com.zhainfotech.mvpdagger;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;
import com.zhainfotech.mvpdagger.network.APIConstants;
import com.zhainfotech.mvpdagger.network.FoodService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MVPDaggerApplication extends Application {


    public void onCreate() {
        super.onCreate();
    }
}
