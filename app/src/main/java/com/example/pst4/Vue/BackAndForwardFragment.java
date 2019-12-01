package com.example.pst4.Vue;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pst4.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

 public class BackAndForwardFragment extends Fragment {

    private final FragmentManager fragmentManager = getFragmentManager();

     @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Fragment ", "onCreateView");
        View view = inflater.inflate(R.layout.back_and_forward_fragment, container, false);

        super.onCreate(savedInstanceState);


        //Bouton suivant
        view.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "submit clicked", Toast.LENGTH_LONG).show();

            }
        });

        //Bouton retour
        /*view.findViewById(R.id.retour).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* FragmentTransaction fragmentTransaction = null;
                if (fragmentManager != null) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });*/

        return view;
    }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);

         Button suivant = view.findViewById(R.id.submit);

     }

    /*public void openAdvertActivity2() {
        Intent intent = new Intent(this, AdvertActivity2.class);
        startActivity(intent);
    }*/

}
