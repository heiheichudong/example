package com.gess.example.rxjava;

/**
 * 被观察者接口
 */
public interface ObservableSource<T> {
    void subscribe(Observer<T> observer);
}
