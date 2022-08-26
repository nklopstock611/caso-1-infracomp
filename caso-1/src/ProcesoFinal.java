import java.util.ArrayList;

public class ProcesoFinal extends Thread {

    private Buzon buzon;

    private ArrayList<String> mensajeFinal;

    public ProcesoFinal(Buzon pBuzon) {
        this.buzon = pBuzon;
        this.mensajeFinal = new ArrayList<String>();
    }

    public void run() {
        // while (this.buzon.getArrBuzon().size() == 0) {
        //     // wait(); type beat
        // }
        
        String s = this.buzon.retirar();
        System.out.println("ProcesoFinal retiro: " + s);
        this.mensajeFinal.add(s);

    }
    
}
