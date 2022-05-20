import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejer05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Inicia checando si existe un archivo con la ruta o el nombre otorgado. De existir, no crea uno nuevo
        try (FileWriter fw = new FileWriter("frases.txt", true);
             //Crea una conexion para imprimir
             PrintWriter salida = new PrintWriter(fw))
        {
            //Realizamos un ciclo flora para obtener las 3 referencias principales

                String cadena;
                System.out.println("Introduce 3 cadenas de texto. Para acabar introduce la cadena FIN:");
                //Obtenemos las cadenas ingresadas por el teclado
                cadena = sc.nextLine();
                //Entra en un ciclo que captura todas frases hasta terminar escribiendo fin
                while (!cadena.equalsIgnoreCase("FIN")) {
                    //Se copia el contenido ingresado en el archivo
                    salida.println(cadena);
                    cadena = sc.nextLine();
                }
                // El método flush() provoca que se escriban en el archivo los ejer_binarios.datos que puedan haber en el buffer de salida.
                salida.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
