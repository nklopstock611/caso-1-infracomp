
public class ProcesoIntermedio extends Thread {

    private Buzon buzonEntrada;
    private Buzon buzonSalida;
    private String mensaje = "";
    private int filaNivel;
    private int colTransformacion;
    private int n;

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
    
    public void transformar(String s) {
    	s += "T" + Integer.toString(this.colTransformacion) + Integer.toString(filaNivel);
    }
    
    public void run() {
    	// while (!this.mensaje.equals("FIN")) {
    	// 	String s = this.buzonEntrada.retirar();
        //     System.out.println("ProcesoIntermedio " + Integer.toString(colTransformacion) + 
        //                         Integer.toString(filaNivel) + " retiro: " + s);
    	// 	setMensaje(s);
        //     System.out.println("mensaje actual: " + this.mensaje);
    	// 	transformar(this.mensaje);
        //     System.out.println("ProcesoIntermedio " + Integer.toString(colTransformacion) + 
        //     Integer.toString(filaNivel) + " almaceno: " + this.mensaje);
        //     this.buzonSalida.almacenar(this.mensaje, colTransformacion, filaNivel);            
    	// }
        for (int i = 0; i < this.n; i++ ) {
            if (!this.mensaje.equals("FIN")) {
                String s = this.buzonEntrada.retirar();
                //System.out.println("ProcesoIntermedio " + Integer.toString(colTransformacion) + 
                //                    Integer.toString(filaNivel) + " retiro: " + s);
                setMensaje(s);
                //System.out.println("mensaje actual: " + this.mensaje);
                transformar(this.mensaje);
                //System.out.println("ProcesoIntermedio " + Integer.toString(colTransformacion) + 
                //                    Integer.toString(filaNivel) + " almaceno: " + this.mensaje);
                this.buzonSalida.almacenar(this.mensaje, colTransformacion, filaNivel);
            }
        }
    }
      
}

