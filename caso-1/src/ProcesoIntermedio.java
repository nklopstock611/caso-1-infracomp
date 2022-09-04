
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
    
    public void transformar() {
        if (!this.mensaje.equals("FIN")){
    	this.mensaje += "T" + Integer.toString(this.colTransformacion) + Integer.toString(filaNivel);
        }
    }
    
    public void run() {

        Boolean fin = false;
        while (fin == false ){
            String s = this.buzonEntrada.retirar();
            if (s.equals("FIN")){
                fin = true;
            }
            setMensaje(s);
            System.out.println("El proceso intermedio " + colTransformacion + " retiró "+ mensaje);
            transformar();
            
            this.buzonSalida.almacenar(this.mensaje);
            System.out.println("El proceso intermedio " + colTransformacion + " almacenó "+ mensaje);
        }
    }
      
}

