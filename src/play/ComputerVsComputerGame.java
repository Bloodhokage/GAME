package play;

import java.util.Random;

public class ComputerVsComputerGame implements GameLogic {
    private final int maxRange;

    public ComputerVsComputerGame(int maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public void play() {
        Random random = new Random();
        int secretNumber = random.nextInt(maxRange) + 1;
        int min = 1, max = maxRange, attempts = 0;

        System.out.println("Комп'ютер №1 загадав число для Комп'ютера №2.");

        while (true) {
            int guess = (min + max) / 2;
            attempts++;
            System.out.println("Комп'ютер №2 думає: " + guess);

            if (guess == secretNumber) {
                System.out.println("Комп'ютер №2 вгадав число за " + attempts + " спроб!");
                break;
            } else if (guess > secretNumber) {
                max = guess - 1;
            } else {
                min = guess + 1;
            }
        }
    }
}
