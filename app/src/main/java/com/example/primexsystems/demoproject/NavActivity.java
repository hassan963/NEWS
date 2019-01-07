package com.example.primexsystems.demoproject;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primexsystems.demoproject.home.adapter.ContentAdapter;
import com.example.primexsystems.demoproject.home.adapter.ExpandableListAdapter;
import com.example.primexsystems.demoproject.home.model.MenuModel;
import com.example.primexsystems.demoproject.home.model.NewsItem;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
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

   //https://www.journaldev.com/19375/android-expandablelistview-navigationview

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();


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

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.tabColor));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView categoryOne_TV = findViewById(R.id.categoryOne_TV);
        TextView categoryTwo_TV = findViewById(R.id.categoryTwo_TV);

        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        categoryOne_TV.setTypeface(typeface); categoryTwo_TV.setTypeface(typeface);

        /**
         * Initializing the views
         */
        initializeFields(); reviewContent();
        recentContentInit(); firstContentInit(); secondContentInit(); thirdContentInit();
        fourContentInit(); fiveContentInit(); sixContentInit(); galleryContentInit();
    }

    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel(getString(R.string.jatio), true, false,
                "0"); //Menu of Android Tutorial. No sub menus
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.rajniti), true, false,
                "1");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.aiin), true, false,
                "2");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.sharabissho), true, false,
                "3");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.sports), true, false,
                "4");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.binodon), true, false,
                "5");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.photo), true, false,
                "6");
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }

        menuModel = new MenuModel(getString(R.string.probashe), true, true,
                "7");
        headerList.add(menuModel);

        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel("মালয়েশিয়া", false, false, "23");
        childModelsList.add(childModel);
        childModel = new MenuModel("সৌদি আরব", false, false, "24");
        childModelsList.add(childModel);
        childModel = new MenuModel("কানাডা", false, false, "25");
        childModelsList.add(childModel);
        childModel = new MenuModel("যুক্তরাষ্ট্র", false, false, "26");
        childModelsList.add(childModel);
        childModel = new MenuModel("ভারত", false, false, "27");
        childModelsList.add(childModel);
        childModel = new MenuModel("কাতার", false, false, "28");
        childModelsList.add(childModel);
        childModel = new MenuModel("সিঙ্গাপুর", false, false, "29");
        childModelsList.add(childModel);



        if (menuModel.hasChildren) {
            Log.d("API123","here");
            childList.put(menuModel, childModelsList);
        }


        menuModel = new MenuModel(getString(R.string.exclusive), true, false,
                "8");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.shastho), true, false,
                "9");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.life), true, false,
                "10");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.science), true, false,
                "11");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.kholakolam), true, false,
                "12");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.interview), true, false,
                "13");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.krishi), true, false,
                "14");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.vinnokhobor), true, false,
                "15");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.campus), true, false,
                "16");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.tips), true, false,
                "17");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.rashifol), true, false,
                "18");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.oporad), true, false,
                "19");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.jobs), true, false,
                "20");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString( R.string.dhormo), true, false,
                "21");
        headerList.add(menuModel);
        menuModel = new MenuModel(getString(R.string.bromon), true, false,
                "22");
        headerList.add(menuModel);

        if (!menuModel.hasChildren) {
            childList.put(menuModel, null);
        }


    }

    private void populateExpandableList(){


        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {

                        Toast.makeText(NavActivity.this, headerList.get(groupPosition).position, Toast.LENGTH_SHORT).show();

                        onBackPressed();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                    if (model.position.length() > 0) {
                        Toast.makeText(NavActivity.this, model.position, Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                }

                return false;
            }
        });

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
        //add banner using image position
        /*banners.add(new RemoteBanner("https://www.designbold.com/blog/wp-content/uploads/13-3.png"));
        banners.add(new RemoteBanner("http://www.samlevitz.com/wp-content/uploads/2016/04/Top-row-financing_AnniversarySale18.jpg"));
        banners.add(new RemoteBanner("https://23199848a6c7c6f6d65e-7fa6dd85c3b05df08cb38b85e7548f1b.ssl.cf2.rackcdn.com/2017afbfimg1.jpg"));*/
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.pictwo)); banners.add(new DrawableBanner(R.drawable.pictwo));  banners.add(new DrawableBanner(R.drawable.pictwo));

        bannerSlider.setBanners(banners);
    }

    private void reviewContent(){
        TextView review_headerTV, details_headerTV;
        Button vote_button = findViewById(R.id.vote_button);
        final Group group_review = findViewById(R.id.group_review);
        final BarChart barChart = (BarChart) findViewById(R.id.barchart);
        review_headerTV = findViewById(R.id.review_headerTV);
        details_headerTV = findViewById(R.id.details_headerTV);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/solaimanlipinormal.ttf");
        review_headerTV.setTypeface(typeface); details_headerTV.setTypeface(typeface);

       // barChart.setVisibility(View.VISIBLE);
       // barChart.setMaxVisibleValueCount(60);
        barChart.setTouchEnabled(false);
        barChart.setPinchZoom(false);

        barChart.setDrawBarShadow(false);
        barChart.setDrawGridBackground(false);
        barChart.setDescription("");

        BarData data = new BarData(getXAxisValues(), getDataSet());
        barChart.setData(data);
        //barChart.setDescription("My Chart");
        barChart.animateXY(2000, 2000);
        barChart.invalidate();
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisRight().setDrawLabels(false);
        barChart.getLegend().setEnabled(false);




        vote_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                group_review.setVisibility(View.GONE);
                barChart.setVisibility(View.VISIBLE);
            }
        });

    }

    private ArrayList<BarDataSet> getDataSet(){

        ArrayList<BarDataSet> dataSets = null;

        /*ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);*/

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);

        /*BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
        barDataSet1.setColor(Color.rgb(0, 155, 0));*/
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
       // dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;


    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("হ্যাঁ");
        xAxis.add("না");
        xAxis.add("মন্তব্য নেই");
        return xAxis;
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
