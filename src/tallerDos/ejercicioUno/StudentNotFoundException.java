package tallerDos.ejercicioUno;

public class StudentNotFoundException extends Exception{
    String nombreEstudiante;
    public StudentNotFoundException(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    @Override
    public String getMessage() {
        return "El estudiante " + nombreEstudiante + " no se encuentra registrado.";
    }
}
