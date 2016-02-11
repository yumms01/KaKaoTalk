package com.example.tacademy.kakaotalk;

import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    TabHost tabHost;
    WH_TabsAdapter tab_mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Viewpager , TabHost

        pager = (ViewPager)findViewById(R.id.pager);
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        tab_mAdapter = new WH_TabsAdapter(this, getSupportFragmentManager(), tabHost, pager);

        tab_mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("", getResources().getDrawable(R.drawable.tab_1)), WH_Tab1Fragment.class, null);
        tab_mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("", getResources().getDrawable(R.drawable.tab_2)), WH_Tab2Fragment.class, null);
        tab_mAdapter.addTab(tabHost.newTabSpec("tab3").setIndicator("", getResources().getDrawable(R.drawable.tab_3)), WH_Tab3Fragment.class, null);
        tab_mAdapter.addTab(tabHost.newTabSpec("tab4").setIndicator("", getResources().getDrawable(R.drawable.tab_4)), WH_Tab4Fragment.class, null);


        if (savedInstanceState != null) {
            tab_mAdapter.onRestoreInstanceState(savedInstanceState);
            tabHost.setCurrentTabByTag(savedInstanceState.getString("currentIndex"));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        tab_mAdapter.onSaveInstanceState(outState);
        outState.putString("currentIndex", tabHost.getCurrentTabTag());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
