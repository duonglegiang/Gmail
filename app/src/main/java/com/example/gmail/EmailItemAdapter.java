package com.example.gmail;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmailItemAdapter extends RecyclerView.Adapter {

    List<EmailItem> dataset;
    Random random = new Random();
    int randomLimit = 10;


    public EmailItemAdapter(List<EmailItem> dataset) {
        this.dataset = dataset;
    }

    public EmailItemAdapter(EmailItem[] array) {
        this.dataset = new ArrayList<>(Arrays.asList(array));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.email_card, parent, false);

        EmailItemViewHolder vh = new EmailItemViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmailItem item = dataset.get(position);

        ((EmailItemViewHolder) holder).mSender.setText(item.getSender());
        ((EmailItemViewHolder) holder).mSubject.setText(item.getSubject());
        ((EmailItemViewHolder) holder).mbrief.setText(item.getBrief());
        ((EmailItemViewHolder) holder).mDate.setText(item.getDate().toString());
        
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class EmailItemViewHolder extends RecyclerView.ViewHolder{

        public ImageView mAvatar;
        public TextView mSender;
        public TextView mSubject;
        public TextView mbrief;
        public TextView mDate;
        public ImageButton star_;

        public EmailItemViewHolder(View itemView) {
            super(itemView);

            mAvatar = itemView.findViewById(R.id.avatar);
            mSender= itemView.findViewById(R.id.sender);
            mSubject = itemView.findViewById(R.id.subject);
            mbrief = itemView.findViewById(R.id.brief);
            mDate = itemView.findViewById(R.id.date);
            star_ = itemView.findViewById(R.id.star);
            star_.setTag(0);

            star_.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Integer resource = (Integer) star_.getTag();
                    System.out.println(resource);
                    if(resource == 0){
                        star_.setImageResource(R.drawable.ic_baseline_star1_24px);
                        star_.setTag(1);
                    }
                    else{
                        star_.setImageResource(R.drawable.ic_baseline_star0_24px);
                        star_.setTag(0);
                    }
                }
            });
        }
    }
}
