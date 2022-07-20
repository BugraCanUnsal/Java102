import java.util.ArrayList;

public class EvenOrOdd implements Runnable{
    private static ArrayList<Integer> evenList = new ArrayList<>();
    private static ArrayList<Integer> oddList = new ArrayList<>();

    private ArrayList<Integer> arrayList;

    public EvenOrOdd(ArrayList<Integer> arrList) {
        this.arrayList = arrList;
    }

    public EvenOrOdd() {
    }

    @Override
    public void run() {
        calculating();
    }

    public synchronized void calculating(){
        for (Integer no : arrayList ) {
            if (no%2==0){
                evenList.add(no);
            }else {
                oddList.add(no);
            }
        }
    }

    public static ArrayList<Integer> getEvenList() {
        return evenList;
    }

    public void setEvenList(ArrayList<Integer> evenList) {
        EvenOrOdd.evenList = evenList;
    }

    public static ArrayList<Integer> getOddList() {
        return oddList;
    }

    public void setOddList(ArrayList<Integer> oddList) {
        EvenOrOdd.oddList = oddList;
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }


}
