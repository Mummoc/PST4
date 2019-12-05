package com.example.pst4.Vue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.pst4.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAdvert3 extends Fragment {
    String couleurVoiture;
    String nbrDePortes;
    String typeDeCoffre;
    String options;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_advert3, container, false);

        List couleur = new ArrayList<String>();
        couleur.add("Rouge");
        couleur.add("Bleue");
        couleur.add("Jaune");
        couleur.add("Vert");

        List nbrPortes = new ArrayList<Integer>();
        nbrPortes.add(5);
        nbrPortes.add(3);

        List typeCoffre = new ArrayList<String>();
        typeCoffre.add("Coffre");
        typeCoffre.add("Hayon");

        List optionlist = new ArrayList<String>();
        optionlist.add("Option");

        ArrayAdapter<Integer> spinnerColorArrayAdapter = new ArrayAdapter<Integer>(Objects.requireNonNull(getContext()), R.layout.support_simple_spinner_dropdown_item, couleur);
        ArrayAdapter<Integer> spinnerNbrPortesArrayAdapter = new ArrayAdapter<Integer>(Objects.requireNonNull(getContext()), R.layout.support_simple_spinner_dropdown_item, nbrPortes);
        ArrayAdapter<Integer> spinnerTypeCoffreArrayAdapter = new ArrayAdapter<Integer>(Objects.requireNonNull(getContext()), R.layout.support_simple_spinner_dropdown_item, typeCoffre);
        ArrayAdapter<Integer> spinnerOptionArrayAdapter = new ArrayAdapter<Integer>(Objects.requireNonNull(getContext()), R.layout.support_simple_spinner_dropdown_item, optionlist);

        spinnerColorArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerNbrPortesArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerTypeCoffreArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerOptionArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        Spinner spinnerColor = view.findViewById(R.id.spinner_color);
        Spinner spinnerNbrPortes = view.findViewById(R.id.spinner_nbr_portes);
        Spinner spinnerTypeCoffre = view.findViewById(R.id.spinner_type_coffre);
        Spinner spinnerOption = view.findViewById(R.id.spinner_option);

        spinnerNbrPortes.setAdapter(spinnerNbrPortesArrayAdapter);
        spinnerColor.setAdapter(spinnerColorArrayAdapter);
        spinnerTypeCoffre.setAdapter(spinnerTypeCoffreArrayAdapter);
        spinnerOption.setAdapter(spinnerOptionArrayAdapter);

        couleurVoiture = spinnerColor.getSelectedItem().toString();
        nbrDePortes = spinnerNbrPortes.getSelectedItem().toString();
        typeDeCoffre = spinnerTypeCoffre.getSelectedItem().toString();
        options = spinnerOption.getSelectedItem().toString();

        return view;
    }

    public String getCouleurVoiture() {
        return couleurVoiture;
    }

    public void setCouleurVoiture(String couleurVoiture) {
        this.couleurVoiture = couleurVoiture;
    }

    public String getNbrDePortes() {
        return nbrDePortes;
    }

    public void setNbrDePortes(String nbrDePortes) {
        this.nbrDePortes = nbrDePortes;
    }

    public String getTypeDeCoffre() {
        return typeDeCoffre;
    }

    public void setTypeDeCoffre(String typeDeCoffre) {
        this.typeDeCoffre = typeDeCoffre;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
