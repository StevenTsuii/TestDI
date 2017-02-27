package com.steven.testdi.di.module;

import android.app.Application;
import android.provider.Settings;

import com.steven.testdi.di.scope.SessionScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by steventsui on 27/2/2017.
 */

@Module
public class UserModule {

    @SessionScope
    @Provides
    @Named("androidId")
    String provideAndroidId(Application application) {
        return android.provider.Settings.System.getString(application.getContentResolver(), Settings.Secure.ANDROID_ID);
    }
}
