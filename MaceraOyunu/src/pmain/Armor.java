package pmain;
public class Armor {
    private String name;
    private int id;
    private int deflect;
    private int price;

    public Armor(String name, int id, int deflect, int price) {
        this.name = name;
        this.id = id;
        this.deflect = deflect;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armors = new Armor[3];
        armors[0] = new Armor("Hafif",1,1,20);
        armors[1] = new Armor("Orta",2,3,25);
        armors[2] = new Armor("Agir",3,5,40);
        return armors;
    }

    public static Armor getArmorObjByID(int id){
        for (Armor a : Armor.armors()) {
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeflect() {
        return deflect;
    }

    public void setDeflect(int deflect) {
        this.deflect = deflect;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
