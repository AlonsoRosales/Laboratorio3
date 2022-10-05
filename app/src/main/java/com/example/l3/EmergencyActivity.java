package com.example.l3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.l3.Entity.Lista;
import com.example.l3.Entity.Mascota;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmergencyActivity extends AppCompatActivity {

    Lista listaEnviada;
    ArrayList<Mascota> listaMascotas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        getSupportActionBar().setTitle("Ambulancias Mascotín");
        listaEnviada = (Lista) getIntent().getSerializableExtra("lista");
        for (Object o : listaEnviada.getListaMascotas()) {
            listaMascotas.add((Mascota) o);
        }
    }

    public void procesarDirección(View view){

        EditText etDest = findViewById(R.id.etDestino);
        EditText etOrig = findViewById(R.id.etOrigen);
        EditText etDNI = findViewById(R.id.etDNI);

        // Se validan los datos ingresados
        Boolean datosValidos = true;
        Boolean dniEncontrado = false;
        if (etDest.getText().toString() == null || etDest.getText().toString().equals("")) {
            etDest.setError("Ingrese el destino");
            datosValidos = false;
        } else if (!etDest.getText().toString().equalsIgnoreCase("Lince") && !etDest.getText().toString().equalsIgnoreCase("San Isidro") && !etDest.getText().toString().equalsIgnoreCase("Magdalena") && !etDest.getText().toString().equalsIgnoreCase("Jesús María")) {
            etDest.setError("Destino no válido");
            datosValidos = false;
        }
        if (etOrig.getText().toString() == null || etOrig.getText().toString().equals("")) {
            etOrig.setError("Ingrese el origen");
            datosValidos = false;
        } else if (!etOrig.getText().toString().equalsIgnoreCase("Lince")) {
            etOrig.setError("Origen no válido");
            datosValidos = false;
        }
        if (etDNI.getText().toString() == null || etDNI.getText().toString().equals("")) {
            etDNI.setError("Ingrese el DNI del dueño");
            datosValidos = false;
        } else if (listaMascotas.isEmpty()) {
            etDNI.setError("No se han registrado mascotas aún");
            datosValidos = false;
        } else if (etDNI.getText().toString().length() != 8) {
            etDNI.setError("El dni debe tener una longitud de 8 caracteres");
            datosValidos = false;
        } else {
            for (Mascota m : listaMascotas) {
                if (m.getDNI().equals(etDNI.getText().toString())) {
                    dniEncontrado = true;
                }
            }
            if (!dniEncontrado) {
                etDNI.setError("El DNI ingresado no es válido");
                datosValidos = false;
            }
            try {
                int dni_numeros = Integer.parseInt(etDNI.getText().toString());
            } catch (NumberFormatException e) {
                etDNI.setError("El dni debe consistir únicamente de números");
                datosValidos = false;
            }
        }

        if (datosValidos) {
            // Se vincula la ruta con la mascota
            for (Mascota m : listaMascotas) {
                if (m.getDNI().equals(etDNI.getText().toString())) {
                    m.setRuta(etOrig.getText().toString() + " - " + etDest.getText().toString());
                }
            }
            Geocoder geocoder = new Geocoder(EmergencyActivity.this, Locale.US);
            try {
                Address direccion = geocoder.getFromLocationName(etDest.getText().toString(),1).get(0);

                // Usados para implementar el mapa
                double longDest = direccion.getLongitude();
                double latDest = direccion.getLatitude();

                // Usado para hallar la ciudad
                String distrito = direccion.getLocality();
                Log.d("direccion", distrito);

                int minutos = 0;
                switch (distrito) {
                    case "Lince":
                        minutos = 10;
                        break;
                    case "San Isidro":
                        minutos = 15;
                        break;
                    case "Magdalena":
                        minutos = 20;
                        break;
                    case "Jesús María":
                        minutos = 25;
                }

                TextView tvContador = findViewById(R.id.contador);
                int cuenta_min = minutos;
                int cuenta_seg = 0;

                for(int ii = minutos; ii > 0; ii--) {
                    for(int jj = 60; jj > 0; jj--) {
                        try {
                            Thread.sleep(1000);
                            if(--cuenta_seg < 0) {
                                cuenta_seg = 59;
                                cuenta_min--;
                            }

                            tvContador.setText(cuenta_min + ":" + (cuenta_seg < 10 ? "0"+cuenta_seg : cuenta_seg));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == android.R.id.home){
            Intent intent1 = new Intent(EmergencyActivity.this,MainActivity.class);
            intent1.putExtra("lista", listaEnviada);
            startActivity(intent1);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}