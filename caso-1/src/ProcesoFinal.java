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
        int cantFin = 0;
        while (buzon.getArrBuzon().isEmpty()) {
    		Thread.yield();
        }
        while (cantFin < 1){
            synchronized(buzon){
                String mensaje = buzon.retirar();
                if (mensaje.equals("FIN")){
                    cantFin++;
                }
                System.out.println("ProcesoFinal retiro: " + mensaje);
                this.mensajeFinal.add(mensaje);
            }
        }
    }
    
}
