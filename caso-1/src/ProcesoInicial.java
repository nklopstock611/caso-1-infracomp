import java.util.ArrayList;

public class ProcesoInicial extends Thread{

    private Buzon buzon;
    private ArrayList<String> subconjuntos;

    public ProcesoInicial(Buzon pBuzon, ArrayList<String> pSubconjuntos) {
        this.buzon = pBuzon;
        this.subconjuntos = pSubconjuntos;        
    }
    
}
