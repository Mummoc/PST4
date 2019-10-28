package com.example.pst4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdvertActivity1 extends AppCompatActivity {

    private Button suivant;
    private Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert1);

        suivant = findViewById(R.id.suiv);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvertActivity2();
            }
        });
        retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvertActivity0();
            }
        });
    }
    public void openAdvertActivity2() {
        Intent intent = new Intent(this, AdvertActivity2.class);
        startActivity(intent);
    }
    public void openAdvertActivity0() {
    }
}


