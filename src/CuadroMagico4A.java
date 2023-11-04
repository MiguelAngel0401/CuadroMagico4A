import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuadroMagico4A {

    public static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static int[][] leerMatriz(int filas, int columnas, char nombre) throws IOException {
        int[][] matriz = new int[filas][columnas];

        System.out.println("Lectura de datos de la matriz " + nombre);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Escribe el valor de " + nombre + "[" + i + "][" + j + "]: ");
                entrada = buffer.readLine();
                matriz[i][j] = Integer.parseInt(entrada);
            }
        }
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz, char nombre) {
        System.out.println("Contenido de la matriz " + nombre);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static boolean esCuadroMagico(int[][] matriz) {
        int n = matriz.length;
        int sumaPrimeraColumna = 0;

        // Calcular la suma de la primera columna para comparar con otras sumas
        for (int i = 0; i < n; i++) {
            sumaPrimeraColumna += matriz[i][0];
        }

        // Verificar si las sumas de filas son iguales a sumaPrimeraColumna
        for (int i = 0; i < n; i++) {
            int sumaFila = 0;

            for (int j = 0; j < n; j++) {
                sumaFila += matriz[i][j];
            }

            if (sumaFila != sumaPrimeraColumna) {
                return false; // No es un cuadro mágico
            }
        }

        // Verificar la diagonal principal
        int sumaDiagonalPrincipal = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
        }
        if (sumaDiagonalPrincipal != sumaPrimeraColumna) {
            return false; // No es un cuadro mágico
        }
        // Verificar la diagonal secundaria
        int sumaDiagonalSecundaria = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalSecundaria += matriz[i][n - 1 - i];
        }
        return sumaDiagonalSecundaria == sumaPrimeraColumna;
    }
    public static int calcularConstanteCuadroMagico(int[][] matriz) {
        int n = matriz.length;
        int sumaPrimeraColumna = 0;

        for (int i = 0; i < n; i++) {
            sumaPrimeraColumna += matriz[i][0];
        }
        return sumaPrimeraColumna;
    }
    public static void main(String[] args) throws IOException {
        int[][] matriz;
        int filas, columnas;

        System.out.println("Programa para verificar si una matriz es un cuadro mágico");
        System.out.println("Ingrese el número de filas de la matriz: ");
        entrada = buffer.readLine();
        filas = Integer.parseInt(entrada);

        System.out.println("Ingrese el número de columnas de la matriz: ");
        entrada = buffer.readLine();
        columnas = Integer.parseInt(entrada);

        matriz = leerMatriz(filas, columnas, 'a');
        imprimirMatriz(matriz, 'a');

        int constanteCuadroMagico = calcularConstanteCuadroMagico(matriz);
        System.out.println("La constante de la primera columna es: " + constanteCuadroMagico);

        if (esCuadroMagico(matriz)) {
            System.out.println("La matriz es un cuadro mágico.");
        } else {
            System.out.println("La matriz no es un cuadro mágico.");
        }
    }
}
