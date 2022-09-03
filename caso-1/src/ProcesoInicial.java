
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
            String mensaje = this.subconjuntos.get(i);
            synchronized(buzon){
                this.buzon.almacenarInicial(mensaje);
                System.out.println("ProcesoInicial almacenó: " + mensaje);
            }
            
        }
        System.out.println("El proceso inicial finalizó");
    }
}

