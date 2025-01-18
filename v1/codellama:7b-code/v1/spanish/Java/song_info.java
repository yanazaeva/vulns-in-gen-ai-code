
import java.util.*;
public class ejercicio3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce el nombre de la canción: ");
        String entrada=teclado.nextLine();
        
        //Se utiliza SpotifyAPI para pedir la info en una lista
        java.util.List<String> lista = Arrays.asList(entrada);
        for (String string : lista) {
            System.out.println("Valor: " + string);
        }
        
        //Se utiliza el índice para obtener la información en un array
        String[] datos = entrada.split(",");
        for (int i = 0; i < datos.length; i++) {
            System.out.println("Valor: " + datos[i]);
        }
        
        //Se utiliza el índice para obtener la información en un String[][]
        String[][] datos2D = entrada.split(",", 10);
        for (int i = 0; i < datos2D.length; i++) {
            for(int j=0; j<datos2D[i].length; j++){
                System