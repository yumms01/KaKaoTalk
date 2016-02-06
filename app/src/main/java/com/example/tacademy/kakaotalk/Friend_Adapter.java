package com.example.tacademy.kakaotalk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Tacademy on 2016-02-06.
 */
public class Friend_Adapter extends BaseAdapter implements Friend_View.OnImageClickListener {

    List<Friend> items = new ArrayList<Friend>();

    public void add(Friend f) {
        items.add(f);
        notifyDataSetChanged();
    }

    public void addAll(List<Friend> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Friend_View view;
        if (convertView == null) {
            view = new Friend_View(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (Friend_View)convertView;
        }
        view.setChatting(items.get(position));
        return view;
    }

    public interface OnAdapterItemClickListener {
        public void onAdapterItemClickListener(Friend_Adapter adapter, Friend_View view, Friend friend, int position);
    }
    OnAdapterItemClickListener mAdapterListener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickListener listener) {
        mAdapterListener = listener;
    }

    @Override
    public void onImageClick(Friend_View view, Friend friend) {
        if (mAdapterListener != null) {
            int index = items.indexOf(friend);
            mAdapterListener.onAdapterItemClickListener(this, view, friend, index);
        }
    }



}
