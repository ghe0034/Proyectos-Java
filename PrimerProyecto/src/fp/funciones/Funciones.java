package fp.funciones;

import java.util.ArrayList;
import java.util.List;

public class Funciones {

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double numeroCombinatorio(int n, int k) {
        if (k < 0 || k > n) {
            throw new IllegalArgumentException("El valor de k debe estar entre 0 y n inclusive");
        }
        double numerador = factorial(n);
        double denominador = factorial(k) * factorial(n - k);
        return numerador / denominador;
    }

    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        }
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static List<Integer> diferenciasConAnterior(List<Integer> lista) {
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede ser nula o vacía");
        }
        List<Integer> diferencias = new ArrayList<>();
        for (int i = 1; i < lista.size(); i++) {
            diferencias.add(lista.get(i) - lista.get(i - 1));
        }
        return diferencias;
    }

    public static String cadenaMasLarga(List<String> lista) {
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede ser nula o vacía");
        }
        String cadenaMasLarga = lista.get(0);
        for (String cadena : lista) {
            if (cadena.length() > cadenaMasLarga.length()) {
                cadenaMasLarga = cadena;
            }
        }
        return cadenaMasLarga;
    }
    
    //DEFENSA
    
    //A
    public static long P2(int n, int k) {
        return P2(n, k, 0);
    }

    public static long P2(int n, int k, int i) {
        if (n < k || i >= k + 1) {
            throw new IllegalArgumentException("Los valores proporcionados no cumplen con las condiciones");
        }
        long resultado = 1;
        for (int i1 = 0; i1 <= (k - 2); i1++) {
            resultado *= (n - i);
        }
        return resultado;
    }
    
    //B
    public static double C2(int n, int k) {
        if (n <= k) {
            throw new IllegalArgumentException("Los valores proporcionados no cumplen con las condiciones");
        }
        return numeroCombinatorio(n, k + 1);
    }
    
    //C
    public static double S2(int n, int k) {
        if (n < k) {
            throw new IllegalArgumentException("Los valores proporcionados no cumplen con las condiciones");
        }

        // Calcular k! / (k+2)!
        double resultado = factorial(k) / factorial(k + 2);

        // Inicializar la suma
        double suma = 0;

        // Calcular la sumatoria
        for (int i = 0; i <= k; i++) {
            // Calcular el coeficiente binomial
            double coeficienteBinomial = numeroCombinatorio(k, i);
            
            // Calcular (-1)^i
            double signo = Math.pow(-1, i);
            
            // Calcular (k - i)^n, había un error aquí, se debe elevar a n, no a k
            double potencia = Math.pow((k - i), n);
            
            // Agregar a la suma
            suma += signo * coeficienteBinomial * potencia;
        }

        // Multiplicar el resultado por la suma y devolver
        return resultado * suma;
    }

    
    //E
    public static void main(String[] args) {
        // Ejemplo de uso
        int n = 5;
        int k = 3;
        int i = 2;

        System.out.println("P2(" + n + ", " + k + ", " + i + ") = " + P2(n, k, i));
        System.out.println("C2(" + n + ", " + k + ") = " + C2(n, k));
        System.out.println("S2(" + n + ", " + k + ") = " + S2(n, k));
    }
}