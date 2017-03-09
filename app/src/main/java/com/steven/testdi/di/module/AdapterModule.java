package com.steven.testdi.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.steven.testdi.AbstractAdapter;
import com.steven.testdi.AbstractViewHolder;
import com.steven.testdi.R;
import com.steven.testdi.di.scope.FragmentScope;
import com.steven.testdi.di.scope.SessionScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by steventsui on 27/2/2017.
 */

@Module
public class AdapterModule {

    @FragmentScope
    @Provides
    int provideLayoutResId() {
        return R.layout.viewholder_test;
    }

    @FragmentScope
    @Provides
    View provideView(AppCompatActivity activity, int layoutResId) {

        return LayoutInflater.from(activity).inflate(layoutResId, null, false);

    }



    @FragmentScope
    @Provides
    AbstractAdapter provideAdapter(final AppCompatActivity activity, final int layoutResId) {
        AbstractAdapter adapter = new AbstractAdapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new AbstractViewHolder(LayoutInflater.from(activity).inflate(layoutResId, parent, false)) {

                    @Override
                    public void update(Object item, int position) {

                    }
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }
        };
        return adapter;
    }


}
