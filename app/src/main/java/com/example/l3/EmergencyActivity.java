package com.example.l3;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class EmergencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
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
}