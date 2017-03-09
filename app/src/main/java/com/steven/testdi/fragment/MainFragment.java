package com.steven.testdi.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.steven.testdi.MainActivity;
import com.steven.testdi.R;
import com.steven.testdi.StevenApplication;

/**
 * Created by steventsui on 9/3/2017.
 */


public class MainFragment extends Fragment {

    static final String TAG = "MainFragment";
    int value = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        Log.d(TAG, "onCreateView value:"+value);
        value += 1;
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        ((StevenApplication) getActivity().getApplication()).getFragmentComponent((MainActivity) getActivity()).inject(this);
        value += 1;
        Log.d(TAG, "onViewCreated value:"+value);
    }
}
