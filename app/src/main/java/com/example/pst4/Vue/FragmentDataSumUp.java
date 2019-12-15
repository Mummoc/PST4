package com.example.pst4.Vue;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pst4.Controller.RecyclerAdapter;
import com.example.pst4.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentDataSumUp extends Fragment {
    List<String> data = new ArrayList<String>();
    TextView textViewVoiture;
    TextView textViewMarque;
    TextView textViewModele;
    TextView textViewVersion;
    TextView textViewAnneeDeFabrication;
    TextView textViewMiseEnCirculation;
    TextView textViewImmatriculation;
    TextView textViewPremiereMain;
    TextView textViewKilometrage;
    TextView textViewCouleur;
    TextView textViewNbrPortes;
    TextView textViewTypeCoffre;
    TextView textViewOption;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> input = new ArrayList<>();
    String marque;
    String modele;
    String version;

    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if("DATA_BRAND".equals(intent.getAction())){

                Log.e("Bundle ", "YOOOOOOOOOOOOOOOOOOOOOOOOOO");
                    marque = intent.getStringExtra("DATA_CAR");
                    modele = intent.getStringExtra("DATA_MODELE");
                    version = intent.getStringExtra("DATA_VERSION");
                    Log.e("GET EXTRAS", marque);


                Log.e("RESULt ", "FIN IF");
                /*intent.getSerializableExtra("DATA_CAR");
                intent.getAction();
                marque = intent.getStringExtra("DATA_CAR");
                modele = intent.getStringExtra("DATA_MODELE");
                version = intent.getStringExtra("DATA_VERSION");*/

            }
        }


    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_data_sumup, container, false);
        LocalBroadcastManager.getInstance(Objects.requireNonNull(getContext())).registerReceiver(broadcastReceiver, new IntentFilter("DATA_CAR"));
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        Log.i("MY TAG", "YOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        input.add("Voiture : ");
        input.add("Marque : ");
        input.add(marque);
        input.add("Modèle : ");
        input.add(modele);
        input.add("Version : ");
        input.add(version);
        input.add("Année de fabrication : ");
        input.add("Année de mise en circulation : ");
        input.add("Plaque d'immatriculation : ");
        input.add("Première main : ");
        input.add("Kilométrage : ");
        input.add("Couleur : ");
        input.add("Nombre de portes : ");
        input.add("Type de coffre : ");
        input.add("Option : ");
        mAdapter = new RecyclerAdapter(input);

        recyclerView.setAdapter(mAdapter);






        /*int i;
        //TextViews contenant les données
        textViewVoiture = view.findViewById(R.id.etat_voiture);
        textViewMarque = view.findViewById(R.id.marque);
        textViewModele = view.findViewById(R.id.modele);
        textViewVersion = view.findViewById(R.id.version);
        textViewAnneeDeFabrication = view.findViewById(R.id.annee_de_fabrication);
        textViewMiseEnCirculation = view.findViewById(R.id.annee_circulation);
        textViewImmatriculation = view.findViewById(R.id.plaque_immatriculation);
        textViewPremiereMain = view.findViewById(R.id.premiere_main);
        textViewKilometrage = view.findViewById(R.id.kilometrage);
        textViewCouleur = view.findViewById(R.id.couleur);
        textViewNbrPortes = view.findViewById(R.id.nombre_de_porte);
        textViewTypeCoffre = view.findViewById(R.id.type_coffre);
        textViewOption = view.findViewById(R.id.option);

        TextView[] textViewsData = {textViewVoiture, textViewMarque, textViewModele, textViewVersion, textViewAnneeDeFabrication, textViewMiseEnCirculation, textViewImmatriculation, textViewPremiereMain, textViewKilometrage, textViewCouleur, textViewNbrPortes, textViewTypeCoffre, textViewOption};//

        //mettre tout ca dans un adapter
        FragmentAdvert1 fragmentAdvert1 = new FragmentAdvert1();
        FragmentAdvert2 fragmentAdvert2 = new FragmentAdvert2();
        FragmentAdvert3 fragmentAdvert3 = new FragmentAdvert3();
        data.add("Voiture");
        data.add(fragmentAdvert1.getMarque());
        data.add(fragmentAdvert1.getModele());
        data.add(fragmentAdvert1.getVersionVoiture());
        data.add("Année de fabrication");//fragmentAdvert2.getAnneeDeFabrication()
        data.add("Année de mise en circulation");//fragmentAdvert2.getAnneeMiseEncirculation()
        data.add(" Année de fabrication");
        data.add(" Année de mise en circulation");
        data.add(" Plaque d'immatriculation");
        data.add(" Kilometrage");
        data.add("Couleur");//fragmentAdvert3.getCouleurVoiture()
        data.add("Nombre de porte");//fragmentAdvert3.getNbrDePortes()
        data.add("Type de coffre");//fragmentAdvert3.getTypeDeCoffre()
        data.add("Option");//fragmentAdvert3.getOptions()

        for (i = 0; i<textViewsData.length; i++) textViewsData[i].setText(data.get(i));*/
    //String message = fragmentAdvert1.getMarque();
      //  Log.i("My tag :", message);


        return view;
    }
}
