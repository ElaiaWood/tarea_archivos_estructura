package mostrar;

import ejer_binarios.datos;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Ejer10 {
    public static void main(String[] args){

        //Creacion del objeto para utilizar los datos
        datos persona = new datos();
        Scanner s = new Scanner(System.in);
        //Ciclo for que captura las 5 nuevas referencias con los datos solicitados
        for (int i = 0; i < 5; i++) {

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
                FileOutputStream fos = new FileOutputStream(archivo,true);
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

        //Forma para imprimir en pantalla

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

        //FORMA PARA IMPRIMIR AL LLAMADO DE UNA APP DE ESCRITORIO CONECTADA A UNA IMPRESORA
        //AL NO TENER UNA IMPRESORA NO PUDE EJECUTARLO O PROBARLO
        //CODIGO OBTENIDO DE https://www.lawebdelprogramador.com/foros/Java/1275923-imprimir-archivos-en-java.html
        //o https://stackoverflow.com/questions/63625694/itext-how-to-get-pdf-binary-for-printing

        //Llamado de la aplicacion de escritorio
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        //Llamado del archivo
        java.io.File fichero = new java.io.File("persona.dat");
        //Manda a imprimir
        if (desktop.isSupported(Desktop.Action.PRINT)) {
            try {
                desktop.print(fichero);
            } catch (Exception e) {
                System.out.print("El sistema no permite imprimir usando la clase Desktop");
                e.printStackTrace();
            }
        } else {
            System.out.print("El sistema no permite imprimir usando la clase Desktop");
        }

    }
}