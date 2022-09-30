package com.example.l3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lista listaMascota = new Lista();
        Button buttonRegistro = findViewById(R.id.button_registro);
        buttonRegistro.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegistroActivity.class );
            intent.putExtra("lista",listaMascota);
            startActivity(intent);
        });



    }
}