package tallerDos.ejercicioUno;

import java.util.ArrayList;
import java.util.HashMap;


public class SistemaAlumnos {
    ArrayList<Alumno> alumnos = new ArrayList<>();

    private int existenciaAlumno(String nombreAlumno) throws StudentNotFoundException {
        int indice = -1;
        for(int i=0; i<alumnos.size(); i++){
            Alumno alumno = alumnos.get(i);
            if (alumno.getNombre().equals(nombreAlumno)){
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            System.out.println("El alumno no existe, por favor agregalo.");
            throw new StudentNotFoundException(nombreAlumno);
        }
        return indice;
    }

    public void agregarAlumno(String nombre, int edad) {
        Alumno nuevoAlumno = new Alumno(nombre, edad);
        alumnos.add(nuevoAlumno);
    }

    public void asignarNota(String nombreAlumno, String materia, double nota) throws StudentNotFoundException {
        alumnos.get(existenciaAlumno(nombreAlumno)).asignarCalificacion(materia, nota);
    }

    public void calcularPromedioAlumno(String nombreAlumno) throws StudentNotFoundException {
        Alumno alumno = alumnos.get(existenciaAlumno(nombreAlumno));
        double[] sumaNotas = new double[1];
        int totalMaterias = alumno.materiasVistas();
        HashMap<String, Double> notas = alumno.obtenerNotas();
        notas.forEach((materia, nota) -> sumaNotas[0] += nota);
        double promedio = sumaNotas[0]/totalMaterias;
        System.out.printf("%.2f", promedio);
        System.out.println();
    }

    public void mostrarInformacionEstudiante(String nombre) throws StudentNotFoundException{
        Alumno alumno = alumnos.get(existenciaAlumno(nombre));
        System.out.println("Nombre y apellido: " + alumno.getNombre());
        System.out.println("Edad: " + alumno.getEdad());
        alumno.obtenerNotas().forEach((materia, nota) -> System.out.println(materia + ": " + nota));
        System.out.print("Promedio general: " );
        calcularPromedioAlumno(nombre);
        System.out.println("---------------------------------");
    }

}
