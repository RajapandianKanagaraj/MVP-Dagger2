package com.zhainfotech.mvpdagger.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhainfotech.mvpdagger.R;
import com.zhainfotech.mvpdagger.model.Categories;
import com.zhainfotech.mvpdagger.mvp.CategoryListPresenter;
import com.zhainfotech.mvpdagger.mvp.CategoryListPresenterImpl;
import com.zhainfotech.mvpdagger.mvp.CategoryListView;
import com.zhainfotech.mvpdagger.ui.adapter.CategoryListAdapter;
import com.zhainfotech.mvpdagger.ui.listeners.OnCategorySelectLisener;

import java.util.ArrayList;
import java.util.List;

public class CategoryListActivity extends AppCompatActivity implements CategoryListView, OnCategorySelectLisener {

    private RecyclerView categoryListView;
    private CategoryListAdapter categoryListAdapter;
    private List<Categories> categoryList = new ArrayList<>();
    private CategoryListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        presenter = new CategoryListPresenterImpl();
        presenter.setView(this);
        categoryListView = findViewById(R.id.category_list_view);
        categoryListView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showCategoryList(List<Categories> categoryList) {
        this.categoryList = categoryList;
        categoryListAdapter = new CategoryListAdapter(categoryList);
        categoryListView.setAdapter(categoryListAdapter);
    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    public void onResume() {
        super.onResume();
        presenter.onActivityResume();
    }

    public void onPause() {
        super.onPause();
        presenter.onActivityPause();
    }

    public void onDestroy() {
        super.onDestroy();
        presenter.onActivityDestroy();
    }

    @Override
    public void onCategorySelect(Categories category) {

    }
}
