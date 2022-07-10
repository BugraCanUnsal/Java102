package Locations;

import Monsters.Wampire;
import pmain.Player;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player, "Orman", new Wampire(), "firewood",3);
    }
}
