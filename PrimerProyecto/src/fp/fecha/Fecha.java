package fp.fecha;

public record Fecha(int año, int mes, int dia) {
    private static final String[] nombresMes = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    private static final String[] nombresDiaSemana = {
        "Sábado", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"
    };

    public String nombreMes() {
        return nombresMes[mes - 1];
    }

    public String diaSemana() {
        int zeller = congruenciaZeller(año, mes, dia);
        return nombresDiaSemana[zeller];
    }

    public Fecha sumarDias(int dias) {
        return Fecha.of(año, mes, dia + dias);
    }

    public Fecha restarDias(int dias) {
        return Fecha.of(año, mes, dia - dias);
    }

    public int diferenciaEnDias(Fecha otraFecha) {
        int diasEste = diaDelAño(año, mes, dia);
        int diasOtro = diaDelAño(otraFecha.año, otraFecha.mes, otraFecha.dia);
        return Math.abs(diasEste - diasOtro);
    }

    @Override
    public String toString() {
        return String.format("%s, %d de %s de %d", diaSemana(), dia, nombreMes(), año);
    }

    public static Fecha of(int año, int mes, int dia) {
        return new Fecha(año, mes, dia);
    }

    public static Fecha parse(String cadenaFecha) {
        String[] partes = cadenaFecha.split("-");
        int año = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);
        return Fecha.of(año, mes, dia);
    }

    public static boolean esAñoBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    public static int díasEnMes(int año, int mes) {
        switch (mes) {
            case 2:
                return esAñoBisiesto(año) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static int congruenciaZeller(int año, int mes, int dia) {
        if (mes < 3) {
            año--;
            mes += 12;
        }
        int k = año % 100;
        int j = año / 100;
        int h = (dia + ((13 * (mes + 1)) / 5) + k + (k / 4) + (j / 4) - (2 * j)) % 7;
        return (h + 5) % 7; // 0: Sábado, 1: Domingo, ..., 6: Viernes
    }

    private static int diaDelAño(int año, int mes, int dia) {
        int totalDias = dia;
        for (int m = 1; m < mes; m++) {
            totalDias += díasEnMes(año, m);
        }
        return totalDias;
    }
    
    
  //DEFENSA
    public static int[] restarDiasFechaDada(Fecha fecha, int numDias) {
        if (numDias >= 0 && numDias <= 999) {
            Fecha nuevaFecha = fecha.restarDias(numDias);
            return new int[]{nuevaFecha.dia(), nuevaFecha.mes(), nuevaFecha.año()};
        } else {
            throw new IllegalArgumentException("El número de días debe estar entre 0 y 999.");
        }
    }
}