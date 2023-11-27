import enemyClass.Goblin;
import playerClass.Archer;
import playerClass.Warrior;
import playerClass.Wizard;
import java.util.Scanner;
public class GameStart {

    public String chooseClass(int aux) {
        Scanner scanner = new Scanner(System.in);

        String chosenClass = "";

        switch (aux) {
            case 1:
                chosenClass = "Arqueiro";

                kombat(chosenClass, comand, luck, number);
                break;
            case 2:
                chosenClass = "Guerreiro";
                break;
            case 3:
                chosenClass = "Mago";
                break;
            default:
                chosenClass = "Opção inválida";
                break;
        }

        return chosenClass;
    }

    public void kombat(String chosenClass, String comand, int luck, int number) {
        GameKombat gameKombat = new GameKombat();

        switch (chosenClass.toLowerCase()) {
            case "arqueiro":
                Archer archerClass = new Archer();
                String messageSC = startComand(comand, luck, number);
                System.out.println(messageSC);

                break;
            case "guerreiro":
                Warrior warriorClass = new Warrior(150, 120, 100, 80);

                break;
            case "mago":
                Wizard wizardClass = new Wizard(80, 60, 70, 100, 120);

                break;
            default:

                break;
        }


    }



    public String startComand(String command, int luck, int number) {
        GameKombat gameKombat = new GameKombat();

        if (command.equalsIgnoreCase("--luckRand")) {
            boolean isLuckSuccessful = gameKombat.startRandNumberLuck(luck, number);

            if (isLuckSuccessful) {
                return "A sorte está ao seu favor, poderá seguir em frente.";
            } else {
                // Criação do jogador (adaptar com a lógica do jogo)
                Archer player = new Archer();

                int numberOfEnemies = gameKombat.startRandNumberPower();

                StringBuilder mensagem = new StringBuilder("Ops. Acabaras de se deparar com oponentes:\n");

                // Criação dos inimigos e exibição das opções para o jogador
                Goblin[] enemies = new Goblin[numberOfEnemies];
                for (int i = 0; i < numberOfEnemies; i++) {
                    enemies[i] = new Goblin();
                    mensagem.append("Inimigo ").append(i + 1).append(": Vida=").append(enemies[i].getHealth())
                            .append(", Força=").append(enemies[i].getStrength())
                            .append(", Resistência=").append(enemies[i].getResistance())
                            .append(", XP=").append(enemies[i].getXp()).append("\n");
                }

                // Seleção do inimigo a ser atacado
                Scanner scanner = new Scanner(System.in);
                System.out.println(mensagem.toString());
                System.out.println("Escolha o número do inimigo que deseja atacar: (1-" + numberOfEnemies + ")");
                int changeEnemy = scanner.nextInt();

                // Verificação e ataque ao inimigo escolhido
                if (changeEnemy >= 1 && changeEnemy <= numberOfEnemies) {
                    if (enemies[changeEnemy - 1].getHealth() <= 0) {

                        int attack = player.attackCollar(enemies[changeEnemy - 1], gameKombat.startRandNumberPower());

                        if (attack > 0) {
                            enemies[changeEnemy - 1].setHealth(enemies[changeEnemy - 1].getHealth() - attack);

                            return "Você atacou o inimigo " + changeEnemy + " com " + attack + " de ataque!";
                        } else {
                            return "Voce atacou mas o inimigo resistiu!";
                        }

                    } else { return "Inimigo morto.";}
                } else {
                    return "Opção inválida.";
                }
            }
        } else {
            return "Comando inválido";
        }
    }



}