import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Ejer03 {
    public static void main(String[] args) {

        //Acceso al archivo
        File f = new File("frases.txt");
        String cadena;
        Scanner entrada = null;
        try {
            entrada = new Scanner( f );

            while (entrada.hasNext()) {
                //Se lee una linea del archivo en forma cascada
                cadena = entrada.nextLine();
                //Imprime la linea en la consola en mayusculas
                System.out.println(cadena.toUpperCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
            //Cierra la conexion con el archivo
            entrada.close();
        }
    }
}