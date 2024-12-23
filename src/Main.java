
import play.*;
import player.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Оберіть режим гри:");
            System.out.println("1. Гравець відгадує число.");
            System.out.println("2. Комп'ютер відгадує число.");
            System.out.println("3. Комп'ютер vs Комп'ютер.");
            System.out.println("4. Гравець vs Гравець.");
            System.out.print("Ваш вибір: ");
            int mode = scanner.nextInt();

            System.out.println("Оберіть рівень складності:");
            System.out.println("1. Легкий (1-100)");
            System.out.println("2. Середній (1-10,000)");
            System.out.println("3. Важкий (1-1,000,000)");
            System.out.print("Ваш вибір: ");
            int difficulty = scanner.nextInt();

            int maxRange = switch (difficulty) {
                case 1 -> 100;
                case 2 -> 10_000;
                case 3 -> 1_000_000;
                default -> {
                    System.out.println("Некоректний вибір рівня складності. Використано рівень: Легкий (1-100).");
                    yield 100;
                }
            };

            Player player1 = null, player2 = null;

            switch (mode) {
                case 1 -> {
                    player1 = new Human();
                    player2 = new PC(maxRange);
                }
                case 2 -> {
                    player1 = new PC(maxRange);
                    player2 = new Human();
                }
                case 3 -> {
                    player1 = new PC(maxRange);
                    player2 = new PC(maxRange);
                }
                case 4 -> {
                    player1 = new Human();
                    player2 = new Human();
                }
                default -> System.out.println("Невірний вибір.");
            }

            if (player1 != null && player2 != null) {
                new Game(player1, player2, maxRange).play();
            }

            System.out.println("Почати гру заново? (КАНЄШНА/НАГРАВСЯ)");
            String replayChoice = scanner.next().toUpperCase();

            if ("НАГРАВСЯ".equals(replayChoice)) {
                System.out.println("З вами було цікаво!");
                break;
            }
        }
    }
}
