 package com.example.pst4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.example.pst4.controller.MyAdapter;
import com.example.pst4.models.Advert;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdverts extends Activity implements MyAdapter.OnAdvertListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //TODO get adverts created
    private Advert ad1 = new Advert("Renault");
    private ArrayList<Advert> mAdverts = new ArrayList<Advert>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adverts);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdverts.add(ad1);
        mAdapter = new MyAdapter(mAdverts,ListAdverts.this,ListAdverts.this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onAdvertClick(int position) {
        mAdverts.get(position);
        //TODO change activity to go to
        Intent intent = new Intent(this,AdvertView.class);
        startActivity(intent);
    }
}