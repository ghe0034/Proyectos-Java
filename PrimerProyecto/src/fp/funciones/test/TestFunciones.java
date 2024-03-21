package fp.funciones.test;

import fp.funciones.Funciones;
import java.util.Arrays;
import java.util.List;

public class TestFunciones {

    public static void main(String[] args) {
        testEsPrimo();
        testNumeroCombinatorio();
        testNumeroPermutaciones();
        testDiferenciasConAnterior();
        testCadenaMasLarga();
    }

    public static void testEsPrimo() {
        System.out.println("Test de esPrimo:");
        System.out.println("Es 7 primo? " + Funciones.esPrimo(7)); // Debería imprimir true
        System.out.println("Es 10 primo? " + Funciones.esPrimo(10)); // Debería imprimir false
    }

    public static void testNumeroCombinatorio() {
        System.out.println("\nTest de numeroCombinatorio:");
        System.out.println("C(5, 2) = " + Funciones.numeroCombinatorio(5, 2)); // Debería imprimir 10
    }

    public static void testNumeroPermutaciones() {
        System.out.println("\nTest de numeroPermutaciones:");
        System.out.println("P(5, 2) = " + Funciones.numeroPermutaciones(5, 2)); // Debería imprimir 20
    }

    public static void testDiferenciasConAnterior() {
        System.out.println("\nTest de diferenciasConAnterior:");
        List<Integer> lista = Arrays.asList(1, 3, 6, 10, 15);
        System.out.println("Lista original: " + lista);
        System.out.println("Diferencias con el anterior: " + Funciones.diferenciasConAnterior(lista)); // Debería imprimir [2, 3, 4, 5]
    }

    public static void testCadenaMasLarga() {
        System.out.println("\nTest de cadenaMasLarga:");
        List<String> lista = Arrays.asList("hola", "hello", "bonjour", "ciao");
        System.out.println("Lista de cadenas: " + lista);
        System.out.println("Cadena más larga: " + Funciones.cadenaMasLarga(lista)); // Debería imprimir "bonjour"
    }
}
