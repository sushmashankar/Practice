package com.example.practice;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    private ArrayList<TopicData> mTopicData;
    private Context mContext;

    TopicAdapter(Context context, ArrayList<TopicData> topicData){
        this.mTopicData= topicData;
        this.mContext = context;

    }

    @NonNull
    @Override
    public TopicAdapter.TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new TopicViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.topic_list,parent,false));

    }
    @Override
    public void onBindViewHolder(@NonNull TopicAdapter.TopicViewHolder holder, int position){
        TopicData currentTopic =mTopicData.get(position);

        holder.bindTo(currentTopic);
    }

    @Override
    public int getItemCount(){ return mTopicData.size();}

    class TopicViewHolder extends RecyclerView.ViewHolder implements View

            .OnClickListener{

        private TextView mTitletext;
        private ImageView mTopicImage;

        TopicViewHolder(View itemView) {
            super(itemView);
            mTitletext=itemView.findViewById(R.id.title);
            mTopicImage=itemView.findViewById(R.id.topicImage);

            itemView.setOnClickListener(this);

        }




        void bindTo(TopicData currentTopic)
        {
            mTitletext.setText(currentTopic.getTitle());

            Glide.with(mContext).load(currentTopic.getImageResource()).into(mTopicImage);
        }

        @Override
        public void onClick(View view){
             TopicData currentTopic =mTopicData.get(getAdapterPosition());
             Intent detailIntent = new Intent(mContext, ViewActivity.class);
             detailIntent.putExtra("title" ,currentTopic.getTitle());
             detailIntent.putExtra("image",getAdapterPosition());
             mContext.startActivity(detailIntent);

        }

    }



}
