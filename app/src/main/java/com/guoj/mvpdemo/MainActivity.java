package com.guoj.mvpdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.guoj.mvpdemo.Utils.Util;
import com.guoj.mvpdemo.databinding.ActivityMainBinding;
import com.guoj.mvpdemo.mainmvp.MainActivityModel;
import com.guoj.mvpdemo.mainmvp.MainContract;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {
    private ActivityMainBinding binding;
    private MainContract.MainPresenter presenter;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            binding.tvInfo.setText((CharSequence) msg.obj);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initPresenter();
        initEvent();

    }

    private void initPresenter() {
        presenter=new MainContract.MainPresenter() {
            @Override
            protected MainContract.MainModel createModel() {
                return new MainActivityModel();
            }
        };
        presenter.attachView(this);
    }

    private void initEvent() {
        binding.button.setOnClickListener(view ->presenter.requestInfo());
    }

    @Override
    public void showInfo(final String info) {
        Message message=new Message();
        message.obj=info;
        handler.sendMessage(message);
    }

    @Override
    public void showError(String error) {
        Util.toast(this,error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}