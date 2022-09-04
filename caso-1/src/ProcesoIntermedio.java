
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
    
    public void transformar() {
        if (!this.mensaje.equals("FIN")){
        String mensajeOriginal = this.mensaje;
    	this.mensaje += "T" + Integer.toString(this.colTransformacion) + Integer.toString(filaNivel);
        double demora = ((Math.random() * (500 - 50)) + 50);
        try {
            sleep((long) demora);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El proceso "+ colTransformacion + filaNivel + " transformó el mensaje "+ mensajeOriginal+" en "+ (Math.round(demora * 100.0) / 100.0) + " ms");
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
            //System.out.println("El proceso intermedio " + colTransformacion + filaNivel + " retiró "+ mensaje);
            transformar();
            
            this.buzonSalida.almacenar(this.mensaje);
            System.out.println("El proceso intermedio " + colTransformacion + filaNivel + " almacenó "+ mensaje+"\n");
        }
    }
      
}

