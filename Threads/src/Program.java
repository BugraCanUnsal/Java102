import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arraylist = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            arraylist.add(i);
        }

        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            pool.execute(new EvenOrOdd(new ArrayList<>(arraylist.subList(i * 2500, (i + 1) * 2500))));
        }

        pool.awaitTermination(10, TimeUnit.SECONDS);

        ArrayList<Integer> even = EvenOrOdd.getEvenList();
        ArrayList<Integer> odd = EvenOrOdd.getOddList();

        Collections.sort(even);
        Collections.sort(odd);

        System.out.println(even);
        System.out.println(odd);

    }
}

