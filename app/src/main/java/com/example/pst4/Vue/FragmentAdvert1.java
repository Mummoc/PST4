package com.example.pst4.Vue;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.pst4.Controller.SpinnerController;
import com.example.pst4.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAdvert1 extends Fragment {
    private Context mContext;
    String marque;
    Spinner spinnerMarque;
    Spinner spinnerModele;
    Spinner spinnerVersion;
    private SpinnerController spinnerMarqueController = new SpinnerController();
    private SpinnerController spinnerModeleController = new SpinnerController();
    private SpinnerController spinnerVersionController = new SpinnerController();

    /*public FragmentAdvert1(Context context) {
        this.mContext = context;
    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_advert1, container, false);

        //Marque de voiture
        ArrayAdapter spinnerMarqueArrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.spinner_marque, R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter spinnerModeleArrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.spinner_modele, R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter spinnerVersionArrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.spinner_version, R.layout.support_simple_spinner_dropdown_item);

        spinnerMarqueArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerModeleArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerVersionArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinnerMarque = view.findViewById(R.id.spinner_marque);
        spinnerModele = view.findViewById(R.id.spinner_modele);
        spinnerVersion = view.findViewById(R.id.spinner_version);

        spinnerMarque.setAdapter(spinnerMarqueArrayAdapter);
        spinnerModele.setAdapter(spinnerModeleArrayAdapter);
        spinnerVersion.setAdapter(spinnerVersionArrayAdapter);

        spinnerMarqueController.setSpinnerControler(spinnerMarque);
        spinnerModeleController.setSpinnerControler(spinnerModele);
        spinnerVersionController.setSpinnerControler(spinnerVersion);

        return view;

    }

    public String getMarque() {
        return spinnerMarqueController.getText().toString();
    }

    public String getModele(){
        return spinnerModeleController.getText();
    }

    public String getVersionVoiture(){
        return spinnerVersionController.getText();
    }
}
