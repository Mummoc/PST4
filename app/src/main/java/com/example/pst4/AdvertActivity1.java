package com.example.pst4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdvertActivity1 extends AppCompatActivity {

    private Button suivant;
    private Button retour;
    private Button occasion;
    private Button neuf;
    public static Integer etat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info1);

        suivant = findViewById(R.id.suiv);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suivant();
            }
        });
        retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retour();
            }
        });
        neuf = findViewById(R.id.buttonNeuf);
        neuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etat=1;
            }
        });
        occasion = findViewById(R.id.buttonOccasion);
        occasion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etat=2;
            }
        });
    }
    public void suivant() {
        Intent intent = new Intent(this, AdvertActivity2.class);
        startActivity(intent);
    }
    public void retour() {
        Intent intent = new Intent(this, AdvertActivity0.class);
        startActivity(intent);
    }
}


