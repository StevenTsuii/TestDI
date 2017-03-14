package com.steven.testdi.fragment;

import android.app.Fragment;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.steven.testdi.MainActivity;
import com.steven.testdi.R;
import com.steven.testdi.StevenApplication;
import com.steven.testdi.databinding.FragmentMainBinding;
import com.steven.testdi.viewmodel.MainFragmentViewModel;

/**
 * Created by steventsui on 9/3/2017.
 */


public class MainFragment extends Fragment {

    public static final String TAG = "MainFragment";
    private FragmentMainBinding mBinding;
    private MainFragmentViewModel mViewModel;
    int value = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        //mViewModel = new MainFragmentViewModel("Title", "Sub", "bbbbb");
        mViewModel = new MainFragmentViewModel();
        mViewModel.title.set("Title");
        mViewModel.buttonName.set("B_B");
        mBinding.setMainFragmentViewModel(mViewModel);
        Log.d(TAG, "onCreateView value:"+value);
        value += 1;
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        ((StevenApplication) getActivity().getApplication()).getFragmentComponent((MainActivity) getActivity()).inject(this);
        value += 1;
        Log.d(TAG, "onViewCreated value:"+value);

        mBinding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                mViewModel.title.set(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        if (url == null) {
            imageView.setImageDrawable(null);
        } else {
            // load image from URL
        }
    }

//    @BindingAdapter("loadImageUrlHAHA")
//    public static void setImageUrl(ImageView imageView, String url) {
//        if (url == null) {
//            imageView.setImageDrawable(null);
//        } else {
//            // load image from URL
//        }
//    }
}
