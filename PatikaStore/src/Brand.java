import java.text.BreakIterator;
import java.util.Comparator;
import java.util.TreeSet;

public class Brand {

    private int id;
    private String name;

    private static TreeSet<Brand> brands = new TreeSet<>(new Comparator<Brand>(){

        @Override
        public int compare(Brand o1, Brand o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });

    public Brand(){

    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void createBrands(){
        brands.add(new Brand(1,"Samsung"));
        brands.add(new Brand(2,"Lenovo"));
        brands.add(new Brand(3,"Apple"));
        brands.add(new Brand(4,"Huawei"));
        brands.add(new Brand(5,"Casper"));
        brands.add(new Brand(6,"Asus"));
        brands.add(new Brand(7,"Hp"));
        brands.add(new Brand(8,"Xiaomi"));
        brands.add(new Brand(9,"Monster"));
    }

    public static void getBrands(){
        for (Brand b: brands ) {
            System.out.println(b.getId() + ". " + b.getName());
        }
    }
    public static Brand getBrand(int id){
        for (Brand b : brands) {
            if (id == b.getId())return b;
        }
        return null;
    }
}
