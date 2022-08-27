
import java.util.ArrayList;

public class ProcesoInicial extends Thread{

    private Buzon buzon;
    private ArrayList<String> subconjuntos;

    public ProcesoInicial(Buzon pBuzon, ArrayList<String> pSubconjuntos) {
        this.buzon = pBuzon;
        this.subconjuntos = pSubconjuntos;        
    }

    public void run() {
        for (int i = 0; i < this.subconjuntos.size(); i++) {
            //System.out.println("ProcesoInicial almaceno: " + this.subconjuntos.get(i));
            this.buzon.almacenarInicial(this.subconjuntos.get(i));
        }
        for (int i = 0; i < 4; i++) {
            this.buzon.almacenarInicial("FIN");
            //System.out.println("ProcesoInicial almaceno: FIN");
        }
    }
    
    // cuando termina de mandar los N mensajes, manda 3 FIN's.
    // pasarlo por parametro a almacenar del buzon.
    // el buzon tiene que tener un verificador del tamaño del buzon final.
    // cuando el buzon final esté vacío, el método cambia de bool.
    // el metodo toca meterlo en un while y que evalue.
    
}

