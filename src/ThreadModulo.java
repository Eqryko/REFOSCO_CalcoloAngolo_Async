import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ThreadModulo implements Callable<Double> {
    ArrayList<Integer> lista;
    public ThreadModulo(ArrayList<Integer> lista) {
        this.lista = lista;
    }

    @Override
    public Double call() throws Exception {
        double ris = 0;
        for(Integer i : lista) {
            ris += Math.pow(lista.get(i), 2);
        }
        return Math.sqrt(ris);
    }
}