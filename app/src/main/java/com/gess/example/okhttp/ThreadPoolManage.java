package com.gess.example.okhttp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManage {

    private static  ThreadPoolManage instance;

    public static ThreadPoolManage getInstance() {
        if (instance == null){
            synchronized (ThreadPoolManage.class){
                if (instance == null){
                    instance = new ThreadPoolManage();
                }
            }
        }
        return instance;
    }

    private LinkedBlockingQueue<Runnable> mQueue = new LinkedBlockingQueue<>();

    public void addTask(Runnable runnable){
        try{
            mQueue.put(runnable);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private ThreadPoolExecutor mExecutor;

    private ThreadPoolManage() {
        mExecutor = new ThreadPoolExecutor(3, 15, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(4), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                addTask(r);
            }
        });
        mExecutor.execute(coreThread);
    }

    public Runnable coreThread = new Runnable() {
        Runnable runnable;
        @Override
        public void run() {
            while (true){
                try {
                    runnable = mQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mExecutor.execute(runnable);
            }
        }
    };
}
