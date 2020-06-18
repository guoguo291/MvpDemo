package com.guoj.mvpdemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyThreadPool extends ThreadPoolExecutor {
    private MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
    private static class MyThreadPoolHolder{
        private static final MyThreadPool INSTANCE=new MyThreadPool(2,5,60,TimeUnit.SECONDS,new LinkedBlockingDeque<>(5));
    }
    public static MyThreadPool getInstance(){
        return MyThreadPoolHolder.INSTANCE;
    }
}
