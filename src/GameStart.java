import enemyClass.Goblin;
import playerClass.Archer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStart {

    public String chooseClass(int aux) {
        Scanner scanner = new Scanner(System.in);
        GameKombat gameKombat = new GameKombat();
        String chosenClass = "";

        switch (aux) {
            case 1:
                chosenClass = "Arqueiro";
                System.out.println("Digite --luckRand para prosseguir.");
                String command = scanner.nextLine();
                kombat(chosenClass, command);
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

    public void kombat(String chosenClass, String command) {
        GameKombat gameKombat = new GameKombat();

        switch (chosenClass.toLowerCase()) {
            case "arqueiro":
                Archer archerClass = new Archer();

                boolean continueCombat = true;

                while (continueCombat) {
                    int luck = gameKombat.startRandNumberPower();
                    System.out.println("Tente advinhar um número de 1 a 5");
                    int number = new Scanner(System.in).nextInt();
                    String messageSC = startCommand(command, luck, number);
                    System.out.println(messageSC);

                    // Condição de saída do loop (pode ser ajustada conforme necessário)
                    System.out.println("Deseja continuar o combate? (S/N)");
                    Scanner scanner = new Scanner(System.in);
                    String continueChoice = scanner.nextLine().trim().toLowerCase();
                    if (!continueChoice.equals("s")) {
                        continueCombat = false;
                    }
                }


                // outras classes...
            default:
                break;
        }
    }

    public String startCommand(String command, int luck, int number) {
        GameKombat gameKombat = new GameKombat();

        if (command.equalsIgnoreCase("--luckRand")) {
            boolean isLuckSuccessful = gameKombat.startRandNumberLuck(luck, number);

            if (isLuckSuccessful) {
                return "A sorte está ao seu favor, poderá seguir em frente.";
            } else {
                // Criação do jogador e inimigos
                Archer player = new Archer();
                int numberOfEnemies = gameKombat.startRandNumberPower();

                List<Goblin> enemies = new ArrayList<>();
                // Construção da mensagem com informações dos inimigos
                StringBuilder message = new StringBuilder("Ops. Acabaras de se deparar com oponentes:\n");
                for (int i = 0; i < numberOfEnemies; i++) {
                    Goblin enemy = new Goblin();

                        enemies.add(enemy);
                        message.append("Inimigo ").append(i + 1).append(": Vida=").append(enemy.getHealth())
                                .append(", Força=").append(enemy.getStrength())
                                .append(", Resistência=").append(enemy.getResistance())
                                .append(", XP=").append(enemy.getXp()).append("\n");

                }

                // Seleção do inimigo a ser atacado
                Scanner scanner = new Scanner(System.in);
                while (!enemies.isEmpty()) {
                    System.out.println(message);
                    System.out.println("Escolha o número do inimigo que deseja atacar: (1-" + enemies.size() + ")");
                    int changeEnemy = scanner.nextInt();

                    // Verificação e ataque ao inimigo escolhido
                    if (changeEnemy >= 1 && changeEnemy <= enemies.size()) {
                        Goblin selectedEnemy = enemies.get(changeEnemy - 1);

                        int attack = player.attackGoblin(selectedEnemy, gameKombat.startRandNumberPower());

                        if (attack > 0) {
                            selectedEnemy.setHealth(selectedEnemy.getHealth() - attack);
                            if (selectedEnemy.getHealth() <= 0 ) {
                                enemies.remove(selectedEnemy);
                            }
                            return "Você atacou o inimigo " + changeEnemy + " com " + attack + " de ataque!";


                        } else {
                            return "Você atacou, mas o inimigo resistiu!";
                        }


                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
            }
        } else {
            return "Comando inválido";
        }
    return "vitoria!!!";
    }

}
