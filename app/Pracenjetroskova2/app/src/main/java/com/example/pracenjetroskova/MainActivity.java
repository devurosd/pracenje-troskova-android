package com.example.pracenjetroskova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static ArrayList<Trosak> troskovi = new ArrayList<Trosak>();
    private Button buttonPlus;
    private Button buttonObrisiSve;

    private Button buttonStat;
    private TextView ukupno;
    private ListView lista;

    private ArrayAdapter<Trosak> trosakAdapter;

    private final static String SHARED_PREFERENCES_PREFIX = "MyActivitySharedPreferences";
    private final static String SHARED_PREFERENCES_KEY_TROSKOVI = "troskovi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle extras = getIntent().getExtras();

        initComponents(extras);
    }

    private void initComponents(Bundle bundle){
        buttonPlus = findViewById(R.id.button_plus);
        buttonObrisiSve = findViewById(R.id.button_obrisiSve);
        buttonStat = findViewById(R.id.button_stat);
        ukupno = findViewById(R.id.text_ukupno);
        lista = findViewById(R.id.lista_prikaz);

        buttonPlus.setOnClickListener(this);
        buttonObrisiSve.setOnClickListener(this);
        buttonStat.setOnClickListener(this);

        if(bundle != null) {
            troskovi.add(new Trosak(
                    bundle.getString("naziv"),
                    Double.parseDouble(bundle.getString("iznos")),
                    bundle.getInt("datumDan"),
                    bundle.getInt("datumMesec"),
                    bundle.getInt("datumGodina"))
            );
            sacuvajListu(troskovi);
            ukupno.setText("Ukupno: " + suma() + " RSD");
        }else {
            ukupno.setText("Ukupno: " + suma() + " RSD");

        }

        trosakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ucitajListu());
        lista.setAdapter(trosakAdapter);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == (R.id.button_plus)){
            Intent intent = new Intent(this, DodajTrosakActivity.class);
            startActivity(intent);

        } else if(v.getId() == R.id.button_obrisiSve){
            troskovi = new ArrayList<>();
            trosakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, troskovi);
            lista.setAdapter(trosakAdapter);
            sacuvajListu(troskovi);
            ukupno.setText("Ukupno: " + suma() + " RSD");

        }else if(v.getId() == R.id.button_stat){
            Gson gson = new Gson();
            Bundle extras = new Bundle();
            String troskoviJson = gson.toJson(troskovi);

            extras.putString("troskoviJson", troskoviJson);

            Intent intent = new Intent(this, StatistikaActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(troskovi != null){
            troskovi = ucitajListu();
            ukupno.setText("Ukupno: " + suma() + " RSD");
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        sacuvajListu(troskovi);
    }

    private void sacuvajListu(ArrayList<Trosak> t){
        SharedPreferences sp = getSharedPreferences(SHARED_PREFERENCES_PREFIX, 0);
        SharedPreferences.Editor editor = sp.edit();

        Gson gson = new Gson();
        String troskoviJson = gson.toJson(t);

        editor.putString(SHARED_PREFERENCES_KEY_TROSKOVI, troskoviJson);
        editor.apply();
    }

    private ArrayList<Trosak> ucitajListu(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREFERENCES_PREFIX, MODE_PRIVATE);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Trosak>>(){}.getType();

        String listaString = sp.getString(SHARED_PREFERENCES_KEY_TROSKOVI, "");

        return gson.fromJson(listaString, type);
    }

    private double suma(){
        double suma = 0;

        if(troskovi != null) {
            for (int i = 0; i < troskovi.size(); i++) {
                suma += troskovi.get(i).getIznos();
            }
        }else{
            suma = 0;
        }

        return suma;
    }

}