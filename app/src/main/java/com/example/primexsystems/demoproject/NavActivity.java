package com.example.primexsystems.demoproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primexsystems.demoproject.home.adapter.FourContentAdapter;
import com.example.primexsystems.demoproject.home.model.NewsItem;

import java.util.ArrayList;

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        initializeFields();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            TestFragment fragment = new TestFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
            fragmentTransaction.replace(R.id.frame, fragment, "TEST");
            fragmentTransaction.addToBackStack(null);
            //fragmentTransaction.commitAllowingStateLoss();
            fragmentTransaction.commit();
            Toast.makeText(this, "nav_camera", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "nav_gallery", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, "nav_slideshow", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(this, "nav_manage", Toast.LENGTH_SHORT).show();
        } /*else if (id == R.id.nav_share) {
            Toast.makeText(this, "nav_share", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(this, "nav_send", Toast.LENGTH_SHORT).show();

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * initializing the four include layouts
     * then accessing the individual layout view
     * from specific include layout id
     */
    private void initializeFields() {

        /*
        *

    প্রচ্ছদ
    জাতীয়
    রাজনীতি
    আইন ও আদালত
    সারাবিশ্ব
    স্পোর্টস
    বিনোদন
    প্রবাসে বাংলা
    এক্সক্লুসিভ

      * */
        View recentContent, firstContent,secondContent, thirdContent, fourContent, fiveContent, sixContent;
        recentContent = findViewById(R.id.recentContent);
        firstContent = findViewById(R.id.firstContent);
        secondContent = findViewById(R.id.secondContent);
        thirdContent = findViewById(R.id.thirdContent);
        fourContent = findViewById(R.id.fourContent);
        fiveContent = findViewById(R.id.fiveContent);
        sixContent = findViewById(R.id.sixContent);

        TextView headerTVFirst, titleTVFirst, timeTVFirst, subHeaderTVFirst,
                headerTVSecond, titleTVSecond, timeTVSecond, subHeaderTVSecond,
                headerTVThird, titleTVThird, timeTVThird, subHeaderTVThird,
                headerTVFour, titleTVFour, timeTVFour, subHeaderTVFour,
                headerTVFive, titleTVFive, timeTVFive, subHeaderTVFive,
                headerTVSix, titleTVSix, timeTVSix, subHeaderTVSix,
                headerTVRecent, titleTVRecent, timeTVRecent, subHeaderTVRecent,
                categoryOne_TV, categoryTwo_TV;

        RecyclerView recyclerviewListFirst, recyclerviewListSecond, recyclerviewListThird, recyclerviewListFour,
                recyclerviewListFive, recyclerviewListSix, recyclerviewListRecent;

        headerTVFirst = firstContent.findViewById(R.id.headerTV);
        titleTVFirst = firstContent.findViewById(R.id.titleTV);
        timeTVFirst = firstContent.findViewById(R.id.timeTV);
        headerTVFirst.setText("জাতীয়");

        recyclerviewListFirst = firstContent.findViewById(R.id.recyclerviewList);

        headerTVSecond = secondContent.findViewById(R.id.headerTV);
        titleTVSecond = secondContent.findViewById(R.id.titleTV);
        timeTVSecond = secondContent.findViewById(R.id.timeTV);
        headerTVSecond.setText("রাজনীতি");

        recyclerviewListSecond = secondContent.findViewById(R.id.recyclerviewList);

        headerTVThird = thirdContent.findViewById(R.id.headerTV);
        titleTVThird = thirdContent.findViewById(R.id.titleTV);
        timeTVThird = thirdContent.findViewById(R.id.timeTV);
        headerTVThird.setText("স্পোর্টস");

        recyclerviewListThird = thirdContent.findViewById(R.id.recyclerviewList);

        headerTVFour = fourContent.findViewById(R.id.headerTV);
        titleTVFour = fourContent.findViewById(R.id.titleTV);
        timeTVFour = fourContent.findViewById(R.id.timeTV);
        headerTVFour.setText("বিনোদন");

        recyclerviewListFour = fourContent.findViewById(R.id.recyclerviewList);

        headerTVFive = fiveContent.findViewById(R.id.headerTV);
        titleTVFive = fiveContent.findViewById(R.id.titleTV);
        timeTVFive = fiveContent.findViewById(R.id.timeTV);
        headerTVFive.setText("এক্সক্লুসিভ");

        recyclerviewListFive = fiveContent.findViewById(R.id.recyclerviewList);

        headerTVSix = sixContent.findViewById(R.id.headerTV);
        titleTVSix = sixContent.findViewById(R.id.titleTV);
        timeTVSix = sixContent.findViewById(R.id.timeTV);
        headerTVSix.setText("সারাবিশ্ব");

        recyclerviewListSix = sixContent.findViewById(R.id.recyclerviewList);

        headerTVRecent = recentContent.findViewById(R.id.headerTV);
        titleTVRecent = recentContent.findViewById(R.id.titleTV);
        timeTVRecent = recentContent.findViewById(R.id.timeTV);

        recentContent.findViewById(R.id.lineOne).setVisibility(View.GONE);
        recentContent.findViewById(R.id.headerTV).setVisibility(View.GONE);

        recyclerviewListRecent = recentContent.findViewById(R.id.recyclerviewList);



        ArrayList<NewsItem> newsItemArrayList = prepareData();
        FourContentAdapter listAdapter = new FourContentAdapter(newsItemArrayList);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerviewListFirst.setAdapter(listAdapter);
        recyclerviewListFirst.setLayoutManager(layoutManager);
        recyclerviewListSecond.setAdapter(listAdapter);
        recyclerviewListSecond.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerviewListThird.setAdapter(listAdapter);
        recyclerviewListThird.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerviewListFour.setAdapter(listAdapter);
        recyclerviewListFour.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerviewListFive.setAdapter(listAdapter);
        recyclerviewListFive.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerviewListSix.setAdapter(listAdapter);
        recyclerviewListSix.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerviewListRecent.setAdapter(listAdapter);
        recyclerviewListRecent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


    }

    private ArrayList<NewsItem> prepareData(){
        ArrayList<NewsItem> newsItems = new ArrayList<>();
        newsItems.add(new NewsItem("Oath on 3rd January", "1hr ago", "Read 1000 times", ""));
        newsItems.add(new NewsItem("Oath on 3rd January", "1hr ago", "Read 1000 times", ""));
        newsItems.add(new NewsItem("Oath on 3rd January", "1hr ago", "Read 1000 times", ""));
        newsItems.add(new NewsItem("Oath on 3rd January", "1hr ago", "Read 1000 times", ""));
        return newsItems;

    }
}
