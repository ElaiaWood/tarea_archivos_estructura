import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Ejer04 {
    public static void main(String[] args) {
        try {
            //Entablamos ruta con el archivo
            String ruta = ("frases.txt");

            //Obtenemos la ruta original del archivo
            Path origen = Paths.get(ruta);   // Ruta del archivo original
            //Creamos un archivo
            Path destino = Paths.get("copia.txt");

            //Se procede a crear una copia del contenido origen al nuevo destino
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error -> " + e.getMessage());
        }
        //Creamos una llave con el fichero
        File f = new File("copia.txt");
        String cadena;
        Scanner entrada = null;
            try {
            //Creamos un scanner para el fichero
            entrada = new Scanner( f );
            //un buble hasta no encontrar el final del archivo
            while (entrada.hasNext()) {
                //Se lee una linea del archivo en forma cascada
                cadena = entrada.nextLine();
                //Imprime la linea en la consola
                System.out.println(cadena);
            }
            //En caso de ocurrir un error lo comenta
        } catch (
        FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
            //Cerramos la conexion al archivo
            entrada.close();
        }
    }



}