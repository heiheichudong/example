package com.gess.example.rxjava;

public interface ObservableOnSubscribe<T> {

    void subscribe(Emitter<T> emitter);

}
