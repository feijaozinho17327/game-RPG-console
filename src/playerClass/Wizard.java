
package playerClass;

public class Wizard extends PlayerAttributes {
    private int mana;

    public Wizard(int health, int strength, int resistance, int xp, int mana) {
        super(health, strength, resistance, xp);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int newMana) {
        this.mana = newMana;
    }
}
