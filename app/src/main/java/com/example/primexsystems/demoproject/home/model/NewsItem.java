package com.example.primexsystems.demoproject.home.model;

public class NewsItem {

    private String title, time, countDown, imageURL;

    public NewsItem(String title, String time, String countDown, String imageURL) {
        this.title = title;
        this.time = time;
        this.countDown = countDown;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCountDown() {
        return countDown;
    }

    public void setCountDown(String countDown) {
        this.countDown = countDown;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
