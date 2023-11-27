package enemyClass;

public class EnemyAttributes {

    private int health;
    private int strength;
    private int resistance;
    private int xp;


    public EnemyAttributes(int health, int strength, int resistance, int xp) {
        this.health = health;
        this.strength = strength;
        this.resistance = resistance;
        this.xp = xp;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}

