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
        System.out.println(buzon.getProcesados());
        while ( buzon.getProcesados()< n) {
            while (buzon.getArrBuzon().size() == 0){
                Thread.yield();
            }
            synchronized(buzon){
                String mensaje = this.buzon.retirar();
                this.buzon.setProcesados();
                System.out.println(buzon.getProcesados());
                System.out.println("ProcesoFinal retiro: " + mensaje);
                this.mensajeFinal.add(mensaje);
            }
        }
    }
    
}
