package play;

import java.util.Scanner;

public class PlayerGuessesGame implements GameLogic {
    private final int secretNumber;
    private final int maxRange;

    public PlayerGuessesGame(int secretNumber, int maxRange) {
        this.secretNumber = secretNumber;
        this.maxRange = maxRange;
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Комп'ютер загадав число. Вгадуйте!");

        while (true) {
            System.out.print("Ваше число: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < 1 || guess > maxRange) {
                System.out.println("Ти сам встановив рівень межі! Число не відповідає межам!");
                continue;
            }

            if (guess == secretNumber) {
                System.out.println("Ви розумніші ніж більша частина людей! Або просто вгадали :)! Вгадано за " + attempts + " спроб.");
                break;
            } else if (guess > secretNumber) {
                System.out.println("Число менше.");
            } else {
                System.out.println("Число більше.");
            }
             /*Підказка після  5 спроб
            if (attempts == 5 && true) {
                if (secretNumber % 2 == 0) {
                    System.out.println("Підказка: Число парне.");
                } else {
                    System.out.println("Підказка: Число непарне.");
                    }
            }*/
        }
    }
}
