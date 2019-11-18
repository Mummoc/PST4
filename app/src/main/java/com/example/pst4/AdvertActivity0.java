package com.example.pst4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdvertActivity0 extends AppCompatActivity {

    private Button suivant;
    private Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert0);

        suivant = findViewById(R.id.suiv);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvertActivity1();
            }
        });
        retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvertActivity0();
            }
        });


        Integer etat = AdvertActivity1.etat;
        TextView etatText = findViewById(R.id.etat);
        etatText.setText("Etat : "+etat);
    }
    public void openAdvertActivity1() {
        Intent intent = new Intent(this, AdvertActivity1.class);
        startActivity(intent);
    }
    public void openAdvertActivity0() {
        Intent intent = new Intent(this, AdvertActivity0.class);
        startActivity(intent);
    }
}
