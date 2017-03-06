package com.steven.testdi;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.steven.testdi.di.component.DaggerNetComponent;
import com.steven.testdi.di.component.NetComponent;
import com.steven.testdi.di.component.depend.ActivityComponent;
import com.steven.testdi.di.component.depend.DaggerActivityComponent;
import com.steven.testdi.di.module.ActivityModule;
import com.steven.testdi.di.module.ApplicationModule;
import com.steven.testdi.di.module.NetModule;

/**
 * Created by steventsui on 23/2/2017.
 */

public class StevenApplication extends Application {

    private NetComponent mNetComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder().applicationModule(new ApplicationModule(this)).netModule(new NetModule("http://steventsui.com")).build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public ActivityComponent getActivityComponent(AppCompatActivity activity) {
        return DaggerActivityComponent.builder().netComponent(getNetComponent()).activityModule(new ActivityModule(activity)).build();
    }
}
