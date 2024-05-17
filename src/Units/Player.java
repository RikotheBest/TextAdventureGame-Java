package Units;

import Weapons.NoWeapon;
import Weapons.Stick;
import Weapons.Weapon;

public class Player extends Unit{
    public Player() {
        hp = 10;
        weapon = new NoWeapon();

    }
}
