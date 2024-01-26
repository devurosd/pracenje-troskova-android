package com.example.pracenjetroskova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class DodajTrosakActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputNaziv;
    private EditText inputIznos;
    private DatePicker inputDatum;
    private Button buttonDodaj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_trosak);

        initComponents();
    }

    private void initComponents(){

        inputNaziv = findViewById(R.id.edit_text_naziv);
        inputIznos = findViewById(R.id.edit_text_iznos);
        inputDatum = findViewById(R.id.datum);
        buttonDodaj = findViewById(R.id.button_dodaj);

        buttonDodaj.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_dodaj){
            Intent intent = new Intent(this, MainActivity.class);

            String naziv = inputNaziv.getText().toString();
            String iznos = inputIznos.getText().toString();
            int datumDan = inputDatum.getDayOfMonth();
            int datumMesec = inputDatum.getMonth();
            int datumGodina = inputDatum.getYear();

            Bundle extras = new Bundle();

            if(naziv.equals("") && iznos.equals("")){
                Toast.makeText(getApplicationContext(), "Polja ne mogu biti prazna", Toast.LENGTH_SHORT).show();
            }else {

                extras.putString("naziv", naziv);
                extras.putString("iznos", iznos);
                extras.putInt("datumDan", datumDan);
                extras.putInt("datumMesec", datumMesec);
                extras.putInt("datumGodina", datumGodina);

                intent.putExtras(extras);
                startActivity(intent);

                inputNaziv.setText("");
                inputIznos.setText("");

                Toast.makeText(this, "Dodato: " + naziv, Toast.LENGTH_SHORT).show();
            }
        }
    }
}