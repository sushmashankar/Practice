package com.example.practice.model;

import java.util.List;

public class Information {

    public List<String> fragments;
    private int topic_id;
    private String topic_name;
    private String game;
    private String link;
    private int level;


public Information() {

}

public Information(String topic_name, List<String> fragments,String game, String link, int level,int topic_id)
{
    this.fragments = fragments;
    this.topic_name= topic_name;
    this.game=game;
    this.topic_id=topic_id;
    this.level = level;
    this.link=link;


}

    public Information(List<String> fragments) {

    this.fragments=fragments;
    }

    public String getTopic_name() {return topic_name;}
    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public void setFragments(List<String> fragments) {
        this.fragments = fragments;
    }
    public List<String> getFragments() {
        return fragments;
    }

    public String getGame() { return game; }
    public void setGame(String game) { this.game = game; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

        public void setLevel(int level) {
        this.level = level;
    }
       public int getLevel() {
        return level;
    }

    public void setTopic_id(int topic_id) {this.topic_id=topic_id;}
    public int getTopic_id() {
        return topic_id;
    }

}
