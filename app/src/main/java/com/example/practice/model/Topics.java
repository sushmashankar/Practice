package com.example.practice.model;

public class Topics {

    private String topic_name;
        private int topic_id;
        private int no_of_fragments;

        public Topics(){}

        public Topics(String topic_name, int topic_id, int no_of_fragments) {
            this.topic_name = topic_name;
            this.topic_id = topic_id;
            this.no_of_fragments = no_of_fragments;
        }

        public void setTopic_name(String topic_name) {
            this.topic_name = topic_name;
        }

        public String getTopic_name() {
            return topic_name;
        }

        public void setTopic_id(int topic_id) {
            this.topic_id = topic_id;
        }

        public int getTopic_id() {
            return topic_id;
        }

        public void setNo_of_fragments(int no_of_fragments) {
            this.no_of_fragments = no_of_fragments;
        }

        public int getNo_of_fragments() {
            return no_of_fragments;
        }
    }


