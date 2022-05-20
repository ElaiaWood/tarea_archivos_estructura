import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejer01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrintWriter salida = null;
        try {
            //Creando el archivo
            salida = new PrintWriter("frases.txt");
            String cadena;
            //Introduciento el texto
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
            cadena = sc.nextLine();
            //Estructrura que nos  permite ingresar el texto hasta escribir fin
            while (!cadena.equalsIgnoreCase("FIN")) {
                //Nos permite escribir toda una cadena de texto que querramos agregar
                salida.println(cadena);
                //Escribimos la cadena
                cadena = sc.nextLine();
            }
            // El método flush() provoca que se escriban en el archivo los ejer_binarios.datos que puedan haber en el buffer de salida.
            salida.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {         // La cláusula finally crea se ejecutará después de que se haya completado el bloque try / catch.
            //  close() nos permite cerrar la conexion al archivo
            salida.close();
        }
    }
}