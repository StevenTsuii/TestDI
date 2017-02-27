package com.steven.testdi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by steventsui on 2/2/2017.
 */

public abstract class AbstractViewHolder<T> extends RecyclerView.ViewHolder {

    private final Context mContext;

    public AbstractViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
    }

    public abstract void update(T item, int position);

    public Context getContext() {
        return mContext;
    }

}