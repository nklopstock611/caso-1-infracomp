import java.util.Scanner;
import java.util.ArrayList;

public class App {

    /**
     * Este metodo crea un ArrayList de n mensajes que representan los 
     * subconjuntos
     * @param n Cantidad de subconjuntos o mensajes a crear
     * @return ArrayList de n mensajes 
     */
    public static ArrayList<String> crearSubconjuntos(int n) {
        ArrayList<String> subconjuntos = new ArrayList<String>();
        for (int i = 1; i < n + 1; i++) {
            subconjuntos.add("M" + i);
        }
        subconjuntos.add("FIN");
        subconjuntos.add("FIN");
        subconjuntos.add("FIN");

        return subconjuntos;
    }

    /**
     * Este método crea una matriz 3x2 de 6 buzones con capacidad n
     * @param n Capacidad de los buzones
     * @return Matriz de buzones 3x2
     */
    public static Buzon[][] crearBuzonesIntermedios(int n) {
        Buzon[][] buzonesIntermedios = new Buzon[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                buzonesIntermedios[i][j] = new Buzon(n);
            }
        }

        return buzonesIntermedios;
    }

    /**
     * Este metodo retorna una matriz 3x3 de procesos intermedios 
     * y le asigna a cada uno los buzones con los que debe trabajar
     * @param entrada Buzon de entrada 
     * @param salida Buzon de salida
     * @param intermedios Matriz de buzones intermedios
     * @return Matriz 3x3 de procesos intermedios con sus correspondientes 
     * buzones
     */
    public static ProcesoIntermedio[][] crearProcesoIntermedio(Buzon entrada, Buzon salida, Buzon[][] intermedios) {
        ProcesoIntermedio[][] procesosIntermedios = new ProcesoIntermedio[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    procesosIntermedios[i][j] = new ProcesoIntermedio(entrada, intermedios[i][j], j + 1, i + 1);
                }
                else if (j == 1) { // [j - 1] porque la matriz de buzones internos es 2 x 3, mientras que la de procesos es 3 x 3.
                    procesosIntermedios[i][j] = new ProcesoIntermedio(intermedios[i][j - 1], intermedios[i][j], j + 1, i + 1);
                }
                else { // [j - 1] porque la matriz de buzones internos es 2 x 3, mientras que la de procesos es 3 x 3.
                    procesosIntermedios[i][j] = new ProcesoIntermedio(intermedios[i][j - 1], salida, j + 1, i + 1);
                }
            }
        }

        return procesosIntermedios;
    }

    /**
     * Metodo main que pide al usuario el tamaño de los buzones de inicio y de fin, así
     * como el tamaño de los buzones intermedios y la cantidad de subconjuntos a procesar.
     * Aquí se llaman las funciones descritas anteriormente y se da inicio al ProcesoInicial,
     * ProcesoFinal y procesosIntermedios
     * @param args
     */
    public static void main(String[] args) {

        // inputs
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Ingrese el tamaño de los buzones de inicio y de fin: ");
            int sizeBuzonIniFini = scanner.nextInt();

            System.out.println("Ingrese el tamaño de los buzones intermedios: ");
            int sizeBuzonIntermedio = scanner.nextInt();

            System.out.println("Ingrese la cantidad de subconjuntos: ");
            int cantSubconjuntos = scanner.nextInt();

            // creacion subconjuntos
            ArrayList<String> subconjuntos = crearSubconjuntos(cantSubconjuntos);

            // creacion buzones
            Buzon buzonInicial = new Buzon(sizeBuzonIniFini);
            Buzon buzonFinal = new Buzon(sizeBuzonIniFini);
            Buzon[][] buzonesIntermedios = crearBuzonesIntermedios(sizeBuzonIntermedio);

            // creacion procesos
            ProcesoInicial procesoInicial = new ProcesoInicial(buzonInicial, subconjuntos);
            ProcesoFinal procesoFinal = new ProcesoFinal(buzonFinal);
            ProcesoIntermedio[][] procesosIntermedios = crearProcesoIntermedio(buzonInicial, buzonFinal, buzonesIntermedios);
   
            // ejecucion procesos
            procesoInicial.start();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    procesosIntermedios[i][j].start();
                }
            }
            procesoFinal.start();
        }
    }
    
}