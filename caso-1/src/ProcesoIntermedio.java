
public class ProcesoIntermedio extends Thread {

    private Buzon buzonEntrada;
    private Buzon buzonSalida;
    private String mensaje = "";
    private int filaNivel;
    private int colTransformacion;

    /**
     * Constructor de ProcesoIntermedio
     * @param pBuzonEntrada Buzón del cual va a retirar mensajes para su transformación
     * @param pBuzonSalida Buzón en donde almacenará los mensajes que transforme
     * @param pColTransformacion Columna de la matriz de procesos a la que pertenece
     * @param pFilaNivel Fila de la matriz de procesos a la que pertenece
     */

    public ProcesoIntermedio(Buzon pBuzonEntrada, Buzon pBuzonSalida, int pColTransformacion, int pFilaNivel) {
        this.buzonEntrada = pBuzonEntrada;
        this.buzonSalida = pBuzonSalida;
        this.colTransformacion = pColTransformacion;
        this.filaNivel = pFilaNivel;
    }
    
    /**
     * Setter de mensaje
     * @param s String que será asignada al atributo mensaje de la clase
     */

    public void setMensaje(String s) {
    	this.mensaje = s;
    }
    
    /**
     * Metodo que transforma el mensaje presente en el atributo mensaje de acuerdo a la 
     * fila y columna del proceso en la matriz de procesos intermedios
     */
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
    
    /**
     * Método run que ejecuta la espera pasiva para el retiro de mensajes del buzon de 
     * entrada, transforma el mensaje y ejecuta la espera pasiva para el almacenamiento
     * de mensajes en el buzon de entrada
     */

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

