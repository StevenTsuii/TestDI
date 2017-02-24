package com.steven.testdi.di.module;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.steven.testdi.di.annotation.ActivityScope;
import com.steven.testdi.helper.DialogHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by steventsui on 24/2/2017.
 */

@Module
public class ActivityModule {

    AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }


    @Provides
    @ActivityScope
    AppCompatActivity provideActivity(){
        return mActivity;
    }

    @Provides
    @ActivityScope
    DialogHelper provideDialogHelper(AppCompatActivity activity) {
        DialogHelper dialogHelper = new DialogHelper(activity);
        return dialogHelper;
    }

//    @Provides
//    @ActivityScope
//    FragmentManager provideFragmentManager(AppCompatActivity activity){
//        return activity.getFragmentManager();
//    }
//
//    if (findViewById(fragmentContainerId) != null && fragment != null) {
//        getFragmentManager().beginTransaction().replace(fragmentContainerId, fragment, tag).setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
//    }
}
