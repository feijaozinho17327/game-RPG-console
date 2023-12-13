
package playerClass;
import enemyClass.*;
public class Archer extends PlayerAttributes implements PlayerAttacks {
    private int precision = 100;

    public Archer() {
        super(100, 100, 100, 100);
    }

    public Archer(int health, int strength, int resistance, int xp, int precision) {
        super(health, strength, resistance, xp);
        this.precision = precision;
    }

    public int getPrecision() {
        return this.precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }


    public int attackGoblin(Goblin goblin, int attack) {
        int damage = ((attack *(this.getPrecision() * this.getStreangth()) / 1000) - goblin.getResistance()) ;
        return damage;
    }

    }

