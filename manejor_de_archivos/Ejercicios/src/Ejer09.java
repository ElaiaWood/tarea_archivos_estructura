import ejer_binarios.datos;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Locale;

public class Ejer09 {
    public static void main(String[] args){

        //Llamado del archivo
        File archivo = new File("persona.dat");
        try {
            //Llaves de accesos para el archivo
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois;
            //Realizamos un bucle que ejecute las lineas del archivo binario hasta topar con el final del archivo
            while(fis.available() > 0 ){
                ois = new ObjectInputStream(fis);
                //Lectura de los datos en el archivo
                datos persona = (datos) ois.readObject();
                //Mandamos a obtener e imprimir las matriculas en mayusculas
                System.out.println(persona.getMatricula().toUpperCase());
            }

        } catch (Exception e) {
            System.err.println("Error");
            e.printStackTrace();
        }
    }
}