package com.gess.example.rxjava;

public interface Function<T, U> {
    U apply(T t);
}
