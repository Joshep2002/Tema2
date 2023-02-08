package p.hastacuando;

public class Rock extends Canciones{
    private String nacionalOextranjero;

    public Rock ( String timeDuration , String autor ,  String year, String nacionalOextranjero){
        super(timeDuration,autor,year);
        this.nacionalOextranjero = nacionalOextranjero;

    }

    public String isNacionalOextranjero() {
        return nacionalOextranjero;
    }

    public void setNacionalOextranjero(String nacionalOextranjero) {
        this.nacionalOextranjero = nacionalOextranjero;
    }

    @Override
    public int nivelAceptacion(int year) {
        int nivelDeAceptacion = year * 10;
        if(nacionalOextranjero == "nacional"){
             nivelDeAceptacion = nivelDeAceptacion + 100 ;
        } else if (nacionalOextranjero == "extranjero") {

        }
        return nivelDeAceptacion;
    }
}
