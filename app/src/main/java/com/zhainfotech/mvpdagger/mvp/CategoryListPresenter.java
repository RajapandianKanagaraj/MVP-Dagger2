package com.zhainfotech.mvpdagger.mvp;

import com.zhainfotech.mvpdagger.model.Categories;
import com.zhainfotech.mvpdagger.model.Category;
import com.zhainfotech.mvpdagger.mvp.base.BasePresenter;

import java.util.List;

public interface CategoryListPresenter extends BasePresenter {

    void onCategorySelect(Category category);

    void onSuccess(List<Category> categoryList);

    void onError(String errorMessage);
}
