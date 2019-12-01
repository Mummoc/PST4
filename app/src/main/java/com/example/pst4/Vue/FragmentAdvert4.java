package com.example.pst4.Vue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pst4.ImagePickActivity;
import com.example.pst4.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAdvert4 extends Fragment {
    ImagePickActivity imagePickActivity;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_advert4, container, false);
        Button galeryButton = view.findViewById(R.id.galery);
        galeryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePickActivity = new ImagePickActivity();
                imagePickActivity.onClick(v);
            }
        });
        return view;
    }
}
