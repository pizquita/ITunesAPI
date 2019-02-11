package basico.android.cftic.edu.itunesapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import basico.android.cftic.edu.itunesapi.dto.Cancion;
import basico.android.cftic.edu.itunesapi.dto.ResultadoCanciones;
import basico.android.cftic.edu.itunesapi.util.AdapterCanciones;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recView;

    private List<Cancion> datos;

    private AdapterCanciones adaptador;
    private ResultadoCanciones resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Llamamos a la clase que descarga canciones
        String artista = "Julio";
        DescargarCanciones dc = new DescargarCanciones(this);//Creamos un nuevo objeto de Descarga canciones pasando como parametro esta activity
        dc.execute(artista);//Este metodo execute llama a doInBackground definido en la clase DescargarCanciones

    }

    public void mostrarResultados(ResultadoCanciones resultadoCanciones)
    {
        try {
            findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Fin de la descarga", Toast.LENGTH_LONG).show();

            datos = resultadoCanciones.getResults();

            if (datos.size() == 0) {
                //setContentView(R.layout.activity_mostrar_sin_records);

            } else {

                cargarLista();

                //adaptador.setDatos(datos);// = new AdapterPuntuaciones(datos);
                //recView = (RecyclerView) findViewById(R.id.myrecycview);
                //recView.setHasFixedSize(true);//opcional, si sé que el tamaño no va a cambiar

                recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                recView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            }
        }catch (Exception e)
        {
            Log.e("MIAPP","Error ",e);
        }
    }

    public void cargarLista()
    {
        //ComparadorPuntuaciones.orden = ordenL;
        //ComparadorPuntuaciones.campo = campoL;

        //Collections.sort(datos, new ComparadorPuntuaciones());
        adaptador = new AdapterCanciones(datos);
        adaptador.setDatos(datos);// = new AdapterPuntuaciones(datos);
        recView = (RecyclerView) findViewById(R.id.myrecycview);
        recView.setAdapter(adaptador);//mostrando la lista
        //Collections.sort(datos,);//ORDEN TOTAL

    }
}
