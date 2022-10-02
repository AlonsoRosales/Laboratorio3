package com.example.l3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l3.Entity.Mascota;

import java.util.ArrayList;

public class ListaHistorialAdapter extends RecyclerView.Adapter<ListaHistorialAdapter.HistorialViewHolder> {

    private ArrayList<Mascota> listaMascotas;
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public class HistorialViewHolder extends RecyclerView.ViewHolder {
        Mascota mascota;

        public HistorialViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    @NonNull
    @Override
    public HistorialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_historial, parent, false);
        return new HistorialViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistorialViewHolder holder, int position) {
        Mascota mascota = getListaMascotas().get(position);
        holder.mascota = mascota;

        TextView textViewInfo = holder.itemView.findViewById(R.id.item_mascota);
        if (position%2 != 0) {
            textViewInfo.setBackgroundColor(0xFFC5C5C5);
        }
        //Crear el string y adjuntarlo a la vista
        String infoMascota =
                        "Mascota: " + mascota.getNombre() + "\n" +
                        "Género: " + mascota.getGenero() + "\n" +
                        "Dueño: " + mascota.getNombreDuenho() + "\n" +
                        "DNI: " + mascota.getDNI() + "\n" +
                        "Descripción: " + mascota.getDescripcion() + "\n" +
                        "Ruta: " + ((mascota.getRuta() == null || mascota.getRuta().equals("")) ? "-" : mascota.getRuta());
        textViewInfo.setText(infoMascota);
    }

    @Override
    public int getItemCount() {
        return getListaMascotas().size();
    }

}
