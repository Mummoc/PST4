package com.example.pst4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class car_info2 extends AppCompatActivity {
    protected void onStart(){
        super.onStart();
        Spinner spinner = findViewById(R.id.spinner_yearcraft);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinner_marque, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
