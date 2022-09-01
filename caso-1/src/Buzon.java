
import java.util.ArrayList;

public class Buzon {

    private ArrayList<String> arrBuzon;
    private int n;
    private int procesados = 0;

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
        if (!s.equals("FIN")) {
            s += "T" + Integer.toString(transf) + Integer.toString(nivel);
            arrBuzon.add(s);
        }
        notifyAll();
    }

    public synchronized void almacenarInicial(String s) {
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

    public int getN() {
        return this.n;
    }

    public synchronized void setProcesados(){
        this.procesados++;
    }

    public int getProcesados(){
        return this.procesados;
    }
    
}
