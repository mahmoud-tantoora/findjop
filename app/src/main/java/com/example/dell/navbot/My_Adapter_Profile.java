package com.example.dell.navbot;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class My_Adapter_Profile extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context context;
    public Itemdata_profile[] itemdata_profile;

    public My_Adapter_Profile(Itemdata_profile[] itemdata_profile, Context context) {

        this.context = context;
        this.itemdata_profile = itemdata_profile;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recycler_profile, null);
        My_Adapter_Profile.MyViewHolderProfile myViewHolderProfile = new My_Adapter_Profile.MyViewHolderProfile(itemLayoutView);
        return myViewHolderProfile;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        My_Adapter_Profile.MyViewHolderProfile myViewHolderProfile = (My_Adapter_Profile.MyViewHolderProfile) holder;
        myViewHolderProfile.name.setText(itemdata_profile[position].name);
        myViewHolderProfile.country.setText(itemdata_profile[position].country);
        myViewHolderProfile.study.setText(itemdata_profile[position].study);
        myViewHolderProfile.image_pro.setImageResource(itemdata_profile[position].image);
        myViewHolderProfile.card_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you click on " + itemdata_profile[position].name.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return itemdata_profile.length;
    }


    public class MyViewHolderProfile extends RecyclerView.ViewHolder {
        public TextView name, country, study;
        public CardView card_profile;
        public ImageView image_pro;

        public MyViewHolderProfile(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_prfile);
            country = (TextView) itemView.findViewById(R.id.country_profile);
            study = (TextView) itemView.findViewById(R.id.study_profile);
            card_profile = (CardView) itemView.findViewById(R.id.card_profile);
            image_pro = (ImageView) itemView.findViewById(R.id.image_profile);
        }
    }
}
// Now that we've defined the basic adapter and ViewHolder, we need to begin filling in our adapter. First, let's store a member variable for the list of contacts and pass the list in through our constructor:

