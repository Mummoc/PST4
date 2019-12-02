package com.example.pst4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pst4.Vue.FragmentAdvert0;
import com.example.pst4.Vue.FragmentAdvert1;
import com.example.pst4.Vue.FragmentAdvert2;
import com.example.pst4.Vue.FragmentAdvert3;
import com.example.pst4.Vue.FragmentAdvert4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AdvertActivity extends AppCompatActivity {

    private Button suivant;
    private Button retour;
    private Button occasion;
    private Button neuf;
    public Integer etat = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert);//activity_advert

       /* ImagePickActivity imagePickActivity = new ImagePickActivity();
        imagePickActivity.onCreate(savedInstanceState);*/

// CHANGER LACTIVTY DE DEPART///////////////////////////////////////////////////////////////////
        FragmentManager fm1 = getSupportFragmentManager();
        final FragmentTransaction ftStack = fm1.beginTransaction();
        final FragmentTransaction ftFrag1 = fm1.beginTransaction();
        final FragmentTransaction ftFrag2 = fm1.beginTransaction();
        final FragmentTransaction ftFrag3 = fm1.beginTransaction();
        final FragmentTransaction ftFrag4 = fm1.beginTransaction();


        ftStack.add(R.id.fragment_container_content, new FragmentAdvert0()); //new BackAndForwardFragment()

        Log.d(" fragment", "Add fragment");
        ftStack.commit();

        suivant = findViewById(R.id.submit);
        retour = findViewById(R.id.retour);


        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etat++;
                switch (etat){
                    case 1 :
                        ftFrag1.replace(R.id.fragment_container_content, new FragmentAdvert1());
                        ftFrag1.addToBackStack(null);
                        ftFrag1.commit();
                    break;

                    case 2 :
                        ftFrag2.replace(R.id.fragment_container_content, new FragmentAdvert2());
                        ftFrag2.addToBackStack(null);
                        ftFrag2.commit();
                        break;

                    case 3 :
                        ftFrag3.replace(R.id.fragment_container_content, new FragmentAdvert3());
                        ftFrag3.addToBackStack(null);
                        ftFrag3.commit();
                        break;

                    case 4 :
                        ftFrag4.replace(R.id.fragment_container_content, new FragmentAdvert4());
                        ftFrag4.addToBackStack(null);
                        ftFrag4.commit();
                        break;
                }
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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

