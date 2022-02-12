import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class App {
    public static void main(String[] args) throws Exception {
        // NOTA: Variables
        Scanner sc = new Scanner(System.in);
        int op = -1;

        // NOTA: Bucle main
        while (op != 0) {
            // NOtA: Mensaje de error en opción inválida
            if (op > 6 || op < -1) {
                System.out.println("ERROR: Seleccione una opción válida\n");
            }

            // NOTA: Verificar opción
            if (op == 1) {
                edad();
            }else if (op == 2) {
                temperaturas();
            }else if (op == 3) {
                datos();
            }else if (op == 4) {
                calcu();
            }else if (op == 5) {
                random();
            }else if (op == 6) {
                mates();
            }

            // NOTA: Menú visual
            System.out.println("Trabajo prático 1\n");
            System.out.println("[1] Calcular edad");
            System.out.println("[2] Transformar temperaturas");
            System.out.println("[3] Concatenar datos");
            System.out.println("[4] Calculadora");
            System.out.println("[5] Generar números aleatorios entre el 25 y 75 (double)");
            System.out.println("[6] Generar tabla de multiplicar");
            System.out.println("\n[0] Terminar programa");

            // NOTA: Scan var
            op = sc.nextInt();

            // NOTA: Clear
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

    }

    public static void edad() {
        // NOTA: Variables
        Scanner sc = new Scanner(System.in);
        int year, month, day, vacio;

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // NOTA: Scans
        System.out.println("Ingrese su año de nacimiento:");
        year = sc.nextInt();

        System.out.println("Ingrese el mes de nacimiento (número del mes):");
        month = sc.nextInt();

        System.out.println("Ingrese el día de nacimiento:");
        day = sc.nextInt();

        // NOTA: Cálculos

        Period years = Period.between(LocalDate.of(year, month, day), LocalDate.now());
        System.out.printf("\nUsted tiene %s años, %s meses, y %s días", years.getYears(), years.getMonths(), years.getDays());

        System.out.println("\n\nIngrese un número para volver al menú principal");
        vacio = sc.nextInt();

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void temperaturas() {
        // NOTA: Variables
        Scanner sc = new Scanner(System.in);
        int op, vacio;
        String[] gradosOp = {
            "[1] Grados Celsius a Grados Fahrenheit",
            "[2] Grados Fahrenheit a Grados Celsius",
            "[3] Grados Celsius a Grados Kelvin",
            "[4] Grados Kelvin a Grados Celsius",
        };

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // NOTA: Mini menú
        System.out.println("Escoja una opción:\n");
        for (int i=0;i < 4; i++) {
            System.out.printf("%s\n", gradosOp[i]);
        }

        op = sc.nextInt();

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // NOTA: Cálcular
        String[] w = gradosOp[op - 1].split("\\s");
        double[] results = tempeCore(w[2], w[5], op);

        // NOTA: Resultado
        System.out.printf("%s %s son %s %s \n", results[0], w[2], results[1], w[5]);

        System.out.println("\n\nIngrese un número para volver al menú principal");
        vacio = sc.nextInt();

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static double[] tempeCore(String grado1, String grado2, int option) {
        // NOTA: Variables
        Scanner sc = new Scanner(System.in);
        double temp1=0, temp2=0;

        System.out.printf("%s a convertir:\n", grado1);
        temp1 = sc.nextFloat();

        // NOTA: Fórmulas
        if (option == 1) {
            temp2 = (temp1 * 9/5) + 32;
        } else if (option == 2) {
            temp2 = (temp1 - 32) * 5/9;
        } else if (option == 3) {
            temp2 = temp1 + 273.15;
        } else if (option == 4) {
            temp2 = temp1 - 273.15;
        }

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();


        double[] temp = {temp1,temp2};
        return temp;
    }

    public static void datos() {
        // NOTA: Variables
        Scanner sc = new Scanner(System.in);
        int vacio;
        String[] datos = {"","","","",""}, list = {"nombre", "apellido", "dirección", "correo", "teléfono"};

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i=0; i < 5; i++) {
            System.out.printf("Ingrese su %s:\n", list[i]);
            datos[i] = sc.next();
        }

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.printf("Su nombre completo es %s %s, vive en %s, su correo es %s y su número telefónico es %s\n", datos[0],datos[1],datos[2],datos[3],datos[4]);

        System.out.println("\n\nIngrese un número para volver al menú principal");
        vacio = sc.nextInt();

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void calcu() {
        // NOTA: Variables
        Scanner sc = new Scanner(System.in);
        int op = 0, vacio;
        double num1, num2;

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Escoja una opción:\n");

        System.out.println("[1] Suma");
        System.out.println("[2] Resta");
        System.out.println("[3] Multiplicación");
        System.out.println("[4] División");

        op = sc.nextInt();

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Escriba un número");
        num1 = sc.nextDouble();

        System.out.println("Escriba otro número");
        num2 = sc.nextDouble();

        System.out.printf("\nSu resultado es: %s", calcuCore(num1, num2, op));

        System.out.println("\n\nIngrese un número para volver al menú principal");
        vacio = sc.nextInt();

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static double calcuCore(double num1, double num2, int op) {
        double result = 0;

        if (op == 1) {
            result = num1 + num2;
        } else if (op == 2) {
            result = num1 - num2;
        } else if (op == 3) {
            result = num1 * num2;
        } else if (op == 4) {
            result = num1 / num2;
        }

        return result;
    }

    public static void random() {
        // NOTA: Variables
        Scanner sc = new Scanner(System.in);
        double min = 25, max = 75, value = 0, vacio;

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();

		value = (Math.random()*(max-min)) + min;
		System.out.printf("El número generado es: %s", value);

        System.out.println("\n\nIngrese un número para volver al menú principal");
        vacio = sc.nextInt();

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mates() {
        // NOTA: Variables
        Scanner sc = new Scanner(System.in);
        int num, vacio;

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Ingrese un número");
        num = sc.nextInt();

        int i = 1;
        while (i <= 10) {
            System.out.printf("%s x %s = %s\n", i, num, i * num);
            i++;
        }

        System.out.println("\n\nIngrese un número para volver al menú principal");
        vacio = sc.nextInt();

        // NOTA: Clear
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
