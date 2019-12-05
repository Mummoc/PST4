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
import com.example.pst4.Vue.FragmentSumUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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
        setContentView(R.layout.activity_advert);

        Fragment fragmentAdvert0 = new FragmentAdvert0();
        final Fragment fragmentAdvert1 = new FragmentAdvert1();
        final Fragment fragmentAdvert2 = new FragmentAdvert2();
        final Fragment fragmentAdvert3 = new FragmentAdvert3();
        final Fragment fragmentAdvert4 = new FragmentAdvert4();
        FragmentManager fm1 = getSupportFragmentManager();
        final FragmentTransaction ftStack = fm1.beginTransaction();
        final FragmentTransaction ftFrag1 = fm1.beginTransaction();
        final FragmentTransaction ftFrag2 = fm1.beginTransaction();
        final FragmentTransaction ftFrag3 = fm1.beginTransaction();
        final FragmentTransaction ftFrag4 = fm1.beginTransaction();
        final FragmentTransaction ftFrag5 = fm1.beginTransaction();
        final FragmentTransaction ftBack1 = fm1.beginTransaction();
        final FragmentTransaction ftBack2 = fm1.beginTransaction();
        final FragmentTransaction ftBack3 = fm1.beginTransaction();
        final FragmentTransaction ftBack4 = fm1.beginTransaction();



        ftStack.add(R.id.fragment_container_content, fragmentAdvert0); //new BackAndForwardFragment()

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
                        ftFrag1.replace(R.id.fragment_container_content, fragmentAdvert1);
                        ftFrag1.addToBackStack(null);
                        ftFrag1.commit();
                    break;

                    case 2 :
                        ftFrag2.replace(R.id.fragment_container_content, fragmentAdvert2);
                        ftFrag2.addToBackStack(null);
                        ftFrag2.commit();
                        break;

                    case 3 :
                        ftFrag3.replace(R.id.fragment_container_content, fragmentAdvert3);
                        ftFrag3.addToBackStack(null);
                        ftFrag3.commit();
                        break;

                    case 4 :
                        ftFrag4.replace(R.id.fragment_container_content, fragmentAdvert4);
                        ftFrag4.addToBackStack(null);
                        ftFrag4.commit();
                        break;

                    case 5 :
                        ftFrag5.replace(R.id.fragment_container_content, new FragmentSumUp());
                        ftFrag5.addToBackStack(null);
                        ftFrag5.commit();
                        break;
                }
            }

        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etat >=1){
                    etat--;
                    onBackPressed();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}