package fp.TestFecha;

import fp.fecha.Fecha;
import java.time.LocalDate;

public class TestFecha {
    public static void main(String[] args) {
        // Prueba de métodos estáticos
        System.out.println("¿El año 2024 es bisiesto? " + Fecha.esAñoBisiesto(2024)); // Debería imprimir true
        System.out.println("¿El año 2023 es bisiesto? " + Fecha.esAñoBisiesto(2023)); // Debería imprimir false

        // Prueba de métodos de factoría
        Fecha fecha1 = Fecha.of(2023, 9, 20);
        System.out.println("Fecha creada con el método of(): " + fecha1);

        Fecha fecha2 = Fecha.parse("2023-09-20");
        System.out.println("Fecha creada con el método parse(): " + fecha2);

        // Prueba de métodos de instancia
        System.out.println("Nombre del mes: " + fecha1.nombreMes()); // Debería imprimir "Septiembre"
        System.out.println("Día de la semana: " + fecha1.diaSemana()); // Debería imprimir el día de la semana
        System.out.println("Sumar 10 días: " + fecha1.sumarDias(10)); // Debería imprimir la fecha aumentada en 10 días
        System.out.println("Restar 5 días: " + fecha1.restarDias(5)); // Debería imprimir la fecha disminuida en 5 días
        
        //DEFENSA
        // Prueba de método para calcular diferencia en días
        Fecha fecha3 = Fecha.of(2023, 9, 25);
        System.out.println("Diferencia en días entre " + fecha1 + " y " + fecha3 + ": " + fecha1.diferenciaEnDias(fecha3)); // Debería imprimir 5
        
        // Prueba de método restarDiasFechaDada
        int[] resultado = fecha1.restarDiasFechaDada(fecha1, 10);
        System.out.println("Fecha 1 después de restar 10 días: " + resultado[0] + "/" + resultado[1] + "/" + resultado[2]);
        
        // Prueba restar 0 dias
        int[] resultado3 = fecha1.restarDiasFechaDada(fecha1, 0);
        System.out.println("Fecha 1 después de restar 0 días: " + resultado3[0] + "/" + resultado3[1] + "/" + resultado3[2]);
        
        // Prueba restar mas de 999 dias
        int[] resultado1 = fecha1.restarDiasFechaDada(fecha1, 1000);
        System.out.println("Fecha 1 después de restar 10 días: " + resultado1[0] + "/" + resultado1[1] + "/" + resultado1[2]);
    }
}