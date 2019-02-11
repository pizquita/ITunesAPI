package basico.android.cftic.edu.itunesapi.dto;


import java.util.List;

import basico.android.cftic.edu.itunesapi.dto.Cancion;

/**
 * Clase tipo BIN de JAVA solo tiene contructor y Getter an d Setter de sus atributos
 * Es el que recoge los datos de las conexiones debe tener la misma estructura de los archivos que va a recibir
 * */
public class ResultadoCanciones {


    private int resultCount;
    private List<Cancion> results; //Debe coincidir el nombre del atributo con el nombre que devuelve la api para ese atributo


    /*Constructores*/
    public ResultadoCanciones() {
    }

    public ResultadoCanciones(int resultCount, List<Cancion> results) {
        this.resultCount = resultCount;
        this.results = results;
    }
    /*Fin Construcctores*/


    /*Getter al Setter*/
    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Cancion> getResults() {
        return results;
    }

    public void setResults(List<Cancion> results) {
        this.results = results;
    }
    /*Fin Getter And Setter*/
}
