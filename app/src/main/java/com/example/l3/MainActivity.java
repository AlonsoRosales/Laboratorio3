package com.example.l3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Lista listaMascota = new Lista();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent1 = getIntent();
        for (Object obj : listaMascota.getListaMascotas()){
            Mascota mascota = (Mascota) obj;
            System.out.println(mascota.getNombre());
        }
        if (intent1.hasExtra("lista")){
            listaMascota = (Lista) intent1.getSerializableExtra("lista");
        }
        Button buttonRegistro = findViewById(R.id.button_registro);
        Button buttonEmergencia = findViewById(R.id.button_Emergencia);
        Button buttonHistorial = findViewById(R.id.button_Historial);
        buttonRegistro.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RegistroActivity.class );
            intent.putExtra("lista",listaMascota);
            startActivity(intent);
        });
        buttonEmergencia.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,EmergencyActivity.class);
        });
        buttonHistorial.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Historialctivity.class);
            intent.putExtra("lista",listaMascota);
            startActivity(intent);
        });




    }
}