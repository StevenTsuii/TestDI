package com.steven.testdi;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.steven.testdi.di.component.depend.ActivityComponent;
import com.steven.testdi.event.PopUpDialogEvent;
import com.steven.testdi.fragment.MainFragment;
import com.steven.testdi.fragment.TestFragment;
import com.steven.testdi.helper.DialogHelper;
import com.steven.testdi.helper.RxHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    EventBus mEventBus;

    @Inject
    Retrofit mRetrofit;

    @Inject
    @Named("domainUrl")
    String mDomainUrl;

    @Inject
    DialogHelper mDialogHelper;

    @Inject
    RxHelper mRxHelper;

    @BindView(R.id.container_frame_layout)
    FrameLayout mFragmentLayout;

    ActivityComponent mActivityComponent;


    @Override
    protected void onStart() {
        super.onStart();
        mEventBus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mEventBus.unregister(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mEventBus.post(new PopUpDialogEvent());
            }
        });

        //((StevenApplication) getApplication()).getNetComponent().inject(this);
        ((StevenApplication) getApplication()).getActivityComponent(this).inject(this);
        setTitle(BuildConfig.APPLICATION_ID);

        mRxHelper.disposable();

        String fragmentTag = "main";
        MainFragment mainFragment = (MainFragment) getFragmentManager().findFragmentByTag(fragmentTag);
        if (mainFragment == null) {
            mainFragment = new MainFragment();
        }
        getFragmentManager().beginTransaction().replace(R.id.container_frame_layout, mainFragment, fragmentTag).setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();


    }

    public class User {
        String name = "steven";

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPopUpDialogEvent(PopUpDialogEvent event) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
