package com.zhainfotech.mvpdagger.mvp;

import com.zhainfotech.mvpdagger.model.Categories;
import com.zhainfotech.mvpdagger.model.Category;
import com.zhainfotech.mvpdagger.mvp.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public class CategoryListPresenterImpl implements CategoryListPresenter {

    private CategoryListView categoryListView;
    private CategoryListInteractor categoryListInteractor;

    public CategoryListPresenterImpl() {
        categoryListInteractor = new CategoryListInteractorImpl(this);
    }

    private void getCategoryList() {
        categoryListView.showLoading();
        categoryListInteractor.getFoodCategoryList();
    }

    @Override
    public void onCategorySelect(Category category) {

    }

    @Override
    public void onSuccess(List<Category> categoryList) {
        categoryListView.hideLoading();
        List<Categories> categories = new ArrayList<>();
        for(Category category : categoryList) {
            categories.add(category.getCategories());
        }
        categoryListView.showCategoryList(categories);
    }

    @Override
    public void onError(String errorMessage) {
        categoryListView.hideLoading();
        categoryListView.showErrorMessage(errorMessage);
    }

    @Override
    public void onActivityResume() {
        getCategoryList();
    }

    @Override
    public void onActivityPause() {

    }

    @Override
    public void onActivityDestroy() {

    }

    @Override
    public void setView(BaseView view) {
        categoryListView = (CategoryListView) view;
    }
}
