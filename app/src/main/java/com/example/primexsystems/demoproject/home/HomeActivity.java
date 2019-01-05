package com.example.primexsystems.demoproject.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.primexsystems.demoproject.R;
import com.example.primexsystems.demoproject.home.adapter.ContentAdapter;
import com.example.primexsystems.demoproject.home.model.NewsItem;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temps);

       // initializeFields();
    }

    /**
     * initializing the four include layouts
     * then accessing the individual layout view
     * from specific include layout id
     */
    private void initializeFields() {
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
        timeTVFirst = firstContent.findViewById(R.id.timeTV);;
        //subHeaderTVFirst = firstContent.findViewById(R.id.subHeaderTV);
        recyclerviewListFirst = firstContent.findViewById(R.id.recyclerviewList);

        headerTVSecond = secondContent.findViewById(R.id.headerTV);
        titleTVSecond = secondContent.findViewById(R.id.titleTV);
        timeTVSecond = secondContent.findViewById(R.id.timeTV);;
        //subHeaderTVSecond = secondContent.findViewById(R.id.subHeaderTV);
        recyclerviewListSecond = secondContent.findViewById(R.id.recyclerviewList);

        headerTVThird = thirdContent.findViewById(R.id.headerTV);
        headerTVThird = thirdContent.findViewById(R.id.titleTV);
        headerTVThird = thirdContent.findViewById(R.id.timeTV);;
        //headerTVThird = thirdContent.findViewById(R.id.subHeaderTV);
        recyclerviewListThird = thirdContent.findViewById(R.id.recyclerviewList);

        headerTVFour = fourContent.findViewById(R.id.headerTV);
        titleTVFour = fourContent.findViewById(R.id.titleTV);
        timeTVFour = fourContent.findViewById(R.id.timeTV);;
        //subHeaderTVFour = fourContent.findViewById(R.id.subHeaderTV);
        recyclerviewListFour = fourContent.findViewById(R.id.recyclerviewList);

        headerTVFive = fiveContent.findViewById(R.id.headerTV);
        titleTVFive = fiveContent.findViewById(R.id.titleTV);
        timeTVFive = fiveContent.findViewById(R.id.timeTV);
        //subHeaderTVFive = fiveContent.findViewById(R.id.subHeaderTV);
        recyclerviewListFive = fiveContent.findViewById(R.id.recyclerviewList);

        headerTVSix = sixContent.findViewById(R.id.headerTV);
        titleTVSix = sixContent.findViewById(R.id.titleTV);
        timeTVSix = sixContent.findViewById(R.id.timeTV);
        //subHeaderTVSix = sixContent.findViewById(R.id.subHeaderTV);
        recyclerviewListSix = sixContent.findViewById(R.id.recyclerviewList);

        headerTVRecent = recentContent.findViewById(R.id.headerTV);
        titleTVRecent = recentContent.findViewById(R.id.titleTV);
        timeTVRecent = recentContent.findViewById(R.id.timeTV);
        //subHeaderTVRecent = recentContent.findViewById(R.id.subHeaderTV);
        recentContent.findViewById(R.id.lineOne).setVisibility(View.GONE);
        headerTVSecond.setVisibility(View.GONE);
        recyclerviewListRecent = recentContent.findViewById(R.id.recyclerviewList);



/*        ArrayList<NewsItem> newsItemArrayList = prepareData();
        ContentAdapter listAdapter = new ContentAdapter(newsItemArrayList);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerviewListFirst.setAdapter(listAdapter);
        recyclerviewListFirst.setLayoutManager(layoutManager);
        recyclerviewListSecond.setAdapter(listAdapter);
        recyclerviewListSecond.setLayoutManager(layoutManager);
        recyclerviewListThird.setAdapter(listAdapter);
        recyclerviewListThird.setLayoutManager(layoutManager);
        recyclerviewListFour.setAdapter(listAdapter);
        recyclerviewListFour.setLayoutManager(layoutManager);
        recyclerviewListFive.setAdapter(listAdapter);
        recyclerviewListFive.setLayoutManager(layoutManager);
        recyclerviewListSix.setAdapter(listAdapter);
        recyclerviewListSix.setLayoutManager(layoutManager);
        recyclerviewListRecent.setAdapter(listAdapter);
        recyclerviewListRecent.setLayoutManager(layoutManager);*/


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
