package com.example.pst4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AdvertActivity1 extends AppCompatActivity {

    private Button suivant;
    private Button retour;
    private Button occasion;
    private Button neuf;
    public static Integer etat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert1);

// CHANGER LACTIVTY DE DEPART///////////////////////////////////////////////////////////////////
        FragmentManager fm1 = getSupportFragmentManager();
        final FragmentTransaction ftStack = fm1.beginTransaction();
        final FragmentTransaction ftFrag2 = fm1.beginTransaction();
        final FragmentTransaction ftFrag3 = fm1.beginTransaction();

        ftStack.add(R.id.fragment_container_content, new FragmentAdvert1()); //new SampleFragment()

        Log.d(" fragment", "Add fragment");
        ftStack.commit();

        suivant = findViewById(R.id.submit);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etat++;
                switch (etat){
                    case 1 :
                        ftFrag2.replace(R.id.fragment_container_content, new FragmentAdvert2());
                        ftFrag2.addToBackStack(null);
                        ftFrag2.commit();
                    break;

                    case 2 :
                        ftFrag3.replace(R.id.fragment_container_content, new FragmentAdvert3());
                        ftFrag3.addToBackStack(null);
                        ftFrag3.commit();
                        break;
                }
            }
        });

    }

    public void openAdvertActivity2() {
        Intent intent = new Intent(this, AdvertActivity2.class);
        startActivity(intent);
    }
    public void openAdvertActivity0() {
        Intent intent = new Intent(this, AdvertActivity0.class);
        startActivity(intent);
    }
}

/*retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvertActivity0();
            }
        });*/

/*neuf = findViewById(R.id.buttonNeuf);
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
        });*/

