import java.util.ArrayList;

public class ProcesoFinal extends Thread {

    private Buzon buzon;

    private ArrayList<String> mensajeFinal;

    private int n;

    public ProcesoFinal(Buzon pBuzon, int pN) {
        this.buzon = pBuzon;
        this.mensajeFinal = new ArrayList<String>();
        this.n = pN;
    }

    public void run() {
        int cantFin = 0;
        int mensajes = 0;
        
        //System.out.println(n);
        
        while (cantFin < 3){
            synchronized(buzon){
                String mensaje = this.buzon.retirarFinal();
                System.out.println("Mensajes en buzón " + buzon.getArrBuzon().size());
                if (mensaje.equals("FIN")){
                    cantFin++;
                    System.out.println("ProcesoFinal retiro: " + mensaje);
                    System.out.println(cantFin + " FIN");
                }
                else if(!mensaje.equals("FIN") && !mensaje.isBlank()) {
                	mensajes++;
                	System.out.println("ProcesoFinal retiro: " + mensaje);
                    this.mensajeFinal.add(mensaje);
                    //System.out.println("MensajeFinal: " + mensaje);
                    System.out.println(mensajeFinal.size() + " mensajes procesados");
                }
                
            }
        }
        System.out.println("terminó");
    }
    
}
