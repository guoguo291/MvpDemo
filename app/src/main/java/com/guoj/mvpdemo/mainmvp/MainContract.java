package com.guoj.mvpdemo.mainmvp;


import com.guoj.mvpdemo.App;
import com.guoj.mvpdemo.base.BaseModel;
import com.guoj.mvpdemo.base.BasePresenter;
import com.guoj.mvpdemo.base.BaseView;


public interface MainContract{
    interface MainModel extends BaseModel{
        void getData(Callback callback);
    }
    interface MainView extends BaseView {
       void showInfo(String info);
    }
    abstract class MainPresenter extends  BasePresenter<MainView,MainModel>{
        public void requestInfo(){
//            App.poolExecutor().execute(() -> model.getData(result -> {
//                view.showInfo(result);
//            }));
            model.getData(new Callback() {
                @Override
                public void onResult(String result) {
                    view.showInfo(result);
                }
            });
        }
    }
}
