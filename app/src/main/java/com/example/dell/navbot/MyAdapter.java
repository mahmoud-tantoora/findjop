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

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Itemdata[] itemdata;
    public Context context;
    public Itemdata_profile[] itemdata_profile;
    public int type;

    public MyAdapter(Itemdata[] itemdata,Context context,int type)
    {
        this.type=type;
        this.context=context;
        this.itemdata=itemdata;
    }
    public MyAdapter(Itemdata_profile[] itemdata_profile,Context context, int type)
    {
        this.type=type;
        this.context=context;
        this.itemdata_profile=itemdata_profile;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (type == R.string.Worker || type == R.string.Company ) {
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recycler_profile, null);
            MyViewHolderProfile myViewHolderProfile = new MyViewHolderProfile(itemLayoutView);
            return myViewHolderProfile;
        }
        else {
            if (viewType == 1000) {
                View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recycler_witout_image, null);
                MyViewHolderWithoutImg withoutImg = new MyViewHolderWithoutImg(itemLayoutView);
                return withoutImg;
            } else {
                View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recycler, null);
                MyViewHolder viewHolder = new MyViewHolder(itemLayoutView);
                return viewHolder;
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(type == R.string.Worker)
        {
            MyViewHolderProfile myViewHolderProfile=(MyViewHolderProfile) holder;
            myViewHolderProfile.name.setText(itemdata_profile[position].name);
            myViewHolderProfile.country.setText(itemdata_profile[position].country);
            myViewHolderProfile.study.setText(itemdata_profile[position].study);
            myViewHolderProfile.image_profile.setImageResource(itemdata_profile[position].image);
            myViewHolderProfile.card_profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "you click on " + itemdata_profile[position].name.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            int viewtype = getItemViewType(position);
            if (viewtype == 1000) {
                MyViewHolderWithoutImg withoutimage = (MyViewHolderWithoutImg) holder;
                withoutimage.rec_title.setBackgroundColor(Color.parseColor("#ffffff"));
                withoutimage.rec_detail.setBackgroundColor(Color.parseColor("#ffffff"));
                withoutimage.rec_title.setText(itemdata[position].title);
                withoutimage.rec_detail.setText(itemdata[position].detail);
            } else {
                MyViewHolder myViewHolder = (MyViewHolder) holder;
                myViewHolder.rec_title.setText(itemdata[position].title);
                myViewHolder.rec_detail.setText(itemdata[position].detail);
                myViewHolder.rec_img.setImageResource(itemdata[position].image);
                myViewHolder.card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(context, "you click on " + itemdata[position].title.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        if(type == R.string.Worker)
        {
            return itemdata_profile.length;
        }
        else {
            return itemdata.length;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(itemdata[position].image==1000)
            return 1000;
        else
        return super.getItemViewType(position);
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public  TextView rec_title,rec_detail;
        public ImageView rec_img;
        public CardView card;
        public Button like ,comment, massage;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public MyViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.

            super(itemView);

            rec_title = (TextView) itemView.findViewById(R.id.title_item);
            rec_detail=(TextView)itemView.findViewById(R.id.detail_item);
            rec_img = (ImageView) itemView.findViewById(R.id.image_item);
            like=(Button)itemView.findViewById(R.id.like_item);
            comment=(Button)itemView.findViewById(R.id.comment_item);
            massage=(Button)itemView.findViewById(R.id.massage_item);
            card=(CardView)itemView.findViewById(R.id.card_item);
        }
        public int getItemCount()
        {
            if(type == R.string.Worker)
            {
                return itemdata_profile.length;
            }
            else {
                return itemdata.length;
            }
        }
    }
    public class MyViewHolderWithoutImg extends RecyclerView.ViewHolder
    {
        public  TextView rec_title,rec_detail;
        public CardView card;
        public Button like ,comment, massage;

        public MyViewHolderWithoutImg(View itemView) {
            super(itemView);
            rec_title = (TextView) itemView.findViewById(R.id.title_item);
            rec_detail=(TextView)itemView.findViewById(R.id.detail_item);
            like=(Button)itemView.findViewById(R.id.like_item);
            comment=(Button)itemView.findViewById(R.id.comment_item);
            massage=(Button)itemView.findViewById(R.id.massage_item);
            card=(CardView)itemView.findViewById(R.id.card_item);
        }
    }
    public class MyViewHolderProfile extends RecyclerView.ViewHolder
    {
        public  TextView name,country,study;
        public CardView card_profile;
        private ImageView image_profile;

        public MyViewHolderProfile(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_prfile);
            country=(TextView)itemView.findViewById(R.id.country_profile);
            study=(TextView)itemView.findViewById(R.id.study_profile);
            card_profile=(CardView)itemView.findViewById(R.id.card_profile);
            image_profile=(ImageView)itemView.findViewById(R.id.image_profile);
        }
    }
}
   // Now that we've defined the basic adapter and ViewHolder, we need to begin filling in our adapter. First, let's store a member variable for the list of contacts and pass the list in through our constructor:


