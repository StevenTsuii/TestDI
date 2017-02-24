package com.steven.testdi.di.component.depend;

import android.support.v7.app.AppCompatActivity;

import com.steven.testdi.SecondActivity;
import com.steven.testdi.di.annotation.ActivityScope;
import com.steven.testdi.di.component.NetComponent;
import com.steven.testdi.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by steventsui on 24/2/2017.
 */

@ActivityScope
@Component(dependencies = NetComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SecondActivity secondActivity);

}
