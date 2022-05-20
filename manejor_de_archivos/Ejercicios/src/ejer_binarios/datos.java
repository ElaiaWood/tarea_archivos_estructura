package ejer_binarios;


import java.io.Serializable;

public class datos implements Serializable {
    private String nombre;
    private int edad;
    private String matricula;

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMatricula() {

        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
