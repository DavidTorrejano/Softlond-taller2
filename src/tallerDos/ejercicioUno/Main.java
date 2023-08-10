package tallerDos.ejercicioUno;

public class Main {
    public static void main(String[] args) throws StudentNotFoundException {
        SistemaAlumnos alumnos = new SistemaAlumnos();

        alumnos.agregarAlumno("David Torrejano", 22);
        alumnos.agregarAlumno("Fabian Perez", 19);
        alumnos.agregarAlumno("Camila Arrieta", 21);
        alumnos.agregarAlumno("Daniela Escorcia", 20);



        alumnos.asignarNota("David Torrejano", "Quimica", 3.36);
        alumnos.asignarNota("David Torrejano", "Castellano", 4.7);
        alumnos.asignarNota("David Torrejano", "Informatica", 3.6);

        alumnos.asignarNota("Fabian Perez", "Quimica", 3.01);
        alumnos.asignarNota("Fabian Perez", "Castellano", 3.7);
        alumnos.asignarNota("Fabian Perez", "Informatica", 4.6);


        alumnos.mostrarInformacionEstudiante("David Torrejano");
        alumnos.mostrarInformacionEstudiante("Fabian Perez");

    }
}
