
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
    
    public void almacenarPasivo(String i) {
		synchronized (arrBuzon)
		{
			while (arrBuzon.size() == this.n)
			{
				try 
				{
					arrBuzon.wait();
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		
			arrBuzon.add(i);
			
			arrBuzon.notifyAll();
		}
	}

    public synchronized void almacenarInicial(String s) {
        while (this.arrBuzon.size() == this.n) {
    		Thread.yield();
    	}
    	arrBuzon.add(s);
    	//System.out.println("MensajeInicial almacenado");
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

    public String retirarPasivo() 
	{
		String i;
		synchronized (arrBuzon)
		{
			while(arrBuzon.size() == 0)
			{
				try
				{
					arrBuzon.wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
			//System.out.println("Tamaño antes = " + arrBuzon.size());
		
			i = arrBuzon.remove (0);
			
			//System.out.println("Tamaño ahora = " + arrBuzon.size());
			
			arrBuzon.notifyAll();
		}
		
		return i;
	}
    
    public synchronized String retirarFinal() {
        while (this.arrBuzon.size() == 0) {
    		Thread.yield();
        }
        String s = arrBuzon.remove(0);
        notifyAll();
        
        return s;
    }
    
}
