package Monsters;

public abstract class Monster {

    private String name;
    private int id;
    private int damage;
    private int hitPoint;

    private int originalHitPoint;
    private int coin;

    public Monster(String name, int id, int damage, int hitPoint,int coin) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.hitPoint = hitPoint;
        this.originalHitPoint = hitPoint;
        this.coin = coin;
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
        if (hitPoint < 0 ){
            hitPoint = 0;
        }
        this.hitPoint = hitPoint;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getOriginalHitPoint() {
        return originalHitPoint;
    }

    public void setOriginalHitPoint(int originalHitPoint) {
        this.originalHitPoint = originalHitPoint;
    }
}
