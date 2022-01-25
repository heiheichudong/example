package com.gess.example.rxjava;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.R;
import com.gess.example.rxjava.schedule.Schedulers;

public class RxActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(Emitter<Object> emitter) {
                emitter.onNext("1111");
                emitter.onNext("2222");
                emitter.onNext(333);
            }
        })
                /*.map(new Function<Object, Object>() {
                    @Override
                    public Object apply(Object o) {
                        return "sss";
                    }
                })*/
                .flatmap(new Function<Object, ObservableSource<Object>>() {
                    @Override
                    public ObservableSource<Object> apply(final Object o) {
                        return Observable.create(new ObservableOnSubscribe<Object>() {
                            @Override
                            public void subscribe(Emitter<Object> emitter) {
                                emitter.onNext("修改后 = "+o);
                            }
                        });
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe() {
                        LogUtils.e("onSubscribe ===");
                    }

                    @Override
                    public void onNext(Object o) {
                        LogUtils.e("onNext === " + o);
                    }

                    @Override
                    public void onComplete() {
                        LogUtils.e("onComplete ===");
                    }

                    @Override
                    public void onError(Throwable t) {
                        LogUtils.e("onError === " + t);
                    }
                });
    }
}
