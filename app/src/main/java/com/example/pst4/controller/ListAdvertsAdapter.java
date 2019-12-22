package com.example.pst4.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pst4.AdvertView;
import com.example.pst4.models.Advert;
import com.example.pst4.R;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class ListAdvertsAdapter extends RecyclerView.Adapter<ListAdvertsAdapter.MyViewHolder> {
    private ArrayList<Advert> mDataset;
    private Context mContext;
    private OnAdvertListener mOnAdvertListener;
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;
        private LinearLayout parentLayout;
        public ImageView mDelete;
        public ImageView mEdit;
        OnAdvertListener onAdvertListener;
        public MyViewHolder(View v, final OnAdvertListener onAdvertListener) {
            super(v);
            textView = v.findViewById(R.id.marque   );
            parentLayout = v.findViewById(R.id.listview);
            mDelete = v.findViewById(R.id.delete);
            mEdit = v.findViewById(R.id.edit);
            this.onAdvertListener = onAdvertListener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onAdvertListener.onAdvertClick((getAdapterPosition()));
                }
            });
            mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onAdvertListener.onDeleteClick((getAdapterPosition()));
                }
            });
        }

        @Override
        public void onClick(View view) {

        }
    }

    public ListAdvertsAdapter(ArrayList<Advert> myDataset, Context context, OnAdvertListener onAdvertListener) {
        mDataset = myDataset;
        mContext = context;
        mOnAdvertListener = onAdvertListener;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public ListAdvertsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_advert_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v,mOnAdvertListener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(mDataset.get(position).getBrand());
        holder.mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(mContext, "Editing the advert", Toast.LENGTH_SHORT);
                myToast.show();
                Intent intent = new Intent(mContext, AdvertView.class);
                mContext.startActivity(intent);
            }
        });
        /*holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnAdvertListener.onDeleteClick(position);
            }
        });*/
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface OnAdvertListener {
        void onAdvertClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnAdvertListener(OnAdvertListener onAdvertListener) {
        onAdvertListener = mOnAdvertListener;
    }
}