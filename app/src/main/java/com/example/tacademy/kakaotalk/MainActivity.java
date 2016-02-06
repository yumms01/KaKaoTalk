package com.example.tacademy.kakaotalk;

import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    TabHost tabHost;
    WH_TabsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        mAdapter = new WH_TabsAdapter(this, getSupportFragmentManager(), tabHost, pager);

        mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("친구"), WH_Tab1Fragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("채팅"), WH_Tab2Fragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec("tab3").setIndicator("채널"), WH_Tab3Fragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec("tab4").setIndicator("더보기"), WH_Tab4Fragment.class, null);


        if (savedInstanceState != null) {
            mAdapter.onRestoreInstanceState(savedInstanceState);
            tabHost.setCurrentTabByTag(savedInstanceState.getString("currentIndex"));
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mAdapter.onSaveInstanceState(outState);
        outState.putString("currentIndex", tabHost.getCurrentTabTag());
    }
}
