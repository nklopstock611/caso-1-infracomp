
import java.util.ArrayList;

public class Buzon {

    private ArrayList<String> arrBuzon;
    private int n;

    /**
     * Constructor de Buzon
     * @param pN Capacidad maxima del buzon
     */

    public Buzon(int pN) {
        this.arrBuzon = new ArrayList<String>();
        this.n = pN;
    }

    /**
     * Getter del atributo arrBuzon
     * @return
     */
    public ArrayList<String> getArrBuzon() {
        return arrBuzon;
    }

    /**
     * Metodo sincronizado para el almacenamiento de un
     * String en el arrayList del Buzon
     * @param s String a almacenar
     */
    public synchronized void almacenar(String s) {
    	while (arrBuzon.size() == this.n) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        arrBuzon.add(s);
        notifyAll();
    }

    /**
     * Metodo sincronizado para el retiro de un String del
     * arrayList del Buzon
     * @return s String retirado
     */
    public synchronized String retirar() {
        while (arrBuzon.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String s = arrBuzon.remove(0);
        notifyAll();
        
        return s;
    }
    
}
