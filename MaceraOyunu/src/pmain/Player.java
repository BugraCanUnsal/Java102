package pmain;

import Characters.Archer;
import Characters.GameChar;
import Characters.Knight;
import Characters.Samurai;

import java.util.Scanner;

public class Player {
    private int damage;
    private int hitPoint;

    private int hitPoint_placeholder;
    private int coin;
    private String name;
    private String charName;

    private Inventory inventory;
    private Scanner input = new Scanner(System.in);


    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public int getHitPoint_placeholder() {
        return hitPoint_placeholder;
    }

    public void setHitPoint_placeholder(int hitPoint_placeholder) {
        this.hitPoint_placeholder = hitPoint_placeholder;
    }

    public void selectChar(){

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler :");
        for ( GameChar chars: charList ) {
            System.out.println(chars.getId() + ". Karakter Adi : " + chars.getName()
                    +"\t Hasar : " + chars.getDamage()
                    +"\t Saglik : " + chars.getHitPoint()
                    + "\t Para : " + chars.getCoin());
        }

        while (true){
            System.out.print("Lutfen bir karakter seciniz : ");
            int selectChar = input.nextInt();

            switch (selectChar){
                case 1:
                    initPlayer(new Samurai());
                    break;
                case 2:
                    initPlayer(new Archer());
                    break;
                case 3:
                    initPlayer(new Knight());
                    break;
                default:
                    System.out.println("Hatalı secim yaptiniz...");
                    continue;
            }
            break;
        }

    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setCharName(gameChar.getName());
        this.setCoin(gameChar.getCoin());
        this.setHitPoint(gameChar.getHitPoint());
        this.setHitPoint_placeholder(gameChar.getHitPoint());
    }

    public void refreshHitPoint(){
        this.setHitPoint(this.getHitPoint_placeholder());
    }

    public void characterSheet(){
        System.out.println("#########################################");
        System.out.println("#----------Karakter Detaylari-----------#");
        System.out.println("#########################################");
        System.out.println("Isim : " + this.getName());
        System.out.println("Karakter : " + this.getCharName());
        System.out.println("Silah : " + this.getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getDamage());
        System.out.println("Zirh : " + this.getInventory().getArmor().getName());
        System.out.println("Engelleme : " + this.getInventory().getArmor().getDeflect());
        System.out.println("Saglik : " + this.getHitPoint());
        System.out.println("Para : " + this.getCoin());
        System.out.println("#########################################");
    }


    public int getDamage() {
        return damage + this.inventory.getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        if (hitPoint < 0 ){
            this.hitPoint = 0;
        }
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

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
