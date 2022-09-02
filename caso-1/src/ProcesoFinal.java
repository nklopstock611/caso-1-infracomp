import java.util.ArrayList;

public class ProcesoFinal extends Thread {

    private Buzon buzon;

    private ArrayList<String> mensajeFinal;

    private int n;

    public ProcesoFinal(Buzon pBuzon, int pN) {
        this.buzon = pBuzon;
        this.mensajeFinal = new ArrayList<String>();
        this.n = pN;
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            synchronized(buzon){
                String mensaje = this.buzon.retirarFinal();
                System.out.println("ProcesoFinal retiro: " + mensaje);
                this.mensajeFinal.add(mensaje);
            }
        }
    }
    
}
