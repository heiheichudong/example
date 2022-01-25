package com.gess.example.rxjava.schedule;

import java.util.concurrent.ExecutorService;

public class ThreadScheduler extends Scheduler{
    private ExecutorService executorService;

    public ThreadScheduler(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public Worker createWorker() {
        return new ThreadWorker(executorService);
    }

    class ThreadWorker implements Worker{
        private ExecutorService executorService;

        public ThreadWorker(ExecutorService executorService) {
            this.executorService = executorService;
        }

        @Override
        public void schedule(Runnable runnable) {
            executorService.execute(runnable);
        }
    }
}
