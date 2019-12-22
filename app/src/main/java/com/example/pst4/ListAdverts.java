 package com.example.pst4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pst4.controller.ListAdvertsAdapter;
import com.example.pst4.models.Advert;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.pst4.R.string.*;

 public class ListAdverts extends Activity implements ListAdvertsAdapter.OnAdvertListener {
    private RecyclerView recyclerView;
    private ListAdvertsAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Advert> mAdverts = new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adverts);
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        addAdvert();
        mAdapter = new ListAdvertsAdapter(mAdverts,ListAdverts.this,ListAdverts.this);
        recyclerView.setAdapter(mAdapter);

        /*mAdapter.setOnAdvertListener(new ListAdvertsAdapter.OnAdvertListener() {
            @Override
            public void onAdvertClick(int position) {
                mAdverts.get(position);
            }

            @Override
            public void onDeleteClick(int position) {

            }
        });*/
    }

     @Override
              public void onAdvertClick(int position) {
                  mAdverts.get(position);
                  Intent intent = new Intent(this,AdvertView.class);
                  startActivity(intent);
                  mAdapter.notifyItemChanged(position);
              }
    @Override
    public void onDeleteClick(int position) {
        Advert ad = mAdverts.get(position);
        removeAdvert(ad);
        mAdapter.notifyItemChanged(position);
    }
    public void addAdvert() {
        //TODO
        Advert ad1 = new Advert("Renault");
        mAdverts.add(ad1);
        Advert ad2 = new Advert("Peugeot");
        mAdverts.add(ad2);
    }
    public void removeAdvert(Advert ad) {
        mAdverts.remove(ad);
    }
}