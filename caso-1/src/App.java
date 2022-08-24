
import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static ArrayList<String> crearSubconjuntos(int n) {
        ArrayList<String> subconjuntos = new ArrayList<String>();
        for (int i = 1; i < n + 1; i++) {
            subconjuntos.add("M" + i);
        }

        return subconjuntos;
    }
    public static void main(String[] args) {

        // inputs

        Scanner scanner = new Scanner(System.in);
        
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
        Buzon[][] buzonesIntermedios = new Buzon[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buzonesIntermedios[i][j] = new Buzon(sizeBuzonIntermedio);
            }
        }

        // creacion procesos

    }
    
}
