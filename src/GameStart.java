import playerClass.*;

public class GameStart {

    public String chooseClass(int aux) {
        String chosenClass = "";

        switch (aux) {
            case 1:
                chosenClass = "Arqueiro";
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

    public void kombat(String chosenClass) {


        switch (chosenClass.toLowerCase()) {
            case "arqueiro":
                Archer archerClass = new Archer();



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




}