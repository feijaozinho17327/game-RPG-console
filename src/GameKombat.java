import java.util.Random;

public class GameKombat {

    public boolean startRandNumberLuck(int luck, int number) {

        int aux = 0;

        Random random = new Random();

        int[] generatedNumbers = new int[luck];

        for(int i = 0 ; i < luck ; i++) {
            generatedNumbers[i] = random.nextInt(5) + 1;
            if (number == generatedNumbers[i]) {
                aux = 1;

            }
        }

        if(aux == 1) {
            return true;
        } else {
            return false;
        }


    }


    public int startRandNumberPower() {

        Random random = new Random();

        return random.nextInt(10) + 1;

    }


    



}
