package com.steven.testdi.di.module;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by steventsui on 23/2/2017.
 */

@Module
public class ApplicationModule {

    Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Handler provideMainHandler() {
        return new Handler(Looper.getMainLooper());
    }


    @Provides
    @Singleton
    EventBus provideEventBus() {
        return EventBus.getDefault();
    }
}
