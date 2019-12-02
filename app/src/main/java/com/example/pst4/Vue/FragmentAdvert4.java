package com.example.pst4.Vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pst4.ImagePickActivity;
import com.example.pst4.MakePhotoActivity;
import com.example.pst4.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAdvert4 extends Fragment {
    ImagePickActivity imagePickActivity;
    FragmentAdvert0 fragmentAdvert0 = new FragmentAdvert0();
    int etat;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_advert4, container, false);
        Button galeryButton = view.findViewById(R.id.galery);
        Button takePhoto = view.findViewById(R.id.appareil_photo);

        galeryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*imagePickActivity = new ImagePickActivity();
                imagePickActivity.onClick(v);*/
                Intent intent = new Intent(getContext(), ImagePickActivity.class);
                startActivity(intent);

                 etat = fragmentAdvert0.getEtat();
                Toast.makeText(getContext(), "Etat = " + etat, Toast.LENGTH_SHORT).show();
            }
        });

        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MakePhotoActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
