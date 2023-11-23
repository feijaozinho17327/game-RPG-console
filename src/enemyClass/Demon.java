package enemyClass;

public class Demon extends EnemyAttributes {

    private int mana;

    public Demon(int health, int strength, int resistance, int xp, int mana) {
        super(health, strength, resistance, xp);
        this.mana = mana;
    }


    public int getMana() {
        return mana;
    }

    public void setMana(int newMana) {
        this.mana = newMana;
    }
}




