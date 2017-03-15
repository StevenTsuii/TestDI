package com.steven.testdi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.steven.testdi.di.component.depend.ActivityComponent;
import com.steven.testdi.di.component.depend.DaggerActivityComponent;
import com.steven.testdi.di.module.ActivityModule;
import com.steven.testdi.helper.DialogHelper;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    Handler mHandler;

    @Inject
    @Named("domainUrl")
    String mDomainUrl;

    @BindView(R.id.button3)
    Button mButton;

    ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mActivityComponent = DaggerActivityComponent.builder().netComponent(((StevenApplication) getApplication()).getNetComponent()).activityModule(new ActivityModule(this)).build();
        mActivityComponent.inject(this);
//        mDialogHelper.showSingleButtonDialog("Dagger haha!!\n" + mDomainUrl, "Yeah");

//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
//                startActivity(intent);
//            }
//        }, 2000);
        ButterKnife.bind(this);



    }

    @OnClick(R.id.button3)
    public void onClickButton() {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        startActivity(intent);
    }
}
