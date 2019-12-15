package com.example.pst4.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pst4.AdvertView;
import com.example.pst4.ListAdverts;
import com.example.pst4.models.Advert;
import com.example.pst4.R;

import java.util.ArrayList;

import androidx.lifecycle.AndroidViewModel;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdvertsAdapter extends RecyclerView.Adapter<ListAdvertsAdapter.MyViewHolder> {
    private ArrayList<Advert> mDataset;
    private Context mContext;
    private OnAdvertListener mOnAdvertListener;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        private TextView textView;
        private Button editButton;
        private Button deleteButton;
        private LinearLayout parentLayout;
        //...
        OnAdvertListener onAdvertListener;
        public MyViewHolder(View v, OnAdvertListener onAdvertListener) {
            super(v);
            textView = v.findViewById(R.id.text);
            editButton = v.findViewById(R.id.edit);
            deleteButton = v.findViewById(R.id.delete);
            parentLayout = v.findViewById(R.id.listview);
            this.onAdvertListener = onAdvertListener;
            itemView.setOnClickListener(this);
            //editButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onAdvertListener.onAdvertClick((getAdapterPosition()));
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset.get(position).getBrand());
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(mContext, "Editing the advert", Toast.LENGTH_SHORT);
                myToast.show();
                Intent intent = new Intent(mContext, AdvertView.class);
                mContext.startActivity(intent);
            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(mContext, "Deleting the advert", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface OnAdvertListener {
        void onAdvertClick(int position);
    }
}