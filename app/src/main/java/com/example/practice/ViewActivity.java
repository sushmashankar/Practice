package com.example.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.model.Information;
import com.example.practice.util.FirestoreUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    private static String topic_name;
    ImageButton next, previous;
    TextView text_area;
    ScrollView scrollView;
    public Information infodb;
    public List<String> mFragments;
    private Query query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtext);

        FetchDetails();

        text_area = (TextView) findViewById(R.id.tf_text);
        next = (ImageButton) findViewById(R.id.next);
        scrollView=findViewById(R.id.scrollable);
        next.setOnClickListener(this);
        previous = (ImageButton) findViewById(R.id.previous);
        previous.setOnClickListener(this);


    }


   /* public void FetchDetails() {
        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
        rootRef.collection("Information Text").document("J4QeBoOPCqPgmYcfafBn").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Information ip = document.toObject(Information.class);
                        //mFragments.add(new Information(ip.getFragments()));
                        mFragments = (ip.getFragments());
                        //text_area.setText(ip.getFragments().get(0));
                        text_area.setText(mFragments.get(0));


                    }


                }
            }
        });


    }*/


    public void FetchDetails() {
        FirestoreUtil.getCollection("Information Text").orderBy("topic_id").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    //int i = 0;
                    // mFragments.clear();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Information ip = document.toObject(Information.class); //use getstring
                        //mFragments.add(ip.getFragments().toString());

                        text_area.setText(ip.getFragments().get(0));
                        //scrollView.addView(text_area);





                    }


                }
            }
        });
    }


        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.next:
                    text_area.setText(mFragments.get(1).toString());
                    break;


                case R.id.previous:
                   // text_area.setText(infodb.getFragments().get(2));
                    break;
            }
        }
    }
