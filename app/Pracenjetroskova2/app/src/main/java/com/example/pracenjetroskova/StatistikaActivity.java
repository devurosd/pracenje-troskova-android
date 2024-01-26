package com.example.pracenjetroskova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class StatistikaActivity extends AppCompatActivity {

    private ArrayList<Trosak> statTroskovi;

    TextView textJan;
    TextView iznosJan;
    TextView textFeb;
    TextView iznosFeb;
    TextView textMar;
    TextView iznosMar;
    TextView textApr;
    TextView iznosApr;
    TextView textMaj;
    TextView iznosMaj;
    TextView textJun;
    TextView iznosJun;
    TextView textJul;
    TextView iznosJul;
    TextView textAvg;
    TextView iznosAvg;
    TextView textSep;
    TextView iznosSep;
    TextView textOkt;
    TextView iznosOkt;
    TextView textNov;
    TextView iznosNov;
    TextView textDec;
    TextView iznosDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistika);

        Bundle extras = getIntent().getExtras();

        initComponents(extras);
    }

    private void initComponents(Bundle bundle){
        textJan = findViewById(R.id.textJanuar);
        iznosJan = findViewById(R.id.iznosJanuar);
        textFeb = findViewById(R.id.textFebruar);
        iznosFeb = findViewById(R.id.iznosFebruar);
        textMar = findViewById(R.id.textMart);
        iznosMar = findViewById(R.id.iznosMart);
        textApr = findViewById(R.id.textApril);
        iznosApr = findViewById(R.id.iznosApril);
        textMaj = findViewById(R.id.textMaj);
        iznosMaj = findViewById(R.id.iznosMaj);
        textJun = findViewById(R.id.textJun);
        iznosJun = findViewById(R.id.iznosJun);
        textJul = findViewById(R.id.textJul);
        iznosJul = findViewById(R.id.iznosJul);
        textAvg = findViewById(R.id.textAvgust);
        iznosAvg = findViewById(R.id.iznosAvgust);
        textSep = findViewById(R.id.textSeptembar);
        iznosSep = findViewById(R.id.iznosSeptembar);
        textOkt = findViewById(R.id.textOktobar);
        iznosOkt = findViewById(R.id.iznosOktobar);
        textNov = findViewById(R.id.textNovembar);
        iznosNov = findViewById(R.id.iznosNovembar);
        textDec = findViewById(R.id.textDecembar);
        iznosDec = findViewById(R.id.iznosDecembar);

        ArrayList<Double> mesecniTroskovi = new ArrayList<Double>();
        double sumaJanuar = 0;
        double sumaFebruar = 0;
        double sumaMart = 0;
        double sumaApril = 0;
        double sumaMaj = 0;
        double sumaJun = 0;
        double sumaJul = 0;
        double sumaAvgust = 0;
        double sumaSeptembar = 0;
        double sumaOktobar = 0;
        double sumaNovembar = 0;
        double sumaDecembar = 0;

        if(bundle != null){
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Trosak>>() {}.getType();
            statTroskovi = gson.fromJson(bundle.getString("troskoviJson"), type);

            for(int i = 0; i < statTroskovi.size(); i++){

                if(statTroskovi.get(i).getDatumMesec() == 1){
                    sumaJanuar += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 2){
                    sumaFebruar += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 3){
                    sumaMart += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 4){
                    sumaApril += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 5){
                    sumaMaj += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 6){
                    sumaJun += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 7){
                    sumaJul += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 8){
                    sumaAvgust += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 9){
                    sumaSeptembar += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 10){
                    sumaOktobar += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 11){
                    sumaNovembar += statTroskovi.get(i).getIznos();

                }
                if(statTroskovi.get(i).getDatumMesec() == 12){
                    sumaDecembar += statTroskovi.get(i).getIznos();

                }

            }

        }

        mesecniTroskovi.add(sumaJanuar);
        mesecniTroskovi.add(sumaFebruar);
        mesecniTroskovi.add(sumaMart);
        mesecniTroskovi.add(sumaApril);
        mesecniTroskovi.add(sumaMaj);
        mesecniTroskovi.add(sumaJun);
        mesecniTroskovi.add(sumaJul);
        mesecniTroskovi.add(sumaAvgust);
        mesecniTroskovi.add(sumaSeptembar);
        mesecniTroskovi.add(sumaOktobar);
        mesecniTroskovi.add(sumaNovembar);
        mesecniTroskovi.add(sumaDecembar);

        iznosJan.setText("" + sumaJanuar + "  ");
        iznosFeb.setText("" + sumaFebruar + "  ");
        iznosMar.setText("" + sumaMart + "  ");
        iznosApr.setText("" + sumaApril + "  ");
        iznosMaj.setText("" + sumaMaj + "  ");
        iznosJun.setText("" + sumaJun + "  ");
        iznosJul.setText("" + sumaJul + "  ");
        iznosAvg.setText("" + sumaAvgust + "  ");
        iznosSep.setText("" + sumaSeptembar + "  ");
        iznosOkt.setText("" + sumaOktobar + "  ");
        iznosNov.setText("" + sumaNovembar + "  ");
        iznosDec.setText("" + sumaDecembar + "  ");

    }
}