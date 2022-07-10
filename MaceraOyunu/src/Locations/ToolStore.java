package Locations;

import pmain.Armor;
import pmain.Player;
import pmain.Weapon;

public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Market");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--------------Markete Hosgeldiniz-------------");
        System.out.println("1- Silahlar");
        System.out.println("2- Zirhlar");
        System.out.println("3- Cikis");
        System.out.print("Seciminiz : ");
        int selection = input.nextInt();
        while (selection < 1 || selection > 3){
            System.out.print("Gecersiz deger. Tekrar giriniz : ");
            selection = input.nextInt();
        }
        switch (selection) {
            case 1 -> {
                printWeapons();
                selectWeapon();
            }
            case 2 -> {
                printArmors();
                selectArmor();
            }
            case 3 -> {
                System.out.println("Bir daha bekleriz...");
                break;
            }
        }
        return true;
    }

    public void printWeapons(){
        System.out.println("--------Silahlar-------");
        System.out.println();
        for (Weapon w: Weapon.weapons()) {
            System.out.println(w.getId() + ". " + w.getName() + " <Fiyat : " + w.getPrice() + "\t Hasar : " + w.getDamage());
        }
    }


    public void selectWeapon(){
        System.out.println("---------------------------------");
        System.out.print("Lutfen seciminizi yapiniz : ");
        int weaponId = input.nextInt();
        while (weaponId < 1 || weaponId > Weapon.weapons().length){
            System.out.print("Gecersiz bir secim yaptiniz. Tekrar deneyiniz : ");
            weaponId = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(weaponId);
        if (selectedWeapon != null){
            if (selectedWeapon.getPrice()> this.getPlayer().getCoin()){
                System.out.println("Yeterli paraniz bulunmuyor...");
            }else {
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println(selectedWeapon.getName() + " silahini satin aldiniz.");
                this.getPlayer().setCoin(this.getPlayer().getCoin() - selectedWeapon.getPrice());
                System.out.println("DAMAGE : " + this.getPlayer().getDamage());
                System.out.println("Kalan paraniz : " + this.getPlayer().getCoin());

            }
        }
    }
    public void printArmors(){
        System.out.println("--------Zirhlar--------");
        System.out.println();
        for (Armor a: Armor.armors()) {
            System.out.println(a.getId()+ ". " + a.getName() + " <Fiyat : " + a.getPrice() + "\t Engelleme : " + a.getDeflect());
        }
    }

    public void selectArmor(){
        System.out.println("---------------------------------");
        System.out.print("Lutfen seciminizi yapiniz : ");
        int armorId = input.nextInt();
        while (armorId < 1 || armorId > Armor.armors().length){
            System.out.print("Gecersiz bir secim yaptiniz. Tekrar deneyiniz : ");
            armorId = input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjByID(armorId);
        if (selectedArmor != null){
            if (selectedArmor.getPrice()> this.getPlayer().getCoin()){
                System.out.println("Yeterli paraniz bulunmuyor...");
            }else {
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println(selectedArmor.getName() + " zirhi satin aldiniz.");
                this.getPlayer().setCoin(this.getPlayer().getCoin() - selectedArmor.getPrice());
                System.out.println("Kalan paraniz : " + this.getPlayer().getCoin());
            }
        }
    }
}
