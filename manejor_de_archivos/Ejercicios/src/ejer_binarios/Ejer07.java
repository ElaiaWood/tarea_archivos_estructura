package ejer_binarios;

import java.io.*;
import java.util.Scanner;
//Se creo un paquete para definir atributos privados en la clase datos que serviran como el uso de objetos
//Utilizamos los metodos get and set para poder hacer la insercion de informacion y la obtencion de lla informacion


public class Ejer07 {
    public static void main(String[] args) {

        //Creacion del objeto para utilizar los datos
        datos persona = new datos();
        Scanner s = new Scanner(System.in);
        //Ciclo for que captura las 3 referencias con los datos solicitados
        for (int i = 0; i < 3; i++) {

            System.out.println("Nombre: ");
            String name = s.next();
            //Se hace el llamado del metodo set de nombre para ingresar al archivo
            persona.setNombre(name);

            System.out.println("Matricula: ");
            String matricula = s.next();
            //Se hace el llamado del metodo set de matricula para ingresar al archivo
            persona.setMatricula(matricula);
            System.out.println("Edad: ");
            int edad = s.nextInt();
            //Se hace el llamado del metodo set de edad para ingresar al archnivo
            persona.setEdad(edad);

            //Creamos nuestro nuevo archibo binario
            File archivo = new File("persona.dat");
            try {
                //Utilizamos los conectores para el inicio y entrada de datos
                FileOutputStream fos = new FileOutputStream(archivo, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                //Escribimos los datos de persona en el archivo
                oos.writeObject(persona);
                //Cerramos las conexiones con el archivo
                oos.close();
                fos.close();
            } catch (Exception e) {
                System.err.println("Error...");
                e.printStackTrace();
            }

        }

        //Utilizamos el llamado dela rchivo
        File archivo = new File("persona.dat");
        try {
            //Llaves de acceso para el llamado de la informacion
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois;
            //Bucle que nos permite revisar el contenido hasta llegar al final
            while (fis.available() > 0) {
                //Creacion de las llaves para su llamado
                ois = new ObjectInputStream(fis);
                datos llamar = (datos) ois.readObject();
                //Mandamos a imprimir el contenido de las referencias
                System.err.println("\nNombre: " + llamar.getNombre());
                System.err.println("Matricula: " + llamar.getMatricula());
                System.err.println("Edad: " + llamar.getEdad());
            }
        } catch (Exception e) {
            System.err.println("Error");
            e.printStackTrace();
        }
    }
}


