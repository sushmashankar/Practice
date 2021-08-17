package com.example.practice;

public class TopicData {

    private String title;
    private final int imageResource;

    public TopicData(String title, int imageResource)
    {
        this.title =title;
        this.imageResource=imageResource;
    }

    String getTitle() {return this.title;}

    public int getImageResource(){ return this.imageResource;}


}
