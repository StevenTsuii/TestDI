package com.steven.testdi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.steven.testdi.di.component.DaggerNetComponent;
import com.steven.testdi.di.component.NetComponent;
import com.steven.testdi.di.component.subcomponent.ThirdSubcomponent;
import com.steven.testdi.di.module.NetModule;
import com.steven.testdi.di.module.UserModule;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit.Retrofit;

/**
 * Created by steventsui on 27/2/2017.
 */

public class ThirdActivity extends AppCompatActivity {

    @Inject
    @Named("androidId")
    String mAndroidId;

    @Inject
    Retrofit mRetrofit;

    @Inject
    Gson mGson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((StevenApplication) getApplication()).getNetComponent().plus(new UserModule()).inject(this);

        setTitle("Third - " + mAndroidId);
    }
}
