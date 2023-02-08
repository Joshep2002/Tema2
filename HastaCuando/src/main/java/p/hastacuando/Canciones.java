package p.hastacuando;

import javafx.collections.ObservableList;

public abstract class Canciones {
    public ObservableList<Canciones> todasCanciones;


    private  String timeDuration ;
    private String autor;
    private  String year;

    public Canciones( String timeDuration, String autor,  String year) {
        this.timeDuration = timeDuration;
        this.autor = autor;
        this.year = year;
    }

    public ObservableList<Canciones> getTodasCanciones() {
        return todasCanciones;
    }

    public void setTodasCanciones(ObservableList<Canciones> todasCanciones) {
        this.todasCanciones = todasCanciones;
    }

    public  String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration( String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getYear() {
        return year;
    }

    public void setYear( String year) {
        this.year = year;
    }



    public abstract int nivelAceptacion(int year);
}
