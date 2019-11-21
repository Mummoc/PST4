package com.example.pst4;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdvertActivity2 extends AppCompatActivity {

    private Button retour;
    final FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout_advert2);


        androidx.fragment.app.FragmentManager fm = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction ft = fm.beginTransaction();
        //ft.add(R.id.fragment_container2, new SampleFragment());
        Log.d(" fragment", "Add fragment");
        //ft.commit();

        /*retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });*/
    }
    public void openAdvertActivity1() {
        Intent intent = new Intent(this, AdvertActivity1.class);
        startActivity(intent);
    }
}
