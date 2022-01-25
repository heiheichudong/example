package com.gess.example.rxjava;

import com.gess.example.rxjava.schedule.Scheduler;

import org.jetbrains.annotations.NotNull;

public abstract class Observable<T> implements ObservableSource<T> {

    @Override
    public void subscribe(Observer<T> observer) {
        subscribeActual(observer);
    }

    /**
     * 和谁建立订阅？
     * 怎么建立订阅？
     * 为了保持拓展性，交给具体的开发人员去实现。这里提供一个抽象方法
     *
     * @param observer
     */
    protected abstract void subscribeActual(Observer<T> observer);


    public static <T> Observable<T> create(ObservableOnSubscribe<T> source){
        return new ObservableCreate<>(source);
    }

    public <U> ObservableMap<T,U> map(Function<T,U> function){
        return new ObservableMap<>(this,function);
    }

    public <U> ObservableFlatMap<T,U> flatmap(Function<T,ObservableSource<U>> function){
        return new ObservableFlatMap<>(this,function);
    }

    public ObservableSubscribeOn<T> subscribeOn(Scheduler scheduler){
        return new ObservableSubscribeOn<>(this,scheduler);
    }

    public ObservableObserverOn<T> observerOn(Scheduler scheduler){
        return new ObservableObserverOn<>(this,scheduler);
    }
}
