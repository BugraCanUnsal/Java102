package Locations;

import Monsters.Bear;
import pmain.Player;

public class River extends BattleLoc{
    public River(Player player) {
        super(player, "Nehir", new Bear(), "water",3);
    }
}
