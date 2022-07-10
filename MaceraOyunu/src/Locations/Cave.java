package Locations;

import Monsters.Zombie;
import pmain.Player;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player, "Magara", new Zombie(), "food",3);
    }
}
