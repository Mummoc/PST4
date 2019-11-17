package com.example.pst4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info4);

        /*Mettre dans un fichier à part CAR INFO3*/
        /*List age = new ArrayList<Integer>();
        for (int i = 1900; i<2019; i++){
            age.add(Integer.toString(i));
        }
        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, age);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        Spinner yearcraft = (Spinner)findViewById(R.id.spinner_yearcraft);
        yearcraft.setAdapter(spinnerArrayAdapter);

        Spinner mise_circulation = findViewById(R.id.spinner_mise_circulation);
        mise_circulation.setAdapter(spinnerArrayAdapter);*/
    }
}
