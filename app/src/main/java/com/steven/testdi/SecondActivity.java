package com.steven.testdi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.steven.testdi.di.component.depend.ActivityComponent;
import com.steven.testdi.di.component.depend.DaggerActivityComponent;
import com.steven.testdi.di.module.ActivityModule;
import com.steven.testdi.helper.DialogHelper;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit.Retrofit;

/**
 * Created by steventsui on 24/2/2017.
 */

public class SecondActivity extends AppCompatActivity {

    @Inject
    DialogHelper mDialogHelper;

    @Inject
    Retrofit mRetrofit;

    @Inject
    @Named("domainUrl")
    String mDomainUrl;

    ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivityComponent = DaggerActivityComponent.builder().netComponent(((StevenApplication) getApplication()).getNetComponent()).activityModule(new ActivityModule(this)).build();
        mActivityComponent.inject(this);
        mDialogHelper.showSingleButtonDialog("Dagger haha!!\n" + mDomainUrl, "Yeah");

    }
}
