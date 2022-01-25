package com.gess.example.rxjava;

import com.gess.example.rxjava.schedule.Scheduler;

public class ObservableSubscribeOn<T> extends AbstractObservableWithUpStream<T,T>{

    final Scheduler scheduler;

    public ObservableSubscribeOn(ObservableSource<T> source, Scheduler scheduler) {
        super(source);
        this.scheduler = scheduler;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        Scheduler.Worker worker = scheduler.createWorker();
        worker.schedule(new SubscribeTask(new ScheduleObserver<T>(observer)));
    }

    class ScheduleObserver<T> implements Observer<T> {
        final Observer<T> observer;

        public ScheduleObserver(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onSubscribe() {

        }

        @Override
        public void onNext(T t) {
            observer.onNext(t);
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }

        @Override
        public void onError(Throwable t) {
            observer.onError(t);
        }
    }

    class SubscribeTask implements Runnable{

        ScheduleObserver<T> observer;

        public SubscribeTask(ScheduleObserver<T> observer) {
            this.observer = observer;
        }

        @Override
        public void run() {
            source.subscribe(observer);
        }
    }

}
