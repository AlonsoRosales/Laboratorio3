package com.example.l3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.l3.Entity.Lista;
import com.example.l3.Entity.Mascota;

import java.util.ArrayList;

public class Historialctivity extends AppCompatActivity {

    ListaHistorialAdapter adapter =  new ListaHistorialAdapter();
    Lista listaEnviada;
    ArrayList<Mascota> listaMascotas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historialctivity);
        getSupportActionBar().setTitle("Ambulancias Mascotín");

        listaEnviada = (Lista) getIntent().getSerializableExtra("lista");
        for (Object o : listaEnviada.getListaMascotas()) {
            listaMascotas.add((Mascota) o);
        }

//        Mascota mascota1 = new Mascota("Paco", "Masculino", "Alonso", "25855489", "Intoxicación");
//        Mascota mascota2 = new Mascota("Peppa", "Masculino", "Alonso", "25855489", "Intoxicación");
//        Mascota mascota3 = new Mascota("Twilight", "Masculino", "Alonso", "25855489", "Intoxicación");
//        Mascota mascota4 = new Mascota("Dash", "Masculino", "Alonso", "25855489", "Intoxicación");
//        listaMascotas.add(mascota1);
//        listaMascotas.add(mascota2);
//        listaMascotas.add(mascota3);
//        listaMascotas.add(mascota4);
//        Mascota mascota5 = new Mascota("Dash", "Masculino", "Alonso", "25855489", "Intoxicación");
//        listaMascotas.add(mascota5);

        if(listaMascotas!=null){
            if(listaMascotas.size()==0) {
                TextView nomascotas = findViewById(R.id.text_noregistromascotas);
                nomascotas.setVisibility(nomascotas.VISIBLE);
            }
            adapter.setListaMascotas(listaMascotas);
            adapter.setContext(Historialctivity.this);

            RecyclerView recyclerView = findViewById(R.id.historial_recyclerView);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(Historialctivity.this));
        }else{
            Log.d("msg","No se han enviado mascotas!");
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == android.R.id.home){
            Intent intent1 = new Intent(Historialctivity.this,MainActivity.class);
            intent1.putExtra("lista", listaEnviada);
            startActivity(intent1);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
}