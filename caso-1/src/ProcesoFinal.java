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
        // while (this.buzon.getArrBuzon().size() == 0) {
        //     // wait(); type beat
        // }
        for (int i = 0; i < this.n; i++) {
            String s = this.buzon.retirar();
            System.out.println("ProcesoFinal retiro: " + s);
            this.mensajeFinal.add(s);
        }

    }
    
}
