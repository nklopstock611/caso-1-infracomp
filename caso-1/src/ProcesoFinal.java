

public class ProcesoFinal extends Thread {

    private Buzon buzon;
    
    /**
     * Constructor de ProcesoFinal
     * @param pBuzon BuzonFinal del cual retira mensajes
     */
    public ProcesoFinal(Buzon pBuzon) {
        this.buzon = pBuzon;
    }

    /**
     * Método run que ejecuta la espera semiactiva para el retiro de 
     * cada uno de los mensajes del buzon de salida
     */
    public void run() {
        int cantFin = 0;
        while (buzon.getArrBuzon().isEmpty()) {
    		Thread.yield();
        }
        while (cantFin < 3){
            synchronized(buzon){
                String mensaje = buzon.retirar();
                if (mensaje.equals("FIN")){
                    cantFin++;
                }
                System.out.println("ProcesoFinal retiro: " + mensaje+ "\n");
            }
        }
    }
    
}
