package com.steven.testdi;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by yaucheukming on 14/1/2017.
 */

public class BaseDatabindingComponent{

    private static final String TAG = "BaseDatabindingComponen";

    @BindingAdapter(
            {
                    "binding:imageUrl",
            }
    )
    public static void loadImage(ImageView view, String url) {
        Log.d("", "loadimage:" + url);
    }

    @BindingAdapter(
            {
                    "binding:layout_marginBottom"
            }
    )
    public static void setLayoutMarginBottom(View v, int bottomMargin) {
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) v.getLayoutParams();

        if (layoutParams != null) {
            layoutParams.bottomMargin = bottomMargin;
        }
    }

    @BindingAdapter("isGone")
    public static void setIsGone(View view, boolean hide){
        view.setVisibility(hide ? View.GONE : View.VISIBLE);
    }

    @BindingAdapter("isInvisible")
    public static void setIsInvisible(View view, boolean hide){
        view.setVisibility(hide ? View.INVISIBLE : View.VISIBLE);
    }
}
