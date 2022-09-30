package com.example.l3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Historialctivity extends AppCompatActivity {

    ListaHistorialAdapter adapter =  new ListaHistorialAdapter();
    ArrayList<Mascota> listaMascotas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historialctivity);
        getSupportActionBar().setTitle("Ambulancias Mascotín");

        //listaMascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("lista");
        Mascota mascota1 = new Mascota("Paco", "Masculino", "Alonso", "25855489", "Intoxicación");
        Mascota mascota2 = new Mascota("Peppa", "Masculino", "Alonso", "25855489", "Intoxicación");
        Mascota mascota3 = new Mascota("Twilight", "Masculino", "Alonso", "25855489", "Intoxicación");
        Mascota mascota4 = new Mascota("Dash", "Masculino", "Alonso", "25855489", "Intoxicación");
        listaMascotas.add(mascota1);
        listaMascotas.add(mascota2);
        listaMascotas.add(mascota3);
        listaMascotas.add(mascota4);

        adapter.setListaMascotas(listaMascotas);
        adapter.setContext(Historialctivity.this);

        RecyclerView recyclerView = findViewById(R.id.historial_recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Historialctivity.this));
    }

    
}