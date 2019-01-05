package com.example.primexsystems.demoproject.home.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.primexsystems.demoproject.R;
import com.example.primexsystems.demoproject.home.model.NewsItem;

import java.util.ArrayList;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private ArrayList<NewsItem> newsItems;
    private Context context;

    public ContentAdapter(Context context, ArrayList<NewsItem> newsItems) {
        this.newsItems = newsItems;
        this.context = context;
    }


    @NonNull
    @Override
    public ContentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_news_item_layout, parent, false);
        return new ContentAdapter.ViewHolder(view, newsItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentAdapter.ViewHolder holder, int position) {
        //holder.title_TV.setText(newsItems.get(position).getTitle());
        //holder.time_TV.setText(newsItems.get(position).getTime());
       // holder.count_TV.setText(newsItems.get(position).getCountDown());
        /*Glide.with(getApplicationContext()).load(image).apply(new RequestOptions().placeholder(R.drawable.default_image))
                .thumbnail(0.5f)
                .into(profileImage)*/
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/solaimanlipinormal.ttf");
        holder.title_TV.setTypeface(typeface);
        holder.time_TV.setTypeface(typeface);
        holder.count_TV.setTypeface(typeface);
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
            count_TV = view.findViewById(R.id.count_TV);
        }


    }
}
