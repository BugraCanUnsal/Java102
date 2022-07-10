package Locations;

import pmain.Player;

public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Guvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Guvenli evdesiniz.");
        System.out.println("Caniniz yenilendi.");
        this.getPlayer().refreshHitPoint();
        System.out.println("Caniniz : " + this.getPlayer().getHitPoint());
        return true;
    }
}
