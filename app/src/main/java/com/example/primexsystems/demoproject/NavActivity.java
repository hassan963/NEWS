package com.example.primexsystems.demoproject;

import android.graphics.Typeface;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primexsystems.demoproject.home.adapter.ContentAdapter;
import com.example.primexsystems.demoproject.home.model.NewsItem;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;


   /*
    *প্রচ্ছদ
    জাতীয়
    রাজনীতি
    আইন ও আদালত
    সারাবিশ্ব
    স্পোর্টস
    বিনোদন
    প্রবাসে বাংলা
    এক্সক্লুসিভ * */

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView categoryOne_TV = findViewById(R.id.categoryOne_TV);
        TextView categoryTwo_TV = findViewById(R.id.categoryTwo_TV);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        categoryOne_TV.setTypeface(typeface); categoryTwo_TV.setTypeface(typeface);

        /**
         * Initializing the views
         */
        initializeFields(); reviewContent();
        recentContentInit(); firstContentInit(); secondContentInit(); thirdContentInit();
        fourContentInit(); fiveContentInit(); sixContentInit(); galleryContentInit();
    }

    private void initializeFields() {
        ImageView imageOne, imageTwo, imageThree;
        TextView category_image_TV, title_image_TV, category_image_two_TV, title_image_two_TV, category_image_three_TV, title_image_three_TV;
        category_image_TV = findViewById(R.id.category_image_TV);
        title_image_TV = findViewById(R.id.title_image_TV);
        category_image_two_TV = findViewById(R.id.category_image_two_TV);
        title_image_two_TV = findViewById(R.id.title_image_two_TV);
        category_image_three_TV = findViewById(R.id.category_image_three_TV);
        title_image_three_TV = findViewById(R.id.title_image_three_TV);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        title_image_TV.setTypeface(typeface); category_image_TV.setTypeface(typeface); category_image_two_TV.setTypeface(typeface);
        title_image_two_TV.setTypeface(typeface); category_image_three_TV.setTypeface(typeface); title_image_three_TV.setTypeface(typeface);
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

        switch (id){
            case R.id.nav_jatio:
                changeFragment(0); Toast.makeText(this, R.string.jatio, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_rajniti:
                changeFragment(1); Toast.makeText(this, R.string.rajniti, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_aiin:
                changeFragment(2); Toast.makeText(this, R.string.aiin, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_sharabissho:
                changeFragment(3); Toast.makeText(this, R.string.sharabissho, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_sports:
                changeFragment(4); Toast.makeText(this, R.string.sports, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_binodon:
                changeFragment(5); Toast.makeText(this, R.string.binodon, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_photo:
                changeFragment(6); Toast.makeText(this, R.string.photo, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_probashe:
                changeFragment(7); Toast.makeText(this, R.string.probashe, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_exclusive:
                changeFragment(8); Toast.makeText(this, R.string.exclusive, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_shastho:
                changeFragment(9); Toast.makeText(this, R.string.shastho, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_life:
                changeFragment(10); Toast.makeText(this, R.string.life, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_science:
                changeFragment(11); Toast.makeText(this, R.string.science, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_khola:
                changeFragment(12); Toast.makeText(this, R.string.kholakolam, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_interview:
                changeFragment(13); Toast.makeText(this, R.string.interview, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_krishi:
                changeFragment(14); Toast.makeText(this, R.string.krishi, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_vinno:
                changeFragment(15); Toast.makeText(this, R.string.vinnokhobor, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_campus:
                changeFragment(16); Toast.makeText(this, R.string.campus, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_tips:
                changeFragment(17); Toast.makeText(this, R.string.tips, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_rashifol:
                changeFragment(18); Toast.makeText(this, R.string.rashifol, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_oporad:
                changeFragment(19); Toast.makeText(this, R.string.oporad, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_jobs:
                changeFragment(20); Toast.makeText(this, R.string.jobs, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_dhormo:
                changeFragment(21); Toast.makeText(this, R.string.dhormo, Toast.LENGTH_SHORT).show(); break;
            case R.id.nav_bromon:
                changeFragment(22); Toast.makeText(this, R.string.bromon, Toast.LENGTH_SHORT).show(); break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * initiating the views of recent include layout
     */
    private void recentContentInit(){
        View recentContent = findViewById(R.id.recentContent);
        TextView headerTVRecent, titleTVRecent, timeTVRecent, subHeaderTVRecent;
        headerTVRecent = recentContent.findViewById(R.id.headerTV);
        titleTVRecent = recentContent.findViewById(R.id.titleTV);
        timeTVRecent = recentContent.findViewById(R.id.timeTV);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        titleTVRecent.setTypeface(typeface); timeTVRecent.setTypeface(typeface);

        recentContent.findViewById(R.id.lineOne).setVisibility(View.GONE);
        headerTVRecent.setVisibility(View.GONE);

        ArrayList<NewsItem> newsItemArrayList = prepareData();
        ContentAdapter listAdapter = new ContentAdapter(getApplicationContext(), newsItemArrayList);
        RecyclerView recyclerviewListRecent = recentContent.findViewById(R.id.recyclerviewList);
        recyclerviewListRecent.setAdapter(listAdapter);
        recyclerviewListRecent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    /**
     * initiating the views of first include layout
     */
    private void firstContentInit(){

        View firstContent = findViewById(R.id.firstContent);
        TextView headerTVFirst, titleTVFirst, timeTVFirst, subHeaderTVFirst;
        headerTVFirst = firstContent.findViewById(R.id.headerTV);
        titleTVFirst = firstContent.findViewById(R.id.titleTV);
        timeTVFirst = firstContent.findViewById(R.id.timeTV);
        headerTVFirst.setText(R.string.jatio);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        headerTVFirst.setTypeface(typeface); titleTVFirst.setTypeface(typeface); timeTVFirst.setTypeface(typeface);

        RecyclerView recyclerviewListFirst = firstContent.findViewById(R.id.recyclerviewList);
        ArrayList<NewsItem> newsItemArrayList = prepareData();
        ContentAdapter listAdapter = new ContentAdapter(getApplicationContext(), newsItemArrayList);

        recyclerviewListFirst.setAdapter(listAdapter);
        recyclerviewListFirst.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

    }

    private void secondContentInit(){
        View secondContent = findViewById(R.id.secondContent);
        TextView headerTVSecond, titleTVSecond, timeTVSecond, subHeaderTVSecond;
        headerTVSecond = secondContent.findViewById(R.id.headerTV);
        titleTVSecond = secondContent.findViewById(R.id.titleTV);
        timeTVSecond = secondContent.findViewById(R.id.timeTV);
        headerTVSecond.setText(R.string.rajniti);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        headerTVSecond.setTypeface(typeface); titleTVSecond.setTypeface(typeface); timeTVSecond.setTypeface(typeface);

        RecyclerView recyclerviewListSecond = secondContent.findViewById(R.id.recyclerviewList);
        ArrayList<NewsItem> newsItemArrayList = prepareData();
        ContentAdapter listAdapter = new ContentAdapter(getApplicationContext(), newsItemArrayList);

        recyclerviewListSecond.setAdapter(listAdapter);
        recyclerviewListSecond.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    private void thirdContentInit(){
        View thirdContent = findViewById(R.id.thirdContent);
        TextView headerTVThird, titleTVThird, timeTVThird, subHeaderTVThird;
        headerTVThird = thirdContent.findViewById(R.id.headerTV);
        titleTVThird = thirdContent.findViewById(R.id.titleTV);
        timeTVThird = thirdContent.findViewById(R.id.timeTV);
        headerTVThird.setText(R.string.sports);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        headerTVThird.setTypeface(typeface); titleTVThird.setTypeface(typeface); timeTVThird.setTypeface(typeface);

        RecyclerView recyclerviewListThird = thirdContent.findViewById(R.id.recyclerviewList);
        ArrayList<NewsItem> newsItemArrayList = prepareData();
        ContentAdapter listAdapter = new ContentAdapter(getApplicationContext(), newsItemArrayList);

        recyclerviewListThird.setAdapter(listAdapter);
        recyclerviewListThird.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    private void fourContentInit(){
        View fourContent = findViewById(R.id.fourContent);
        TextView
                headerTVFour, titleTVFour, timeTVFour, subHeaderTVFour;

        headerTVFour = fourContent.findViewById(R.id.headerTV);
        titleTVFour = fourContent.findViewById(R.id.titleTV);
        timeTVFour = fourContent.findViewById(R.id.timeTV);
        headerTVFour.setText("বিনোদন");

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        headerTVFour.setTypeface(typeface); titleTVFour.setTypeface(typeface); timeTVFour.setTypeface(typeface);

        RecyclerView recyclerviewListFour = fourContent.findViewById(R.id.recyclerviewList);
        ArrayList<NewsItem> newsItemArrayList = prepareData();
        ContentAdapter listAdapter = new ContentAdapter(getApplicationContext(), newsItemArrayList);

        recyclerviewListFour.setAdapter(listAdapter);
        recyclerviewListFour.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void fiveContentInit(){
        View fiveContent = findViewById(R.id.fiveContent);
        TextView headerTVFive, titleTVFive, timeTVFive, subHeaderTVFive;

        headerTVFive = fiveContent.findViewById(R.id.headerTV);
        titleTVFive = fiveContent.findViewById(R.id.titleTV);
        timeTVFive = fiveContent.findViewById(R.id.timeTV);
        headerTVFive.setText("এক্সক্লুসিভ");

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        headerTVFive.setTypeface(typeface); titleTVFive.setTypeface(typeface); timeTVFive.setTypeface(typeface);

        RecyclerView recyclerviewListFive = fiveContent.findViewById(R.id.recyclerviewList);
        ArrayList<NewsItem> newsItemArrayList = prepareData();
        ContentAdapter listAdapter = new ContentAdapter(getApplicationContext(), newsItemArrayList);

        recyclerviewListFive.setAdapter(listAdapter);
        recyclerviewListFive.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void sixContentInit(){
        View sixContent = findViewById(R.id.sixContent);
        TextView headerTVSix, titleTVSix, timeTVSix, subHeaderTVSix;
        headerTVSix = sixContent.findViewById(R.id.headerTV);
        titleTVSix = sixContent.findViewById(R.id.titleTV);
        timeTVSix = sixContent.findViewById(R.id.timeTV);
        headerTVSix.setText("সারাবিশ্ব");

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        headerTVSix.setTypeface(typeface); titleTVSix.setTypeface(typeface); timeTVSix.setTypeface(typeface);

        RecyclerView recyclerviewListSix = sixContent.findViewById(R.id.recyclerviewList);

        ArrayList<NewsItem> newsItemArrayList = prepareData();
        ContentAdapter listAdapter = new ContentAdapter(getApplicationContext(), newsItemArrayList);

        recyclerviewListSix.setAdapter(listAdapter);
        recyclerviewListSix.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    /*
    * Gallery content using banner slider
    * */
    private void galleryContentInit(){

        View galleryContent = findViewById(R.id.galleryContent);
        TextView gallery_headerTV = galleryContent.findViewById(R.id.gallery_headerTV);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        gallery_headerTV.setTypeface(typeface);

        BannerSlider bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);
        List<Banner> banners=new ArrayList<Banner>();
        //add banner using image url
        /*banners.add(new RemoteBanner("https://www.designbold.com/blog/wp-content/uploads/13-3.png"));
        banners.add(new RemoteBanner("http://www.samlevitz.com/wp-content/uploads/2016/04/Top-row-financing_AnniversarySale18.jpg"));
        banners.add(new RemoteBanner("https://23199848a6c7c6f6d65e-7fa6dd85c3b05df08cb38b85e7548f1b.ssl.cf2.rackcdn.com/2017afbfimg1.jpg"));*/
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.pictwo)); banners.add(new DrawableBanner(R.drawable.pictwo));  banners.add(new DrawableBanner(R.drawable.pictwo));

        bannerSlider.setBanners(banners);
    }

    private void reviewContent(){
        TextView review_headerTV, details_headerTV;
        review_headerTV = findViewById(R.id.review_headerTV);
        details_headerTV = findViewById(R.id.details_headerTV);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        review_headerTV.setTypeface(typeface); details_headerTV.setTypeface(typeface);
    }


    private ArrayList<NewsItem> prepareData(){
        ArrayList<NewsItem> newsItems = new ArrayList<>();
        newsItems.add(new NewsItem("Oath on 3rd January", "1hr ago", "Read 1000 times", ""));
        newsItems.add(new NewsItem("Oath on 3rd January", "1hr ago", "Read 1000 times", ""));
        newsItems.add(new NewsItem("Oath on 3rd January", "1hr ago", "Read 1000 times", ""));
        newsItems.add(new NewsItem("Oath on 3rd January", "1hr ago", "Read 1000 times", ""));
        return newsItems;

    }

    private void changeFragment(int id){
        TestFragment fragment = new TestFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.frame, fragment, "TEST");
        fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.commitAllowingStateLoss();
        fragmentTransaction.commit();
    }
}
