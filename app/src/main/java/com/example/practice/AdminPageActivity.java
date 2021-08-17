package com.example.practice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practice.model.Information;
import com.example.practice.model.Topics;
import com.example.practice.util.CSVFile;
import com.example.practice.util.FirestoreUtil;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AdminPageActivity extends AppCompatActivity {

    Button uploadFile;
    TextView successMsg;
    public static int MAX_FRAGMENTS_PER_TOPIC = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        successMsg = (TextView) findViewById(R.id.txtAdminSucccess);
        uploadFile = (Button)findViewById(R.id.uploadFile);
        uploadFile.setOnClickListener(this::onClick);
    }


    @RequiresApi(api = Build.VERSION_CODES.R)
    public void onClick(View v) {

        InputStream inputStream = getResources().openRawResource(R.raw.quest);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> questList = csvFile.read();

        List<String> topics = new ArrayList<String>();
        Hashtable<String, Integer> no_of_fragments_in_topic = new Hashtable<String, Integer>();
        Hashtable<String, Integer> fragment_counter = new Hashtable<String, Integer>();


        int count = 0;
        int current_level = 0;
        for (String[] elements : questList) {
            if (elements == null) {
                successMsg.setText(getString(R.string.excel_error));
                continue;
            }


            String topic_name = elements[0];

            if (count == 0) {
                count++;
                continue;
            }
            if (!topics.contains(topic_name)) {
                topics.add(topic_name);
                no_of_fragments_in_topic.put(topic_name, 1);
                fragment_counter.put(topic_name, 1);
                current_level = 1;
            } else {
                int a = no_of_fragments_in_topic.get(topic_name);
                int b = fragment_counter.get(topic_name);
                current_level = a;
                b++;
                if (b >= (MAX_FRAGMENTS_PER_TOPIC + 1)) {
                    a++;
                    current_level = a;
                    b = 1;
                }
                no_of_fragments_in_topic.put(topic_name, a);
                fragment_counter.put(topic_name, b);
            }

            String fragment1 = elements[1];
            String fragment2 = elements[2];
            String fragment3 = elements[3];
            String game_name = elements[4];
            String link = elements[5];


            Information db = new Information();

            db.setFragments(List.of(fragment1,fragment2,fragment3));
            db.setTopic_id(topics.indexOf(topic_name) + 1);
            db.setTopic_name(topic_name);
            db.setGame(game_name);
            db.setLink(link);
            db.setLevel(current_level);

            FirestoreUtil.getCollection("Information Text").add(db);

        }

        for (String topic: topics)
        {
            Topics tp = new Topics();
            tp.setTopic_name(topic);
            tp.setNo_of_fragments(no_of_fragments_in_topic.get(topic));
            tp.setTopic_id(topics.indexOf(topic) +1);

        FirestoreUtil.getCollection("topics").add(tp);
        }

        successMsg.setText( getString(R.string.upload_success));

    }}