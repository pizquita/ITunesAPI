package basico.android.cftic.edu.itunesapi.util;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import basico.android.cftic.edu.itunesapi.R;
import basico.android.cftic.edu.itunesapi.dto.Cancion;
import basico.android.cftic.edu.itunesapi.dto.ResultadoCanciones;

public class AdapterCanciones extends RecyclerView.Adapter<HolderCanciones> implements  View.OnClickListener{

    private List<Cancion> datos;

    @NonNull
    @Override
    public HolderCanciones onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        HolderCanciones holderCanciones = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.fila_cancion, viewGroup, false);
        itemView.setOnClickListener(this);//asociaría el listener, this da error si no se implementa la interfaz View.OnClickListener y se sobreescribe el método onClick
        holderCanciones = new HolderCanciones(itemView);

        return holderCanciones;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCanciones holderCanciones, int i) {
        Cancion cancion = datos.get(i);
        holderCanciones.cargarCancion(cancion);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public AdapterCanciones (List<Cancion> lista_canciones)
    {
        this.datos = lista_canciones;
    }

    public void setDatos (List<Cancion> lista_canciones)
    {
        this.datos = lista_canciones;
    }
    @Override
    public void onClick(View view) {

    }
}
