package com.gess.example.rxjava;

/**
 * 观察者接口
 */
public interface Observer<T> {

    void onSubscribe();

    void onNext(T t);

    void onComplete();

    void onError(Throwable t);
}
