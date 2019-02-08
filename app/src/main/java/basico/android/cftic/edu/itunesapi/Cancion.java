package basico.android.cftic.edu.itunesapi;

public class Cancion {

    //El nombre de los atributos debe coincidir con el nombre que devuelve la api para ese atributo
    private String artistName;
    private String trackName;
    private int artistId;
    private String collectionName;

    /**
     * Construcctor por defecto
     * */
    public Cancion() {
    }

    /**
     * Construcctor con valores
     * */
    public Cancion(String artistName, String trackName, int artistId, String collectionName) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.artistId = artistId;
        this.collectionName = collectionName;
    }

    //Getter and Setter
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
    //Getter and Setter fin



}
