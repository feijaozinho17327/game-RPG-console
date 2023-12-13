
package playerClass;

import enemyClass.Goblin;

public class Warrior extends PlayerAttributes implements PlayerAttacks{

    public Warrior(int health, int strength, int resistance, int xp) {
        super(health, strength, resistance, xp);
    }

    public Warrior() {

    }

    public int attackGoblin(Goblin goblin, int attack) {
        int damage = ((attack *(this.getStreangth() * this.getStreangth()) / 1000) - goblin.getResistance()) ;
        return damage;
    }


}



