package com.steven.testdi.di.component.depend;

import com.steven.testdi.SecondActivity;
import com.steven.testdi.di.component.subcomponent.FragmentComponent;
import com.steven.testdi.di.module.AdapterModule;
import com.steven.testdi.di.module.UserModule;
import com.steven.testdi.di.scope.ActivityScope;
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

    FragmentComponent plus(AdapterModule adapterModule);

}
