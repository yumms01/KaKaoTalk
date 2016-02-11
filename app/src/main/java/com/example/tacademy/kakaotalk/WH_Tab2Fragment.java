package com.example.tacademy.kakaotalk;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class WH_Tab2Fragment extends Fragment {

    ListView listView;
    Chatting_Adapter mAdapter;
    static final int[] ICON_IDS = {R.drawable.sample_thumb_0,
            R.drawable.sample_thumb_1,
            R.drawable.sample_thumb_2,
            R.drawable.sample_thumb_3,
            R.drawable.sample_thumb_4,
            R.drawable.sample_thumb_5,
            R.drawable.sample_thumb_6,
            R.drawable.sample_thumb_7
    };
    private static final int REQUEST_CODE_OTHER = 0;

    public WH_Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.wh_fragment_tab2, container, false);
        listView = (ListView)view.findViewById(R.id.listView);

        View headerView = inflater.inflate(R.layout.view_header, null);
        listView.addHeaderView(headerView, "header", false);

        mAdapter = new Chatting_Adapter();
        mAdapter.setOnAdapterItemClickListener(new Chatting_Adapter.OnAdapterItemClickListener(){
            @Override
            public void onAdapterItemClickListener(Chatting_Adapter adapter, Chatting_View view, Chatting chatting, int position) {
//                Intent intent = new Intent(getContext(), Chatting_MainActivity.class);
//                startActivityForResult(intent, REQUEST_CODE_OTHER);
                Toast.makeText(getContext(), "ImageClick : " + chatting.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object data = listView.getItemAtPosition(position);
                if (data instanceof String) {
                    Toast.makeText(getContext(), "Header : " + (String)data, Toast.LENGTH_SHORT).show();
                } else if (data instanceof Chatting) {
                    Chatting c = (Chatting)data;
                    Toast.makeText(getContext(), "name : " + c.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        initData();

        return view;
    }

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int age = 20 + r.nextInt(20);
            Drawable d = getResources().getDrawable(ICON_IDS[age % ICON_IDS.length]);
            if (age % 3 == 0) {
                d = null;
            }
            Chatting c = new Chatting(d, "name" + i,"chatting text");
            mAdapter.add(c);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getActivity().setTitle("채팅");
        }
    }


}
