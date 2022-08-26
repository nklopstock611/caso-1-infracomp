
import java.util.ArrayList;

public class Buzon {

    private ArrayList<String> arrBuzon;
    private int n;

    public Buzon(int size) {
        this.n = size;
        this.arrBuzon = new ArrayList<String>();
    }
    
    public synchronized void almacenar(String s, int transf, int nivel) {
    	while (arrBuzon.size() == 0) {
    		try {
    			wait();
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    	s += "T" + Integer.toString(transf) + "" + Integer.toString(nivel);
    	arrBuzon.add(s);
    	notify();
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
        notify();
        
        return s;
    }
    
}
