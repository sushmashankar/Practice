package com.example.practice;

import android.content.res.TypedArray;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.model.Information;
import com.example.practice.model.Topics;
import com.example.practice.util.FirestoreUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class FragmentActivity<allFragmentsReady> extends AppCompatActivity {

    public static List<FragmentData> mFragments;
}




 /*   allFragmentsReady;
        FirestoreUtil.getCollection("Information Text").orderBy("topic_id").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    int i = 0;
                    mFragments.clear();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        FragmentData ip = document.toObject(FragmentData.class);ajueji
                        mFragments.add(new FragmentData(ip.getFragments()));
                    }


                allFragmentsReady=1;

                }
            }
        });
    }
*/










