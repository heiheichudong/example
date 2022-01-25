package com.gess.example.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blankj.utilcode.util.LogUtils
import com.gess.example.R

class RxjavaActivity : AppCompatActivity() {
    companion object{
        const val TAG = "=== rxjava ==="
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava)
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(12)
        }).subscribe(object : Observer<Int>{
            override fun onSubscribe() {
                LogUtils.e(TAG,"onSubscribe === ")
            }

            override fun onNext(t: Int?) {
                LogUtils.e(TAG,"onSubscribe === $t")
            }

            override fun onComplete() {
                LogUtils.e(TAG,"onComplete === ")
            }

            override fun onError(t: Throwable?) {
                LogUtils.e(TAG,"onError === $t")
            }
        })
    }
}