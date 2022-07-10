package Characters;

public abstract class GameChar {

    private int id;
    private String name;
    private int damage;
    private int hitPoint;
    private int coin;

    public GameChar(int id, String name, int damage, int hitPoint, int coin) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.hitPoint = hitPoint;
        this.coin = coin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
