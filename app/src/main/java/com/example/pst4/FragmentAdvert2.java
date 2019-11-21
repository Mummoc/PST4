package com.example.pst4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAdvert2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_advert2, container, false);
        List age = new ArrayList<Integer>();

        //Marque de voiture
        for (int i = 1900; i<2019; i++){
            age.add(Integer.toString(i));
        }
        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<Integer>(Objects.requireNonNull(getContext()), R.layout.support_simple_spinner_dropdown_item, age);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        Spinner spinnerMarque = view.findViewById(R.id.spinner_yearcraft);
        Spinner spinnerMiseEnCirculation = view.findViewById(R.id.spinner_mise_circulation);

        spinnerMarque.setAdapter(spinnerArrayAdapter);
        spinnerMiseEnCirculation.setAdapter(spinnerArrayAdapter);

        return view;
    }
}
