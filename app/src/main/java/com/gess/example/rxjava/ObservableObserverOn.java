package com.gess.example.rxjava;

import com.gess.example.rxjava.schedule.Scheduler;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ObservableObserverOn<T> extends AbstractObservableWithUpStream<T, T> {

    final Scheduler scheduler;

    public ObservableObserverOn(ObservableSource<T> source, Scheduler scheduler) {
        super(source);
        this.scheduler = scheduler;
    }


    @Override
    protected void subscribeActual(Observer<T> observer) {
        observer.onSubscribe();
        Scheduler.Worker worker = scheduler.createWorker();
        ObserveOnObserver observerOn = new ObserveOnObserver(worker,observer);
        source.subscribe(observerOn);
    }

    static final class ObserveOnObserver<T> implements Observer<T>, Runnable {
        final Scheduler.Worker worker;
        final Observer<T> observer;
        final Queue<T> queue;

        volatile boolean done;
        volatile Throwable throwable;
        volatile boolean over;

        public ObserveOnObserver(Scheduler.Worker worker, Observer<T> observer) {
            this.worker = worker;
            this.observer = observer;
            this.queue = new ArrayDeque<>();
        }

        @Override
        public void onSubscribe() {

        }

        @Override
        public void onNext(T t) {
            queue.offer(t);
            schedule();
        }

        private void schedule() {
            worker.schedule(this);
        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void run() {
            drainNormal();
        }

        private void drainNormal() {
            final Queue<T> q = queue;
            final Observer<T> a = observer;

            while (true){
                boolean d = done;
                T t = q.poll();
                boolean empty = t==null;
                if (checkTerminal(d,empty,a)){
                    return;
                }
                if (empty){
                    break;
                }
                a.onNext(t);
            }
        }

        private boolean checkTerminal(boolean d, boolean empty, Observer<T> a) {
            if (over){
                queue.clear();
                return true;
            }
            if (d){
                Throwable t = throwable;
                if (t != null){
                    over = true;
                    a.onError(t);
                }else if (empty){
                    over = true;
                    a.onComplete();
                    return true;
                }
            }
            return false;
        }
    }
}
