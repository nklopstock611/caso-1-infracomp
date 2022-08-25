public class ProcesoIntermedio extends Thread {

    private Buzon buzonEntrada;
    private Buzon buzonSalida;
    private String mensajeActual;
    private int numeroProceso;
    private int nivelTransformacion;

    public ProcesoIntermedio(Buzon pBuzonEntrada, Buzon pBuzonSalida, int pNivelTransformacion, int pNumeroProceso) {
        this.buzonEntrada = pBuzonEntrada;
        this.buzonSalida = pBuzonSalida;
        this.nivelTransformacion = pNivelTransformacion;
        this.numeroProceso = pNumeroProceso;
    }
    
}
