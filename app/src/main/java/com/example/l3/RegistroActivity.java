package com.example.l3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {
    public Lista mascotas = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setTitle("Ambulancias Mascotín");

        ActionBar actionBar =  getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        List<String> generosSpinner = new ArrayList<>();
        generosSpinner.add(0,"Femenino/Masculino");
        generosSpinner.add("Femenino");
        generosSpinner.add("Masculino");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,generosSpinner);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);

        Intent intent = getIntent();
        Lista listita = (Lista) intent.getSerializableExtra("lista");
        mascotas = listita;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == android.R.id.home){
            Intent intent1 = new Intent(RegistroActivity.this,MainActivity.class);
            intent1.putExtra("lista",mascotas);
            startActivity(intent1);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void devolverMascotaCreada(View view){
        TextView textView1 = findViewById(R.id.nombreMascota);
        String nombreMascota = textView1.getText().toString();

        Spinner spinner = findViewById(R.id.spinner);
        String genero = spinner.getSelectedItem().toString();

        TextView textView2 = findViewById(R.id.nombreDueno);
        String nombreDueno = textView2.getText().toString();

        TextView textView3 = findViewById(R.id.dni);
        String dni = textView3.getText().toString();

        TextView textView4 = findViewById(R.id.descripcion);
        String descripcion = textView4.getText().toString();

        Mascota mascota = new Mascota(nombreMascota,genero,nombreDueno,dni,descripcion);

        mascotas.getListaMascotas().add(mascota);

        Intent intent = new Intent(RegistroActivity.this,MainActivity.class);
        intent.putExtra("lista",mascotas);
        startActivity(intent);

    }
}