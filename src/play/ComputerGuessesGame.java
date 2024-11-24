package src.play;

import java.util.Scanner;

public class ComputerGuessesGame implements GameLogic {
    private final int maxRange;

    public ComputerGuessesGame(int maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Загадайте число для комп'ютера (від 1 до " + maxRange + "): ");
        int secretNumber = scanner.nextInt();

        if (secretNumber < 1 || secretNumber > maxRange) {
            System.out.println("НЕ МУХЛЮЙ, ТАКЕ НЕ МОЖЛИВО ВІДГАДАТИ ЧЕРЕЗ МЕЖІ!");
            return;
        }

        int min = 1, max = maxRange, attempts = 0;

        while (true) {
            int guess = (min + max) / 2;
            attempts++;
            System.out.println("Комп'ютер думає: " + guess);

            if (guess == secretNumber) {
                System.out.println("Комп'ютер вгадав ваше число за " + attempts + " спроб!");
                break;
            } else if (guess > secretNumber) {
                System.out.println("Моє число менше.");
                max = guess - 1;
            } else {
                System.out.println("Моє число більше.");
                min = guess + 1;
            }
        }
    }
}
