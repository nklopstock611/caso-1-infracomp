import java.util.ArrayList;

public class ProcesoInicial extends Thread{

    private Buzon buzon;
    private ArrayList<String> subconjuntos;

    /**
     * Constructor de ProcesoInicial
     * @param pBuzon Buzón de entrada
     * @param pSubconjuntos ArrayList con mensajes a enviar
     */
    public ProcesoInicial(Buzon pBuzon, ArrayList<String> pSubconjuntos) {
        this.buzon = pBuzon;
        this.subconjuntos = pSubconjuntos;        
    }

    /**
     * Método run que ejecuta la espera semiactiva para el almacenamiento de 
     * cada uno de los mensajes del ArrayList
     */
    public void run() {
        while (buzon.getArrBuzon().size() == subconjuntos.size()) {
    		Thread.yield();
    	}
        for (int i = 0; i < this.subconjuntos.size(); i++) {
            String mensaje = this.subconjuntos.get(i);
            synchronized(buzon){
                this.buzon.almacenar(mensaje);
                //System.out.println("ProcesoInicial almacenó: " + mensaje + "\n");
            }  
        }
    }
}