package com.example.l3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.l3.Entity.Lista;
import com.example.l3.Entity.Mascota;

public class MainActivity extends AppCompatActivity {

    Lista listaMascota = new Lista();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Ambulancias Mascotín");
        Intent intent1 = getIntent();

        if (intent1.hasExtra("lista")){
            listaMascota = (Lista) intent1.getSerializableExtra("lista");

            for (Object obj : listaMascota.getListaMascotas()){
                Mascota mascota = (Mascota) obj;
                System.out.println("-----------------------------");
                System.out.println(mascota.getNombre());
                System.out.println(mascota.getGenero());
                System.out.println(mascota.getNombreDuenho());
                System.out.println(mascota.getDNI());
                System.out.println(mascota.getDescripcion());
            }

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
            intent.putExtra("lista",listaMascota);
            startActivity(intent);
        });
        buttonHistorial.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Historialctivity.class);
            intent.putExtra("lista",listaMascota);
            startActivity(intent);
        });




    }
}