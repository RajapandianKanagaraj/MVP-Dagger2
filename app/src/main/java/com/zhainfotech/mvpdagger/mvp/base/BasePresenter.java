package com.zhainfotech.mvpdagger.mvp.base;

public interface BasePresenter {

    void onActivityResume();

    void onActivityPause();

    void onActivityDestroy();

    void setView(BaseView view);
}
