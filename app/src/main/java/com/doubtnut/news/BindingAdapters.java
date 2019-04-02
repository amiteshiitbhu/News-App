package com.doubtnut.news;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class BindingAdapters {

    @BindingAdapter(value = {"bindAdapter"})
    public static void bindRecyclerAdapter(RecyclerView view, RecyclerView.Adapter adapter) {
        if (adapter == null) {
            return;
        }
        view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        view.setAdapter(adapter);
    }

}
