package Locations;

import Monsters.Monster;
import pmain.Player;
import java.util.Random;

public abstract class BattleLoc extends Location{

    private Monster monster;
    private String award;
    private int maxMonsters;

    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonsters) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonsters = maxMonsters;
    }

    @Override
    public boolean onLocation(){
        int monsterCount = this.randomMonsterCount();
        System.out.println("----------------------------------------");
        System.out.println("Suan buradasiniz : " + this.getName());
        System.out.println("Dikkatli ol! Burada " + monsterCount +" tane " + this.monster.getName() + " yasiyor.");
        System.out.println("----------------------------------------");
        System.out.print("<S>avas veya <K>ac : ");
        String selection = input.nextLine().toUpperCase();
        if (selection.equals("S") && combat(monsterCount)){
                System.out.println("Tum dusmanlari yendiniz...");
                return true;
            }
            if (this.getPlayer().getHitPoint() <= 0){
                System.out.println("Oldunuz ...");
                return false;
            }
        else if (selection.equals("K")) {
            return true;
        }
        return true;
    }

    public int randomMonsterCount(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonsters())+1;
    }
    public void afterHit(){
        System.out.println("Yaratigin cani " + this.getMonster().getHitPoint() + " kaldi.");
        System.out.println("Caniniz " + this.getPlayer().getHitPoint() + " kaldi.");
    }

    public boolean combat(int monstersCount){
        for (int i = 1 ; i <= monstersCount ; i++){
            this.getMonster().setHitPoint(this.getMonster().getOriginalHitPoint());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHitPoint() > 0 && this.getMonster().getHitPoint() > 0){
                System.out.print("<V>ur veya <K>ac : ");
                String selection = input.nextLine().toUpperCase();
                if (selection.equals("V")){
                    System.out.println("-------------");
                    System.out.println("Siz vurdunuz");
                    System.out.println("-------------");
                    this.getMonster().setHitPoint(this.getMonster().getHitPoint()-this.getPlayer().getDamage());
                    afterHit();
                    if (this.getMonster().getHitPoint() > 0 ){
                        System.out.println("----------------");
                        System.out.println("Canavar size vurdu ");
                        System.out.println("----------------");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getDeflect();
                        if (monsterDamage<0){
                            monsterDamage =0;
                        }
                        this.getPlayer().setHitPoint(this.getPlayer().getHitPoint()-monsterDamage);
                        afterHit();
                    }
                } else if (selection.equals("K")) {
                    return false;
                }else {
                    return false;
                }
            }
            if (this.getMonster().getHitPoint() < this.getPlayer().getHitPoint()){
                System.out.println("Dusmani yendiniz ....");
                System.out.println(this.getMonster().getCoin() + " para kazandiniz.");
                this.getPlayer().setCoin(this.getPlayer().getCoin()+this.getMonster().getCoin());
                System.out.println("Guncel paraniz : " + this.getPlayer().getCoin());
            }
        }
        return false;
    }



    public void playerStats(){
        System.out.println("#########################");
        System.out.println("Degerleriniz :");
        System.out.println("Sagliginiz : " + this.getPlayer().getHitPoint());
        System.out.println("Hasariniz : " + this.getPlayer().getDamage());
        System.out.println("Engellemeniz : " + this.getPlayer().getInventory().getArmor().getDeflect());
        System.out.println("Paraniz : " + this.getPlayer().getCoin());
        System.out.println("#########################");
    }
    public void monsterStats(int i){
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(i + ". " + this.getMonster().getName() + " degerleri");
        System.out.println("Saglik : " + this.getMonster().getHitPoint());
        System.out.println("Hasar : " + this.getMonster().getDamage());
        System.out.println("Odul : " + this.getMonster().getCoin());
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }
    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonsters() {
        return maxMonsters;
    }

    public void setMaxMonsters(int maxMonsters) {
        this.maxMonsters = maxMonsters;
    }
}
