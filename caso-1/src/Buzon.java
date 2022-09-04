
import java.util.ArrayList;

public class Buzon {

    private ArrayList<String> arrBuzon;
    private int n;

    public Buzon(int pN) {
        this.arrBuzon = new ArrayList<String>();
        this.n = pN;
    }

    public ArrayList<String> getArrBuzon() {
        return arrBuzon;
    }

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
