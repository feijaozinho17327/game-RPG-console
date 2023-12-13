import enemyClass.Goblin;
import playerClass.Archer;
import playerClass.PlayerAttacks;
import playerClass.Warrior;
import playerClass.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStart {

    public String chooseClassAndCombat(int aux) {
        Scanner scanner = new Scanner(System.in);
        GameKombat gameKombat = new GameKombat();
        String chosenClass = "";

        switch (aux) {
            case 1:
                chosenClass = "Arqueiro";

                System.out.println("Digite --luckRand para prosseguir.");
                String command = scanner.nextLine();

                boolean continueCombat = true;

                while (continueCombat) {
                    int luck = gameKombat.startRandNumberPower();
                    System.out.println("Tente advinhar um número de 1 a 5");
                    int number = scanner.nextInt();
                    startCommand(command, luck, number, chosenClass);

                    // Condição de saída do loop (pode ser ajustada conforme necessário)
                    System.out.println("Deseja continuar o combate? (S/N)");
                    scanner.nextLine(); // Limpa a entrada do scanner
                    String continueChoice = scanner.nextLine().trim().toLowerCase();
                    if (!continueChoice.equals("s")) {
                        continueCombat = false;
                    }
                }return chosenClass;

            case 2:
                chosenClass = "Guerreiro";
                return chosenClass;
                // Lógica para a classe Guerreiro...

            case 3:
                chosenClass = "Mago";
                return chosenClass;
                // Lógica para a classe Mago...

            default:
                chosenClass = "Opção inválida";
                return chosenClass;

        }


    }


    public void startCommand(String command, int luck, int number, String playerClass) {
        GameKombat gameKombat = new GameKombat();

        if (command.equalsIgnoreCase("--luckRand")) {
            boolean isLuckSuccessful = gameKombat.startRandNumberLuck(luck, number);
            Object player = switch (playerClass.toLowerCase()) {
                case "arqueiro" -> new Archer();
                case "guerreiro" -> new Warrior();
                case "mago" -> new Wizard();
                default -> throw new IllegalArgumentException("Classe de jogador desconhecida: " + playerClass);
            };

            if (isLuckSuccessful) {
                System.out.println("A sorte está ao seu favor, poderá seguir em frente.");
            } else {





                int numberOfEnemies = gameKombat.startRandNumberPower();

                List<Goblin> enemies = new ArrayList<>();
                // Construção da mensagem com informações dos inimigos
                StringBuilder message = new StringBuilder("Ops. Acabaras de se deparar com oponentes:\n");

                for (int i = 0; i < numberOfEnemies; i++) {
                    Goblin enemy = new Goblin();
                    enemies.add(enemy);
                }

                for (Goblin enemy : enemies) {

                    if(enemy.getHealth() <= 0) {
                        enemies.remove(enemy);
                    }

                    message.append("Inimigo ").append(enemies.indexOf(enemy) + 1).append(": Vida=").append(enemy.getHealth())
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


                    if (changeEnemy >= 1 && changeEnemy <= enemies.size() && enemies.get(changeEnemy -1).getHealth() >= 0) {
                        Goblin selectedEnemy = enemies.get(changeEnemy - 1);


                        int attack = 0;
                        if (player instanceof PlayerAttacks) {
                            attack = ((PlayerAttacks) player).attackGoblin(selectedEnemy, gameKombat.startRandNumberPower());
                        }
                        if (attack > 0) {
                            selectedEnemy.setHealth(selectedEnemy.getHealth() - attack);
                            if (selectedEnemy.getHealth() <= 0 ) {
                                enemies.remove(selectedEnemy);
                            }
                            System.out.println("Você atacou o inimigo " + changeEnemy + " com " + attack + " de ataque!");


                        } else {
                            System.out.println("Você atacou, mas o inimigo resistiu!");
                        }


                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
            }
        } else {
            System.out.println("Comando inválido");
        }
        System.out.println("vitoria!!!");
    }

}
