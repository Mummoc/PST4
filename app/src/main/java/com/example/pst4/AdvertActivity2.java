package com.example.pst4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AdvertActivity2 extends AppCompatActivity {

    private Button retour;

    //get the spinner from the xml.
    Spinner dropdown = findViewById(R.id.spinner1);
    //create a list of items for the spinner.
    String[] items = new String[]{"1", "2", "three"};
    //create an adapter to describe how the items are displayed, adapters are used in several places in android.
    //There are multiple variations of this, but this is the basic variant.
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
    //set the spinners adapter to the previously created one.
    //dropdown.setAdapter(adapter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert2);

        retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvertActivity1();
            }
        });
    }
    public void openAdvertActivity1() {
        Intent intent = new Intent(this, AdvertActivity1.class);
        startActivity(intent);
    }
}
