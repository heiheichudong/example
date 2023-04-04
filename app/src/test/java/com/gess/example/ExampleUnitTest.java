package com.gess.example;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import kotlin.jvm.Synchronized;
import okhttp3.OkHttpClient;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        int a = 10;
        System.out.println("a1 = " + a);
        int b = ++a;
        System.out.println("a2 = " + a);
        System.out.println("b = " + b);
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testHash() {
        System.out.println("hello world".hashCode());
    }


    private volatile int race = 0;
    private CountDownLatch countDownLatch = new CountDownLatch(2);

    @Test
    public void testCount() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                int ti = 0;
                for (int j = 0; j < 10000; j++) {
                    ti++;
                    System.out.println(Thread.currentThread().getName());
                    synchronized (CountDownLatch.class) {
                        race++;
                    }
                }

                System.out.println("->" + ti);
                countDownLatch.countDown();
                System.out.println(countDownLatch.getCount());
            }).start();
        }
        countDownLatch.await();
        System.out.println(race);
    }

    @Test
    public void testCount2() {
        countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 25; i++) {
            countDownLatch.countDown();
            System.out.println(countDownLatch.getCount());
        }
    }

    private static Object object = new Object();

    @Test
    public void testStop()  {
        Runnable runnable = () -> {
            synchronized (object) {
                System.out.println("执行线程" + Thread.currentThread().getName());
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread t2 = new Thread(runnable);
        t2.start();

        t2.interrupt();

        System.out.println("t1 = "+t1.getState());
        System.out.println("t2 = "+t2.getState());
    }
}