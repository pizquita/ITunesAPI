package basico.android.cftic.edu.itunesapi;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import basico.android.cftic.edu.itunesapi.dto.ResultadoCanciones;


/**
 * Esta clase debe heredar de AyncTask porque se ejecutar&aacute; de forma paralela
 * ya que el acceso a internet debe ir de esta manera para no bloquear la pantalla
 * Por esto no se permite conectarse a interner desde Activity y debe realizarse en una clase a parte
 *
 * Parametros de AsyncTask
 * @params String solicitud
 * @param  "Void" tiempo que tarda, suele ser un int pero en este caso no lo usamos y ponemos Void
 * @param "ResultadoCanciones" lo que devuelve con la misma estrucctura de los datos que devuelve la API en un JSON
 * */
public class DescargarCanciones extends AsyncTask<String,Void,ResultadoCanciones> {

    private static final String URI_ITUNES = "https://itunes.apple.com/search/?media=music&term=";
    private Context context; //Variable que contiene la actividad a la que vuelve


    /*Contructor que recibe como parametro la Activity a la que debe retornar*/
    public DescargarCanciones (Context context) {
        this.context  = context;
    }
    /*Fin Constructor*/

    /**
     * Método que realiza la conexión a internet y recupera los datos
     * */
    @Override
    protected ResultadoCanciones doInBackground(String ... canciones) { //String[] es equivalente a String ...

        /*Declaración de variables*/
        ResultadoCanciones resultadoCanciones = null;//Objeto que vamos a devolver
        URL url = null;//para url de Internet
        HttpURLConnection httpURLConnection = null; //Protocolo de conexión
        InputStreamReader inputStreamReader = null; //donde se recoge el mensaje
        Gson gson = null;



        //Las conexiones siempre en try porque pueden fallar
        try{
            url = new URL(URI_ITUNES + canciones[0]);//Montamos la url como solo pasamos un parametro desde Main por eso cogemos la posición 0
            httpURLConnection = (HttpURLConnection)url.openConnection();//Abrimos la conexión con el protocolo http
            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                //La conexón ha funcionado
                String ct = httpURLConnection.getContentType();//Devuelve el tipo de objeto que devuelve la respuesta, en este caso JSON
                Log.d("MIAPP","TIPO MIME RECIBIDO "+ ct);

                inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());//Accedo al cuerpo del mensaje
                gson = new Gson();
                resultadoCanciones = gson.fromJson(inputStreamReader,ResultadoCanciones.class);
            }
        }
        catch (Exception e)
        {
            Log.e("MIAPP","Error a tratar de conectar",e);
        }
        finally {//falle o no esta acción se ejecuta

            /*Cerramos la conexión en cualquier caso para no dejar la aplicación colgada*/
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpURLConnection.disconnect();
        }

        return resultadoCanciones;
    }

    /**
     * Método que será invocado cuando acabe doInBackground
     * */
    @Override
    protected void onPostExecute(ResultadoCanciones rc) {
        super.onPostExecute(rc);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();//Creamos un GsonBuilder para recuperlo de forma estructurada
        String string_canciones = gson.toJson(rc);//Cargamos en nuestro string el gson con la estrucctura de ResultadoCanciones

        Log.d("MIAPP","Canciones" + string_canciones);

        if(this.context instanceof MainActivity)//Preguntamos por el tipo de context para saber la pantalla que le ha llamado
        {
            MainActivity ma = (MainActivity)this.context;
            ma.mostrarResultados(rc);//devuelve los resultados a la MainActivity
        }
    }
}
