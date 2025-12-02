import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> U = new ArrayList<>();
        ArrayList<Integer> V = new ArrayList<>();

        U.add(1);
        U.add(2);
        U.add(3);
        V.add(4);
        V.add(5);
        V.add(6);

        ThreadProdottoScalare th0 = new ThreadProdottoScalare(U, V);
        ThreadModulo th1 = new ThreadModulo(U);
        ThreadModulo th2 = new ThreadModulo(V);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        try{
            Future<Integer> f0 = executor.submit(th0);
            Future<Double> f1 = executor.submit(th1);
            Future<Double> f2 = executor.submit(th2);

            int r0 = f0.get();
            double r1 = f1.get();
            double r2 = f2.get();

            double cos = r0 / (r1 * r2);

            System.out.println("Prodotto scalare: " + r0);
            System.out.println("Modulo U: " + r1);
            System.out.println("Modulo V: " + r2);
            System.out.println("CosAlpha: " + cos);
            System.out.printf("a= " + Math.toDegrees(Math.acos(cos)));
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }finally{
            executor.shutdown();
        }
    }
}