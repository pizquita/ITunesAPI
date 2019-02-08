package basico.android.cftic.edu.itunesapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
        findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
        Toast.makeText(this,"Fin de la descarga",Toast.LENGTH_LONG).show();
    }
}
