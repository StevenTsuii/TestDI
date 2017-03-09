package com.steven.testdi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by steventsui on 2/2/2017.
 */

public abstract class AbstractAdapter<T extends AbstractViewHolder<V>, V> extends RecyclerView.Adapter<T> {

    private static final String TAG = "AbstractAdapter";

    private ArrayList<V> mArrayList;

    public AbstractAdapter() {
        mArrayList = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        holder.update(getItem(position), position);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public V getItem(int index) {
        return mArrayList.get(index);
    }

    public void setContentList(ArrayList<V> arrayList) {
        //AppLog.getInstance().debug(TAG, "checkSetContentList->" + (arrayList == null ? 0 : arrayList.size()));
        mArrayList.clear();
        mArrayList.addAll(arrayList);
        this.notifyDataSetChanged();
    }

    public void addContent(ArrayList<V> arrayList) {
        mArrayList.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void addContent(V item) {
        mArrayList.add(item);
        notifyDataSetChanged();
    }

    public void cleanContentList() {
        mArrayList.clear();
        this.notifyDataSetChanged();
    }

    public void removeItem(int index) {
        mArrayList.remove(index);
        notifyDataSetChanged();
    }

    public void moveItem(int fromIndex, int toIndex) {
        V toItem = mArrayList.get(toIndex);
        V fromItem = mArrayList.get(fromIndex);
        mArrayList.set(toIndex, fromItem);
        mArrayList.set(fromIndex, toItem);
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    protected View inflateView(ViewGroup parent, int layoutResId) {
        final Context context = parent.getContext();
        final View view = LayoutInflater.from(context).inflate(layoutResId, parent, false);
        return view;
    }

}