package com.guoj.mvpdemo;

import android.app.Application;

import java.util.concurrent.ThreadPoolExecutor;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
    public static ThreadPoolExecutor poolExecutor(){
        return MyThreadPool.getInstance();
    }
}
