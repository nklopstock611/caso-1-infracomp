
import java.util.ArrayList;

public class Buzon {

    private ArrayList<String> arrBuzon;
    private int n;
    private int cantFin = 0;

    public Buzon(int pN) {
        this.n = pN;
        this.arrBuzon = new ArrayList<String>();
    }

    public ArrayList<String> getArrBuzon() {
        return arrBuzon;
    }
    
    public synchronized void almacenar(String s, int transf, int nivel) {
        while (this.arrBuzon.size() == this.n) {
    		try {
    			wait();
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
        }
        arrBuzon.add(s);
        notifyAll();
    }

    public synchronized void almacenarInicial(String s) {
        while (this.arrBuzon.size() == this.n) {
    		Thread.yield();
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

    public synchronized String retirarFinal() {
        while (this.arrBuzon.size() == 0 && cantFin < 3) {
    		Thread.yield();
        }
        String s = arrBuzon.remove(0);
        if (s == "FIN"){
            this.cantFin++;
        }
        notifyAll();
        
        return s;
    }
    
}
