package com.gess.example.rxjava;

public interface Emitter<T> {

    void onNext(T t);

    void onComplete();

    void onError(Throwable t);

}
