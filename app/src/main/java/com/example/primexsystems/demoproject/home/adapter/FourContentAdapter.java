package com.example.primexsystems.demoproject.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.primexsystems.demoproject.R;
import com.example.primexsystems.demoproject.home.model.NewsItem;

import java.util.ArrayList;

public class FourContentAdapter extends RecyclerView.Adapter<FourContentAdapter.ViewHolder> {

    private ArrayList<NewsItem> newsItems;

    public FourContentAdapter(ArrayList<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }


    @NonNull
    @Override
    public FourContentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_news_item_layout, parent, false);
        return new FourContentAdapter.ViewHolder(view, newsItems);
    }

    @Override
    public void onBindViewHolder(@NonNull FourContentAdapter.ViewHolder holder, int position) {
        //holder.title_TV.setText(newsItems.get(position).getTitle());
        //holder.time_TV.setText(newsItems.get(position).getTime());
       // holder.count_TV.setText(newsItems.get(position).getCountDown());

    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView post_IV;
        TextView title_TV, time_TV, count_TV;
        ArrayList<NewsItem> newsItems;

        ViewHolder(View view, ArrayList<NewsItem> newsItems) {
            super(view);
            this.newsItems = newsItems;

            post_IV = view.findViewById(R.id.post_IV);
            title_TV = view.findViewById(R.id.title_TV);
            time_TV = view.findViewById(R.id.time_TV);
        }


    }
}
