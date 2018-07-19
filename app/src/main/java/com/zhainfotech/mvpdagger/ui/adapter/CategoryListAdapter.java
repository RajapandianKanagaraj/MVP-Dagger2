package com.zhainfotech.mvpdagger.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhainfotech.mvpdagger.R;
import com.zhainfotech.mvpdagger.model.Categories;
import com.zhainfotech.mvpdagger.ui.listeners.OnCategorySelectLisener;

import java.util.ArrayList;
import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryItemView> {

    private List<Categories> categoryList = new ArrayList<>();
    private OnCategorySelectLisener onCategorySelectLisener;

    public class CategoryItemView extends RecyclerView.ViewHolder{

        private View itemView;
        private TextView categoryNameView;

        public CategoryItemView(View view) {
            super(view);
            itemView = view;
            categoryNameView = itemView.findViewById(R.id.category_name);

        }

        public void bindView(int position) {
            final Categories category = categoryList.get(position);
            categoryNameView.setText(category.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCategorySelectLisener.onCategorySelect(category);
                }
            });
        }
    }

    public CategoryListAdapter(List<Categories> categoryList) {
        this.categoryList = categoryList;
    }
    @NonNull
    @Override
    public CategoryListAdapter.CategoryItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new CategoryItemView(layoutInflater.inflate(R.layout.category_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemView holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setOnCategorySelectLisener(OnCategorySelectLisener onCategorySelectLisener) {
        this.onCategorySelectLisener = onCategorySelectLisener;
    }
}
