package com.example.practice;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice.model.Topics;
import com.example.practice.util.FirestoreUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.core.Query;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<TopicData> mTopicData;
    private TopicAdapter mAdapter;
    private Query mQuery;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);

        // Set the Layout Manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the ArrayList that will contain the data.
        mTopicData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new TopicAdapter(this, mTopicData);
        mRecyclerView.setAdapter(mAdapter);
        
        initializeData();



    }

    private void initializeData() {
        FirestoreUtil.getCollection("topics").orderBy("topic_id").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                TypedArray gamesImageResources = getResources()
                        .obtainTypedArray(R.array.listimage);

                if(task.isSuccessful()) {
                    int i = 0;
                    mTopicData.clear();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Topics tp = document.toObject(Topics.class);
                        mTopicData.add(new TopicData(tp.getTopic_name(),
                                gamesImageResources.getResourceId(i++, 0)));
                    }

                    // Recycle the typed array.
                    gamesImageResources.recycle();

                    // Notify the adapter of the change.
                    mAdapter.notifyDataSetChanged();
                }
            }
        });


    }
}