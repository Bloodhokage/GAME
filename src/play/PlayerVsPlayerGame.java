package play;

import java.util.Scanner;

public class PlayerVsPlayerGame implements GameLogic {
    private final int maxRange;

    public PlayerVsPlayerGame(int maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хей, загадуй число для Друга (від 1 до " + maxRange + "): ");
        int secretNumber = scanner.nextInt();

        if (secretNumber < 1 || secretNumber > maxRange) {
            System.out.println("НЕ МУХЛЮЙ, ТАКЕ НЕ МОЖЛИВО ВІДГАДАТИ ЧЕРЕЗ МЕЖІ!");
            return;
        }

        System.out.println("Чувак, тепер твоя черга відгадувати!");

        int attempts = 0;

        while (true) {
            System.out.print("Чувак, твоє число: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < 1 || guess > maxRange) {
                System.out.println("Ти сам встановив рівень межі! Число не відповідає межам!");
                continue;
            }

            if (guess == secretNumber) {
                System.out.println("А ти молодець! Вгадав число за " + attempts + " спроб!");
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
