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

    public static long numeroCombinatorio(int n, int k) {
        if (k < 0 || k > n) {
            throw new IllegalArgumentException("El valor de k debe estar entre 0 y n inclusive");
        }
        long numerador = factorial(n);
        long denominador = factorial(k) * factorial(n - k);
        return numerador / denominador;
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static long numeroPermutaciones(int n, int k) {
        if (k < 0 || k > n) {
            throw new IllegalArgumentException("El valor de k debe estar entre 0 y n inclusive");
        }
        return factorial(n) / factorial(n - k);
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
}
