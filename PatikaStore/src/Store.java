import java.util.Scanner;

public class Store {
    protected Scanner inp = new Scanner(System.in);

    public void run(){
        System.out.println("PatikaStore urun yonetim paneli !");
        while (true){
            System.out.println("1 - Notebook islemleri\n" +
                    "2 - Cep telefonu islemleri\n" +
                    "3 - Marka listele\n" +
                    "0 - Cikis yap");
            System.out.print("Tercihiniz : ");
            switch (inp.nextInt()){
                case 1:
                    break;
                case 2:
                    MobilePhone mp = new MobilePhone();
                    mp.menu();
                    break;
                case 3:
                    Brand b = new Brand();
                    b.getBrands();
                    break;
                case 0:
                    System.out.println("Cikis yapiliyor...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Hatali tuslama yaptiniz...");
                    break;
            }
        }
    }
}
