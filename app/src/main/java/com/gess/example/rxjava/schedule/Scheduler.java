package com.gess.example.rxjava.schedule;

public abstract class Scheduler {

    public abstract Worker createWorker();

    public interface Worker{
        void schedule(Runnable runnable);
    }
}
