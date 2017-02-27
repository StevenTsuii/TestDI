package com.steven.testdi.di.component.subcomponent;

import com.steven.testdi.TestFragment;
import com.steven.testdi.di.module.AdapterModule;
import com.steven.testdi.di.scope.FragmentScope;

import dagger.Subcomponent;

/**
 * Created by steventsui on 27/2/2017.
 */

@FragmentScope
@Subcomponent(modules = {AdapterModule.class})
public interface FragmentComponent {
    void inject(TestFragment testFragment);
}
