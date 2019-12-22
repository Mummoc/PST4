package com.example.pst4.models;

import android.app.Activity;
import android.content.Intent;

import com.example.pst4.AdvertView;
import com.example.pst4.ListAdverts;

public class Advert {
    String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Advert(String brand) {
        this.brand = brand;
    }

}
