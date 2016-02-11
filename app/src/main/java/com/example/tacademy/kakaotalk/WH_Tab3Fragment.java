package com.example.tacademy.kakaotalk;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class WH_Tab3Fragment extends Fragment {

    RecyclerView recyclerView;
    Channel_SectionAdapter channel_mAdapter;
    RecyclerView.LayoutManager layoutManager;

    int[] IDS = {R.drawable.gallery_photo_1,
            R.drawable.gallery_photo_2,
            R.drawable.gallery_photo_3,
            R.drawable.gallery_photo_4,
            R.drawable.gallery_photo_5,
            R.drawable.gallery_photo_6,
            R.drawable.gallery_photo_7,
            R.drawable.gallery_photo_8
    };

    public WH_Tab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.wh_fragment_tab3, container, false);

        //Channel Page , RecyclerView

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        channel_mAdapter = new Channel_SectionAdapter();
        recyclerView.setAdapter(channel_mAdapter);

        layoutManager = new LinearLayoutManager(getContext());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (channel_mAdapter.getItemViewType(position) == Channel_SectionAdapter.VIEW_TYPE_SECTION_HEADER) {
                    return 2;
                }
                return 1;
            }
        });

//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();

        return view;
    }

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 8; i++) {
            int childCount = 2 + r.nextInt(4);
            for (int j = 0; j < childCount; j++) {
                Channel_ChildItem item = new Channel_ChildItem();
                item.childIcon = getResources().getDrawable(IDS[i % IDS.length]);
                channel_mAdapter.add("group" + i, "child:" + i + "-" + j, item.childIcon);

            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getActivity().setTitle("채널");
        }
    }
}
