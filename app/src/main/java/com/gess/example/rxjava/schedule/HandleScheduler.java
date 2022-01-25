package com.gess.example.rxjava.schedule;

import android.os.Handler;

public class HandleScheduler extends Scheduler{

    final Handler handler;

    public HandleScheduler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public Worker createWorker() {
        return new HandlerWork(handler);
    }

    class HandlerWork implements Worker{

        Handler handler;

        public HandlerWork(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void schedule(Runnable runnable) {
            handler.post(runnable);
        }
    }
}
