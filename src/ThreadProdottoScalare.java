import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ThreadProdottoScalare implements Callable<Integer> {
    ArrayList<Integer> U;
    ArrayList<Integer> V;
    public ThreadProdottoScalare(ArrayList<Integer> U, ArrayList<Integer> V) {
        this.U = U;
        this.V = V;
    }

    @Override
    public Integer call() throws Exception {
        int ris = 0;
        for (int i = 0; i < this.U.size(); i++) {
            ris += this.V.get(i) * this.U.get(i);
        }
        return ris;
    }
}