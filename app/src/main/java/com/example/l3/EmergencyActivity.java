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

import com.example.l3.Entity.Lista;
import com.example.l3.Entity.Mascota;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmergencyActivity extends AppCompatActivity {

    Lista listaEnviada;
    //ArrayList<Mascota> listaMascotas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        getSupportActionBar().setTitle("Ambulancias Mascotín");
        listaEnviada = (Lista) getIntent().getSerializableExtra("lista");
        //Al momento de establecer la ruta, se debe tambien indicar el dni del dueño para vincular la ruta con la mascota
        //Actualizar de la listaEnviada.getListaMascotas() la ruta de la mascota
    }

    public void procesarDirección(View view){

        EditText etDest = findViewById(R.id.etDestino);

        Geocoder geocoder = new Geocoder(EmergencyActivity.this, Locale.US);
        try {
            Address direccion = geocoder.getFromLocationName(etDest.getText().toString(),1).get(0);

            double longDest = direccion.getLongitude();
            double latDest = direccion.getLatitude();

            Log.d("direccion","Long: "+longDest+" | Lat: "+latDest);

        } catch (IOException e) {
            e.printStackTrace();
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