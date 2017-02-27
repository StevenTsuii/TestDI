package com.steven.testdi.di.component.subcomponent;

import com.steven.testdi.ThirdActivity;
import com.steven.testdi.di.module.AdapterModule;
import com.steven.testdi.di.module.UserModule;
import com.steven.testdi.di.scope.SessionScope;

import dagger.Subcomponent;

/**
 * Created by steventsui on 27/2/2017.
 */

@SessionScope
@Subcomponent(modules = {UserModule.class})
public interface ThirdSubcomponent {
    void inject(ThirdActivity thirdActivity);
}
