
package ejercicio1;
import java.io.*;
public class EJERCICIO1 {
    public static void main(String[] args) throws IOException {
        //variables
        int contador = 0;
        String name;
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Escribe el nombre del directorio de destino: ");
        name = entrada.readLine();
        File fname = new File(name);
        if(!fname.exists()){
            fname.mkdirs();
        }
        
        BufferedReader archivo = new BufferedReader(new FileReader("C:\\Users\\brian\\Desktop\\Ejercicios.txt"));
        String linea;
        while((linea = archivo.readLine()) != null){
            if(!linea.isEmpty() && !linea.equals("\n")){
                System.out.println(contador+1 + ".-" + linea);
                File file = new File(name+"\\"+linea);
                renameFile(file, linea);
                contador++;
            }   
        }
        archivo.close();
        
    }//fin main
    
    public static boolean renameFile (File file, String name){
        try{
            if(!name.equals(file.getName())) {
                file.renameTo