package com.zhainfotech.mvpdagger.mvp;

import com.zhainfotech.mvpdagger.model.Categories;
import com.zhainfotech.mvpdagger.mvp.base.BaseView;

import java.util.List;

public interface CategoryListView extends BaseView {

   void showCategoryList(List<Categories> categoryList);

   void showErrorMessage(String errorMessage);

   void showLoading();

   void hideLoading();
}
