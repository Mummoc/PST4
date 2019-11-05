package com.example.pst4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Region;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ConnectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info3);

        Spinner spinner = findViewById(R.id.spinner_marque);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinner_marque, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}
