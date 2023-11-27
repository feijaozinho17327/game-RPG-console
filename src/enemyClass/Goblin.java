package enemyClass;

public class Goblin extends EnemyAttributes{

    public Goblin() {
        super(25, 25, 25, 25); // Define todos os atributos como 25 (nível médio)
    }

    public Goblin(int health, int strength, int resistance, int xp) {
        super(health, strength, resistance, xp);
    }
}
