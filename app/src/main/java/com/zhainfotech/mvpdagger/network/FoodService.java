package com.zhainfotech.mvpdagger.network;

import com.zhainfotech.mvpdagger.model.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface FoodService {

    @Headers({
            APIConstants.USER_KEY_HEADER,
            APIConstants.ACCEPT_HEADER
    })
    @GET("categories")
    Call<CategoryResponse> getCategories();
}
