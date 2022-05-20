import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Ejer02 {
    public static void main(String[] args) {

        //Creamos una llave con el fichero
        File f = new File("frases.txt");
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
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
            //Cerramos la conexion al archivo
            entrada.close();
        }
    }
}