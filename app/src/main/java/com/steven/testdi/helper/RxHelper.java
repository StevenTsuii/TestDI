package com.steven.testdi.helper;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.SorterFunction;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by steventsui on 8/3/2017.
 */

public class RxHelper {

    static final String TAG = "RxHelper";

    public void disposable(){

        ArrayList<String> strings = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc"));
        Observable.just("a", "b", "c").subscribe(new DisposableObserver<String>() {
            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext:"+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }


//    public void faltMap() {
//        final ArrayList<DemoItem> demoItems = new ArrayList<>();
//        demoItems.add(new DemoItem());
//        demoItems.add(new DemoItem());
//        demoItems.add(new DemoItem());
//        demoItems.add(new DemoItem());
//        demoItems.add(new DemoItem());
//
//        Observable.create(new ObservableOnSubscribe<DemoItem>() {
//            @Override
//            public void subscribe(ObservableEmitter<DemoItem> e) throws Exception {
//                for (DemoItem demoItem : demoItems) {
//                    e.onNext(demoItem);
//                }
//                e.onComplete();
//            }
//        })
//                .flatMap(new Function<DemoItem, ObservableSource<ArrayList<String>>>() {
//            @Override
//            public ObservableSource<ArrayList<String>> apply(@NonNull DemoItem demoItem) throws Exception {
//                return Observable.just(demoItem.getContentMessages()).s;
//            }
//        }).subscribe(new Consumer<ArrayList<String>>() {
//            @Override
//            public void accept(@NonNull ArrayList<String> strings) throws Exception {
//                Log.d(TAG, "accept:" + strings.get(0));
//            }
//        });
//
//
//    }

    public void standardWithFrom() {
        Log.d(TAG, "start standardWithFrom...");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        Observable.fromArray(strings).map(new Function<ArrayList<String>, String>() {
            @Override
            public String apply(@NonNull ArrayList<String> strings) throws Exception {
                return strings.get(0);
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        });
        Log.d(TAG, "standardWithFrom end...");
    }

    public void mapDemo() {
        Log.d(TAG, "start mapDemo...");
        Observable<DemoItem> observable = Observable.create(new ObservableOnSubscribe<DemoItem>() {
            @Override
            public void subscribe(ObservableEmitter<DemoItem> e) throws Exception {
                e.onNext(new DemoItem());
                e.onNext(new DemoItem());
                e.onNext(new DemoItem());
                e.onNext(new DemoItem("Good evening", "Testing", 500));
                e.onNext(new DemoItem());
                e.onNext(new DemoItem());
                e.onNext(new DemoItem("Hello", "steven tsui", 99));
                e.onNext(new DemoItem("Good morning", "ST", 1000));
                e.onComplete();
            }
        });
        observable.map(new Function<DemoItem, String>() {
            @Override
            public String apply(@NonNull DemoItem demoItem) throws Exception {
                Log.d(TAG, "function1 apply...");
                return demoItem.getTitle() + demoItem.getAmount();
            }
        }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(@NonNull String s) throws Exception {
                Log.d(TAG, "function2 apply...");
                return s.length();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                Log.d(TAG, "Consumer intger: " + integer);
            }
        });


        //same as the top
//        Consumer<Integer> consumer = new Consumer<Integer>() {
//            @Override
//            public void accept(@NonNull Integer integer) throws Exception {
//
//            }
//        };

        Log.d(TAG, "end mapDemo...");

    }

    public void standardWithItemDemo() {
        Log.d(TAG, "start standardWithItemDemo...");
        Observable observable = Observable.just(new DemoItem(), new DemoItem(), new DemoItem(), new DemoItem("Hello", "steven tsui", 99));
        Observer<DemoItem> observer = new Observer<DemoItem>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(DemoItem demoItem) {
                Log.d(TAG, "onNext demoItem title:" + demoItem.getTitle() + "\nmessage:" + demoItem.getMessage() + "\namount:" + demoItem.getAmount());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
        observable.subscribe(observer);
        Log.d(TAG, "start standardWithItemDemo...");
    }

    public void standardWithJustDemo() {
        Log.d(TAG, "start standardWithJustDemo...");
        Observable<String> observable = Observable.just("just1", "just2", "just3", "just4");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext:" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
                Log.d(TAG, "standardWithJustDemo end...");
            }
        };
        observable.subscribe(observer);
    }

    public void standardDemo() {

        Log.d(TAG, "standardDemo start...");

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext :" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
                Log.d(TAG, "standardDemo end...");
            }
        };

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("A");
                e.onNext("B");
                e.onNext("C");
                e.onComplete();
            }
        });

        observable.subscribe(observer);
    }

    public class DemoItem {
        public String message = "default-Message";
        public String title = "default-Title";
        public int amount = 0;
        ArrayList<String> contentMessages = new ArrayList<>();

        public DemoItem() {
            contentMessages.add("content1");
            contentMessages.add("content2");
            contentMessages.add("content3");
            contentMessages.add("content4");
            contentMessages.add("content5");
        }

        public DemoItem(String title, String message, int amount) {
            this.title = title;
            this.message = message;
            this.amount = amount;
        }

        public ArrayList<String> getContentMessages() {
            return contentMessages;
        }

        public void setContentMessages(ArrayList<String> contentMessages) {
            this.contentMessages = contentMessages;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
