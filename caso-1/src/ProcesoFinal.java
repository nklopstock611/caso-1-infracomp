import java.util.ArrayList;

public class ProcesoFinal extends Thread {

    private Buzon buzon;

    private ArrayList<String> mensajeFinal;

    public ProcesoFinal(Buzon pBuzon, int pN) {
        this.buzon = pBuzon;
        this.mensajeFinal = new ArrayList<String>();
    }

    public void run() {
        int cantFin = 0;
        while (buzon.getArrBuzon().isEmpty()) {
    		Thread.yield();
        }
        while (cantFin < 3){
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
