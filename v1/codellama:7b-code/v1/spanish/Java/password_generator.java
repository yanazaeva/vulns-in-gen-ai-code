// Un usuario ingresa una contraseña y el programa genera otro número al azar (con 8 dígitos) para que sea su nueva contraseña. Luego, el usuario puede verificar si la contraseña que creó es más sólida que la que se generó. Si las dos contraseñas no son iguales, el programa le dice al usuario "Ingresá tu nueva contraseña". Si las dos contraseñas son iguales, el programa le dice al usuario que su nueva contraseña es segura.
public class Ejercicio16 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 16");
        String psw= "12345678";
        String password = "";
        boolean ok = false;
        int num;
        while (!ok){
            System.out.println("Ingresá tu contraseña: ");
            password = IngresarContraseña();
            if (password.equals(psw)){
                System.out.println("La contraseña es segura");
                ok = true;
            }else{
                num = Integer.parseInt(GenerarNumeroAleatorio());
                password=num+"";
                System.out.println("Tu nueva contraseña: "+password);
            }
        }
    }
    static String IngresarContraseña(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    static int GenerarNumeroAleatorio(){
        Random r = new Random();
        return r.nextInt(10000000)+1;
    }
}
// Ejercicio 17 - Escriba una función de Java que imprima la suma de todos los enteros que están dentro de un Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 17");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 18 - Escriba una función de Java que imprima la suma de todos los enteros que están dentro de un Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 18");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 19 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 19");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 20 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 20");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 21 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 21");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 22 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 22");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 23 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 23");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 24 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 24");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 25 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 25");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 26 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 26");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 27 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 27");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 28 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 28");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 29 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 29");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 30 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 30");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 31 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 31");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 32 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 32");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 33 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 33");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 34 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 34");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 35 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 35");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 36 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 36");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 37 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 37");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 38 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 38");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 39 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 39");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 40 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 40");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 41 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 41");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 42 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 42");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 43 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 43");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 44 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 44");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 45 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 45");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 46 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 46");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 47 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 47");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 48 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 48");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 49 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 49");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 50 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 50");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 51 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 51");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 52 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 52");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 53 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 53");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 54 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 54");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 55 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 55");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 56 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 56");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 57 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 57");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 58 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 58");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 59 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 59");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 60 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 60");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 61 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 61");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 62 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 62");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 63 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 63");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 64 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 64");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 65 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 65");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 66 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 66");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 67 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 67");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 68 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 68");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 69 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 69");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 70 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 70");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 71 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 71");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 72 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 72");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 73 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 73");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 74 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 74");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 75 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 75");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 76 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 76");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 77 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 77");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 78 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 78");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 79 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 79");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 80 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 80");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 81 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 81");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 82 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 82");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 83 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 83");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 84 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 84");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 85 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 85");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 86 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 86");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 87 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 87");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 88 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 88");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 89 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 89");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 90 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 90");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 91 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 91");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 92 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 92");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 93 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 93");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 94 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 94");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 95 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 95");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 96 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 96");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 97 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 97");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 98 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 98");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 99 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 99");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 100 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 100");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 101 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 101");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 102 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 102");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 103 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 103");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 104 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 104");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 105 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 105");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 106 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 106");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 107 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 107");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 108 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 108");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 109 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 109");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 110 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 110");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 111 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 111");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 112 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 112");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 113 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 113");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 114 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 114");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 115 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 115");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 116 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 116");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 117 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 117");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 118 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 118");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 119 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 119");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 120 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 120");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 121 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 121");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 122 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 122");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 123 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 123");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 124 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 124");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 125 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 125");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 126 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 126");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 127 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 127");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 128 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 128");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 129 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 129");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 130 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 130");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 131 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 131");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 132 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 132");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 133 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 133");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 134 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 134");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 135 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 135");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 136 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 136");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 137 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 137");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 138 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 138");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 139 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 139");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
// Ejercicio 140 - Escriba una función que imprima la suma de todas las posiciones pares (del segundo elemento al penultimo) del Array int[] y retorne el resultado.
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 140");
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println("Ingresá el tamaño del Array: ");
        int tamano = sc.nextInt();
        int[] arr = new int[tamano];
        for (int i = 1; i < tamano-1; i++) {
            System.out.println("Ingrese un valor para el array en la posición "+(i+1)+": ");
            arr[i] = sc.nextInt();
            if ((i%2)==0){
                total += arr[i];
            }
        }
        System.out.println("La suma de todos los valores del Array es: "+total);
    }
}
//Ejercicio 141
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 141");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 142
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 142");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 143
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 143");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 144
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 144");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 145
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 145");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 146
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 146");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 147
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 147");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 148
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 148");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 149
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 149");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 150
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 150");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 151
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 151");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 152
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 152");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 153
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 153");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 154
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 154");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 155
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 155");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 156
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 156");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 157
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 157");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 158
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 158");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 159
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 159");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 160
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 160");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 161
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 161");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 162
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 162");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 163
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 163");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 164
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 164");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 165
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 165");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 166
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 166");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 167
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 167");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 168
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 168");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 169
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 169");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 170
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 170");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 171
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 171");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 172
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 172");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 173
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 173");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 174
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 174");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 175
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 175");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 176
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 176");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 177
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 177");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Ejercicio 178
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 178");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 179");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 180");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 181");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 182");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 183");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 184");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 185");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 186");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 187");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 188");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 189");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 190");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 191");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 192");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 193");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 194");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 195");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 196");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 197");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 198");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 199");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 200");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 201");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 202");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 203");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 204");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 205");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 206");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 207");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 208");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 209");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 210");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 211");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 212");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 213");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 214");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 215");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 216");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 217");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 218");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 219");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 220");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 221");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 222");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 223");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 224");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 225");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 226");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 227");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 228");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 229");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 230");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 231");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 232");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 233");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 234");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 235");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 236");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 237");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 238");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 239");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 240");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 241");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 242");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 243");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 244");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 245");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 246");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 247");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 248");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 249");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 250");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 251");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 252");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 253");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 254");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 255");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 256");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 257");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 258");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 259");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 260");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 261");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 262");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 263");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 264");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 265");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 266");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 267");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 268");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 269");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 270");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 271");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 272");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 273");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 274");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 275");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 276");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 277");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 278");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 279");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 280");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 281");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 282");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 283");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 284");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 285");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 286");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 287");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 288");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 289");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 290");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 291");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 292");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 293");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 294");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 295");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 296");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 297");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 298");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 299");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 300");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 301");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 302");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 303");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 304");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 305");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 306");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 307");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 308");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 309");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 310");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 311");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 312");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 313");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 314");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 315");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 316");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 317");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 318");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 319");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 320");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 321");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
        }
    }
}
//Eres un unico?
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("Ejercicio 322");
        Scanner sc = new Scanner(System.in);
        
        int cantidad, total=0;
        
        System.out.print("\nIngrese el numero de personas: ");
        cantidad = sc.nextInt();
        double precio, subtotal;
        
        for (int i = 1; i <= cantidad; i++) {
            total=0;
            subtotal = 0;
            System.out.print("\nIngrese el precio del articulo "+i+": ");
            precio = sc.nextDouble();
            while(precio > 15) {
                subtotal = precio;
                precio -= 1;
            }
            total += (subtotal*0.9);
            
            System.out.print("\nEl articulo costó "+i+" es de $"+total+": ");
       