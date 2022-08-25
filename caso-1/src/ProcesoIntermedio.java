
public class ProcesoIntermedio extends Thread {

    private Buzon buzonEntrada;
    private Buzon buzonSalida;
    private String mensaje = "";
    private int filaNivel;
    private int colTransformacion;

    public ProcesoIntermedio(Buzon pBuzonEntrada, Buzon pBuzonSalida, int pColTransformacion, int pFilaNivel) {
        this.buzonEntrada = pBuzonEntrada;
        this.buzonSalida = pBuzonSalida;
        this.colTransformacion = pColTransformacion;
        this.filaNivel = pFilaNivel;
    }
    
    public void setMensaje(String s) {
    	this.mensaje = s;
    }
    
    public void transformar(String s) {
    	s += "T" + Integer.toString(this.colTransformacion) + Integer.toString(filaNivel);
    }
    
    public void run() {
    	while (!this.mensaje.equals("FIN")) {
    		String s = this.buzonEntrada.retirar();
    		setMensaje(s);
    		transformar(this.mensaje);
    	}
    }
      
}

