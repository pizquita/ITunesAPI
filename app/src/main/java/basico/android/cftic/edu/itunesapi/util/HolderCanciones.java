package basico.android.cftic.edu.itunesapi.util;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import basico.android.cftic.edu.itunesapi.R;
import basico.android.cftic.edu.itunesapi.dto.Cancion;


public class HolderCanciones extends RecyclerView.ViewHolder{

    private TextView caja_cancion;
    private TextView caja_album;
    private TextView caja_artista;

    public HolderCanciones(@NonNull View itemView) {
        super(itemView);

        caja_cancion = (TextView)itemView.findViewById(R.id.txv_cancion);
        caja_album = (TextView)itemView.findViewById(R.id.txv_album);
        caja_album = (TextView)itemView.findViewById(R.id.txv_artista);
    }

    public void cargarCancion(Cancion cancion) {
        caja_cancion.setText(cancion.getTrackName());
        caja_album.setText(cancion.getCollectionName());
       //caja_artista.setText(cancion.getArtistName());
    }
}
