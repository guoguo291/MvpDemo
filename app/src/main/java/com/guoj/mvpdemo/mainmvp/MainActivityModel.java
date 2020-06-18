package com.guoj.mvpdemo.mainmvp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivityModel implements MainContract.MainModel {
    private OkHttpClient client;

    @Override
    public void getData(Callback callback) {
        if (client==null){
            client=new OkHttpClient();
        }
        Request request=new Request.Builder()
                .url("https://apis.juhe.cn/mobile/get?phone=18410402661&key=7444e1cc1db7a6679ca9c990228437b8")
                .build();
        Call call =client.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    callback.onResult(response.body().string());
            }
        });
    }
}
