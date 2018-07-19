package com.zhainfotech.mvpdagger.mvp;

import com.zhainfotech.mvpdagger.model.CategoryResponse;
import com.zhainfotech.mvpdagger.network.APIAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryListInteractorImpl implements CategoryListInteractor {

    private CategoryListPresenter listPresenter;

    public CategoryListInteractorImpl(CategoryListPresenter listPresenter) {
        this.listPresenter = listPresenter;
    }

    @Override
    public void getFoodCategoryList() {
        APIAdapter.getInstance().getFoodService().getCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if(response.isSuccessful()) {
                    CategoryResponse categories = response.body();
                    listPresenter.onSuccess(categories.getCategories());
                } else {
                    listPresenter.onError("Unable to get Category list");
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                listPresenter.onError("Unable to get Category list");
            }
        });
    }
}
