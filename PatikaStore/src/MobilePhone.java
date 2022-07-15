import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone extends Product{

    private Scanner inp = new Scanner(System.in);
    private static int pId=1;
    private int battery;
    private String color;
    private int camResolution;
    private static ArrayList<MobilePhone> phones=new ArrayList<>();

    public MobilePhone(String name, double price, int discountRate, int amount, Brand brand, double screenSize, int ram, int memory, int battery, String color, int camResolution) {
        super(pId,name, price, discountRate, amount, brand, screenSize, ram, memory);
        pId++;
        this.battery = battery;
        this.color = color;
        this.camResolution = camResolution;
    }
    public MobilePhone(){

    }

    @Override
    public void menu() {
        System.out.println("-----------------------------------");
        System.out.println("--------Cep Telefonu Menusu--------");
        System.out.println("-----------------------------------");
        System.out.println("1 - Telefon ekle\n" +
                "2 - Telefon sil\n" +
                "3 - Telefon listesi\n" +
                "4 - Telefonlari id numarasina gore sirala\n" +
                "5 - Telefonlari markasina gore getir");
        System.out.print("Tercihiniz : ");
        int selection = inp.nextInt();
        if (selection == 1) addItem();
        if (selection == 2) deleteItem();
        if (selection == 3) getProducts();
        if (selection == 4) getProducts();
        if (selection == 5) filterByBrand();
    }

    @Override
    public void addItem() {
        System.out.print("Ürünün fiyatı : ");
        double price= inp.nextDouble();
        System.out.print("Ürünün adı : ");
        inp.nextLine();
        String name=inp.nextLine();
        System.out.print("Ürünün indirim oranı : ");
        int discountRate= inp.nextInt();
        System.out.print("Ürünün stoğu : ");
        int amount= inp.nextInt();
        System.out.print("Ürünün rami : ");
        int ram= inp.nextInt();
        System.out.print("Ürünün ekranı : ");
        double screenSize= inp.nextDouble();
        System.out.print("Ürünün hafızası :");
        int memory= inp.nextInt();
        System.out.print("Ürünün pili : ");
        int battery= inp.nextInt();
        inp.nextLine();
        System.out.print("Ürünün rengi : ");
        String color= inp.nextLine();
        System.out.print("Kamera çözünürlüğü : ");
        int camResolution= inp.nextInt();
        Brand.getBrands();
        System.out.print("Marka Seçiniz : ");
        Brand brand=Brand.getBrand(inp.nextInt());
        MobilePhone phone=new MobilePhone(name,price,discountRate,amount,brand,screenSize,ram,memory,battery,color,camResolution);
        phones.add(phone);
        System.out.println("Eklenen telefonun id'si :"+phone.getId());
    }

    @Override
    public void getProducts() {
        printAllPhones(null);
    }

    @Override
    public void deleteItem() {
        getProducts();
        System.out.print("Silmek istenilen urunun id numarasini tuslayiniz : ");
        int id = inp.nextInt();
        phones.remove(id - 1);
        System.out.println("Mevcut telefonlar : ");
        getProducts();
    }
    public void printAllPhones(ArrayList<MobilePhone> phoneList){
        if(phoneList==null) phoneList=this.phones;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   | Pil Kapasitesi  | Renk           | Kamera    |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone n:phoneList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getAmount(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory(),n.getBattery(),n.getColor(),n.getCamResolution());
        }
    }
    public void filterByBrand(){
        inp.nextLine();
        ArrayList<MobilePhone> filtered = new ArrayList<>();
        System.out.println("Marka giriniz :");
        String filter = inp.nextLine();
        for (MobilePhone mp : phones) {
            if (filter.equals(mp.getBrand().getName())){
                filtered.add(mp);
            }
        }
        printAllPhones(filtered);
    }

    public static int getpId() {
        return pId;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamResolution() {
        return camResolution;
    }

    public void setCamResolution(int camResolution) {
        this.camResolution = camResolution;
    }

}
