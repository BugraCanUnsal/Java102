import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arraylist = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            arraylist.add(i);
        }

        ArrayList<Integer> arr1 = new ArrayList<>(arraylist.subList(0, 2500));
        ArrayList<Integer> arr2 = new ArrayList<>(arraylist.subList(2500, 5000));
        ArrayList<Integer> arr3 = new ArrayList<>(arraylist.subList(5000, 7500));
        ArrayList<Integer> arr4 = new ArrayList<>(arraylist.subList(7500, 10000));

        EvenOrOdd eod1 = new EvenOrOdd(arr1);
        EvenOrOdd eod2 = new EvenOrOdd(arr2);
        EvenOrOdd eod3 = new EvenOrOdd(arr3);
        EvenOrOdd eod4 = new EvenOrOdd(arr4);


        Thread t1 = new Thread(eod1);
        Thread t2 = new Thread(eod2);
        Thread t3 = new Thread(eod3);
        Thread t4 = new Thread(eod4);

        List<Thread> threads = new ArrayList<>();

        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        threads.add(t4);

        for (Thread t : threads ) {
            t.start();
        }for (Thread t : threads ) {
            t.join();
        }

        EvenOrOdd eodd = new EvenOrOdd();

        ArrayList<Integer> even = new ArrayList<>(eodd.getEvenList());
        ArrayList<Integer> odd = new ArrayList<>(eodd.getOddList());

        Collections.sort(even);
        Collections.sort(odd);

        System.out.println(even);
        System.out.println(odd);
    }
}

