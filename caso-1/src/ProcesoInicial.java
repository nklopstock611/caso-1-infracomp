
import java.util.ArrayList;

public class ProcesoInicial extends Thread{

    private Buzon buzon;
    private ArrayList<String> subconjuntos;

    public ProcesoInicial(Buzon pBuzon, ArrayList<String> pSubconjuntos) {
        this.buzon = pBuzon;
        this.subconjuntos = pSubconjuntos;        
    }

    public void run() {
        while (buzon.getArrBuzon().size() == subconjuntos.size()) {
    		Thread.yield();
    	}
        for (int i = 0; i < this.subconjuntos.size(); i++) {
            String mensaje = this.subconjuntos.get(i);
            synchronized(buzon){
                this.buzon.almacenar(mensaje);
                System.out.println("ProcesoInicial almacenó: " + mensaje+ "\n");
            }
            
        }
    }
}

