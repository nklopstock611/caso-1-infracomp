import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ProcesoIntermedio extends Thread {

    private Buzon buzonEntrada;
    private Buzon buzonSalida;
    private String mensaje = "";
    private int filaNivel;
    private int colTransformacion;
    private int n;
    protected boolean estado = true;

    public ProcesoIntermedio(Buzon pBuzonEntrada, Buzon pBuzonSalida, int pColTransformacion, int pFilaNivel, int pN) {
    	
    	this.buzonEntrada = pBuzonEntrada;
        this.buzonSalida = pBuzonSalida;
        this.colTransformacion = pColTransformacion;
        this.filaNivel = pFilaNivel;
        this.n = pN;
    }
    
    public void setMensaje(String s) {
    	this.mensaje = s;
    }
    
    public void transformar() {
    	this.mensaje += "T" + Integer.toString(this.colTransformacion) + Integer.toString(filaNivel);
    }
    
    public void run() {
 
    	while (estado)
		{
			setMensaje(buzonEntrada.retirarPasivo());
			System.out.println("ProcesoIntermedio retiró: " + mensaje);
			
			if (mensaje.equals("FIN"))
			{
				estado = false;
			}
			else
			{
				transformar();
				//System.out.println(mensaje);
			}
			
			buzonSalida.almacenarPasivo(mensaje);
			System.out.println("ProcesoIntermedio almacenó: " + mensaje);
		}
    	
    	
    	
        /**Boolean fin = false;
        int i = 0;
        while (fin == false){
            synchronized(buzonEntrada){
            String s = this.buzonEntrada.retirar();
            System.out.println("ProcesoIntermedio retirÃ³: " + mensaje);
            if (s.equals("FIN")){
                fin = true;
            }
            setMensaje(s);
            transformar();
            }
            synchronized(buzonSalida){
            this.buzonSalida.almacenar(this.mensaje, colTransformacion, filaNivel);
            System.out.println("ProcesoIntermedio almacenÃ³: " + mensaje);
            }
            i++;
        }*/
    }
      
}

