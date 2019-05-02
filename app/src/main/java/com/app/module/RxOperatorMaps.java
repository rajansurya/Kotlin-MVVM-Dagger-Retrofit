package com.app.module;


import android.arch.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;


public class RxOperatorMaps {


    public static void main(String[] args) throws InterruptedException {
        final List<String> race = new ArrayList<>(Arrays.asList("Alan", "Bob", "Cobb", "Dan", "Evan", "Finch"));



        Observable.from(race)
                .flatMap(new Func1<String, Observable<?>>() {
                    @Override
                    public Observable<?> call(String s) {
                        final int delay = new Random().nextInt(5);

                        return Observable.just(s).map(new Func1<String, Object>() {
                            @Override
                            public Object call(String s) {
                                return s.toUpperCase();
                            }
                        }).delay(delay, TimeUnit.SECONDS);
                    }
                })
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        System.out.println(o.toString());
                    }
                });

        Thread.sleep(5000);

    }

}
