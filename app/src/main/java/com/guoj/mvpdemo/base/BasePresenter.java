package com.guoj.mvpdemo.base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    protected V view;
    protected M model;

    public BasePresenter() {
        model=createModel();
    }

    public void attachView(V view){
        this.view=view;
    }
    public void detachView(){
        this.view=null;
    }
    protected abstract M createModel();
}
