package playerClass;

public class PlayerAttributes {
    private int health;
    private int streangth;
    private int resistance;
    private int xp;

    public PlayerAttributes(int health, int streangth, int resistance, int xp) {
        this.health = health;
        this.streangth = streangth;
        this.resistance = resistance;
        this.xp = xp;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStreangth() {
        return this.streangth;
    }

    public void setStreangth(int streangth) {
        this.streangth = streangth;
    }

    public int getResistance() {
        return this.resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}

