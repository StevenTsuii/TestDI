package com.steven.testdi.di.component;

import android.os.Handler;

import com.steven.testdi.MainActivity;
import com.steven.testdi.di.component.subcomponent.ThirdSubcomponent;
import com.steven.testdi.di.module.ApplicationModule;
import com.steven.testdi.di.module.NetModule;
import com.steven.testdi.di.module.UserModule;

import org.greenrobot.eventbus.EventBus;

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

    //void inject(MainActivity activity);

    //Subcomponent
    ThirdSubcomponent plus(UserModule userModule);

    //Dependency component
    Retrofit retrofit();

    Handler handler();

    @Named("domainUrl")
    String domainUrl();

    EventBus eventBus();
}
