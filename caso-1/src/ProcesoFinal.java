

public class ProcesoFinal extends Thread {

    private Buzon buzon;

    public ProcesoFinal(Buzon pBuzon, int pN) {
        this.buzon = pBuzon;
    }

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
