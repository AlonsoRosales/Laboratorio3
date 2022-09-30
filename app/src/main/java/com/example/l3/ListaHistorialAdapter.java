package com.example.l3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListaHistorialAdapter extends RecyclerView.Adapter<ListaHistorialAdapter.HistorialViewHolder> {

    private Mascota[] listaMascotas;
    private Context context;

    public class HistorialViewHolder extends RecyclerView.ViewHolder {
        Mascota mascota;

        public HistorialViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    @NonNull
    @Override
    public HistorialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_historial, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HistorialViewHolder holder, int position) {
        Mascota mascota = listaMascotas[position];
        holder.mascota = mascota;

        TextView textViewInfo = holder.itemView.findViewById(R.id.item_mascota);
        //Crear el string y adjuntarlo a la vista
        String infoMascota =
                        "Mascota: " + mascota.getNombre() + "\n" +
                        "Género: " + mascota.getGenero() + "\n" +
                        "Dueño: " + mascota.getNombreDuenho() + "\n" +
                        "DNI: " + mascota.getDNI() + "\n" +
                        "Descripción: " + mascota.getDescripcion() + "\n" +
                        "Ruta: " + mascota.getRuta();
        textViewInfo.setText(infoMascota);
    }

    @Override
    public int getItemCount() {
        return listaMascotas.length;
    }

}
