package com.example.l3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.l3.Entity.Lista;
import com.example.l3.Entity.Mascota;

import java.util.ArrayList;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {
    public Lista mascotas = null;
    String genero;

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

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String opcionSpinner = spinner.getSelectedItem().toString();
                if (opcionSpinner.equals("Femenino/Masculino")) {
                    genero = "-";
                } else {
                    genero = opcionSpinner;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                genero = "-";
            }
        });

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

//        TextView textView1 = findViewById(R.id.nombreMascota);
//        String nombreMascota = textView1.getText().toString();
//
//        Spinner spinner = findViewById(R.id.spinner);
//        String genero = spinner.getSelectedItem().toString();
//
//        TextView textView2 = findViewById(R.id.nombreDueno);
//        String nombreDueno = textView2.getText().toString();
//
//        TextView textView3 = findViewById(R.id.dni);
//        String dni = textView3.getText().toString();
//
//        TextView textView4 = findViewById(R.id.descripcion);
//        String descripcion = textView4.getText().toString();

        EditText nombre = findViewById(R.id.nombreMascota);
        EditText duenio = findViewById(R.id.nombreDueno);
        EditText dni = findViewById(R.id.dni);
        EditText descripcion = findViewById(R.id.descripcion);
        boolean guardar = true;
        if (nombre.getText().toString().equals("") || nombre.getText().toString() == null) {
            nombre.setError("Ingrese el nombre de la mascota");
            guardar = false;
        }
        if (duenio.getText().toString().equals("") || duenio.getText().toString() == null) {
            duenio.setError("Ingrese el nombre del dueño");
            guardar = false;
        }
        if (dni.getText().toString().equals("") || dni.getText().toString() == null) {
            dni.setError("Ingrese el dni del dueño");
            guardar = false;
        } else if (dni.getText().toString().length() != 8) {
            dni.setError("El dni debe tener una longitud de 8 caracteres");
            guardar = false;
        } else {
            try {
                int dni_numeros = Integer.parseInt(dni.getText().toString());
            } catch (NumberFormatException e) {
                dni.setError("El dni debe consistir únicamente de números");
                guardar = false;
            }
        }
        if (descripcion.getText().toString().equals("") || descripcion.getText().toString() == null) {
            descripcion.setError("Ingrese una descripción");
            guardar = false;
        }

        if (guardar) {
            Mascota mascota = new Mascota(nombre.getText().toString(),genero,duenio.getText().toString(),dni.getText().toString(),descripcion.getText().toString());
            mascotas.getListaMascotas().add(mascota);

            Intent intent = new Intent(RegistroActivity.this,MainActivity.class);
            intent.putExtra("lista",mascotas);
            startActivity(intent);
        }

    }
}