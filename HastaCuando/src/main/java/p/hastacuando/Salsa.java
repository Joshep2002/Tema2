package p.hastacuando;

public class Salsa extends Canciones{
    private String grupo;

    public Salsa( String timeDuration, String autor,  String year, String grupo) {
        super(timeDuration, autor, year);
        this.grupo=grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public int nivelAceptacion(int year) {
        int nivelDeAceptacion = year * 10;
        return nivelDeAceptacion;
    }
}
