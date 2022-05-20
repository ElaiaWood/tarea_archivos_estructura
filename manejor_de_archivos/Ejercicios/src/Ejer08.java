import ejer_binarios.datos;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
//Importamos la informacion recabada en el archido de datos que se encuentra empaquetado
public class Ejer08 {
    public static void main(String[] args){
        //Variable que nos permitara sumar las edades
        int suma =0;
        //Creamos, en caso de no existir, el rchivo
        File archivo = new File("persona.dat");
        try {
            //Creamos las conexiones
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois;
            //Realizamos un bucle que ejecute las lineas del archivo binario hasta topar con el final del archivo
            while(fis.available() > 0 ){
                ois = new ObjectInputStream(fis);
                //Realizamos la lectura de los datos
                datos persona = (datos) ois.readObject();
                //Llamamos a las edades escritas en el archivo y las sumamos
                suma += persona.getEdad();

            }
            //Se procede a imprimir la operacion de la suma de las edades entre tres, ya que son tres referencias que solicita el ejercicio
            System.out.println(suma/3);
        } catch (Exception e) {
            System.err.println("Error");
            e.printStackTrace();
        }
    }
}