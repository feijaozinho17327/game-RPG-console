package enemyClass;

public class EnemyAttributes {

    private int health;
    private int streangth;
    private int resistance;
    private int xp;


    public EnemyAttributes(int health, int streangth, int resistance, int xp) {
        this.health = health;
        this.streangth = streangth;
        this.resistance = resistance;
        this.xp = xp;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStreangth() {
        return streangth;
    }

    public void setStreangth(int streangth) {
        this.streangth = streangth;
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

