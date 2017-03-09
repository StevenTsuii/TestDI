package com.steven.testdi;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;
import com.steven.testdi.di.module.UserModule;
import com.steven.testdi.fragment.TestFragment;

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
        setContentView(R.layout.activity_third);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.steven_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setSubtitle("subtitle");

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new TestFragment()).setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();

        ((StevenApplication) getApplication()).getNetComponent().plus(new UserModule()).inject(this);

        setTitle("Third - " + mAndroidId);
    }
}
