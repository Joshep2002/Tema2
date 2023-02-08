package p.hastacuando;

public class Pop extends Canciones{
    private String masculinoOfemenino;

    public Pop( String timeDuration, String autor,  String year,String masculinoOfemenino) {
        super(timeDuration, autor, year);
        this.masculinoOfemenino=masculinoOfemenino;
    }

    public String isMasculinoOfemenino() {
        return masculinoOfemenino;
    }

    public void setMasculino(String masculinoOfemenino) {
        this.masculinoOfemenino = masculinoOfemenino;
    }

    @Override
    public int nivelAceptacion(int year) {
        int nivelDeAceptacion = year * 10;
        return nivelDeAceptacion;
    }
}
