package com.steven.testdi.di.component;

import com.steven.testdi.MainActivity;
import com.steven.testdi.di.module.ApplicationModule;
import com.steven.testdi.di.module.NetModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import retrofit.Retrofit;

/**
 * Created by steventsui on 23/2/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface NetComponent {

    void inject(MainActivity activity);

    Retrofit retrofit();

    @Named("domainUrl")
    String domainUrl();
}
