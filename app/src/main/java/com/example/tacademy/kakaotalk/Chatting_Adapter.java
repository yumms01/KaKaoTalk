package com.example.tacademy.kakaotalk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Tacademy on 2016-02-01.
 */
public class Chatting_Adapter extends BaseAdapter implements Chatting_View.OnImageClickListener{
    List<Chatting> items = new ArrayList<Chatting>();

    public Chatting_Adapter() {
    }

    public void add(Chatting c) {
        items.add(c);
        notifyDataSetChanged();
    }

    public void addAll(List<Chatting> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void remove(Chatting c) {
        items.remove(c);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void sort(Comparator<Chatting> comparator) {
        Collections.sort(items, comparator);
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
        Chatting_View view;
        if (convertView == null) {
            view = new Chatting_View(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (Chatting_View)convertView;
        }
        view.setChatting(items.get(position));
        return view;
    }

    public interface OnAdapterItemClickListener {
        public void onAdapterItemClickListener(Chatting_Adapter adapter, Chatting_View view, Chatting chatting, int position);
    }
    OnAdapterItemClickListener mAdapterListener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickListener listener) {
        mAdapterListener = listener;
    }

    @Override
    public void onImageClick(Chatting_View view, Chatting chatting) {
        if (mAdapterListener != null) {
            int index = items.indexOf(chatting);
            mAdapterListener.onAdapterItemClickListener(this, view, chatting, index);
        }
    }
}
