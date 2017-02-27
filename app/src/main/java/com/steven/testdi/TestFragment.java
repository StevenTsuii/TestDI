package com.steven.testdi;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.steven.testdi.di.component.depend.DaggerActivityComponent;
import com.steven.testdi.di.module.ActivityModule;
import com.steven.testdi.di.module.AdapterModule;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by steventsui on 27/2/2017.
 */

public class TestFragment extends Fragment {

    @Inject
    AbstractAdapter mAdapter;

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DaggerActivityComponent.builder().netComponent(((StevenApplication) getActivity().getApplication()).getNetComponent()).activityModule(new ActivityModule((ThirdActivity) getActivity())).build().plus(new AdapterModule()).inject(this);


//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL, false);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return 1;
//            }
//        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("a");
        strings.add("a");
        strings.add("a");
        mAdapter.setContentList(strings);
        mRecyclerView.setAdapter(mAdapter);
    }
}
