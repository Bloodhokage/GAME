package play;

import player.Player;
import player.Human;
import player.PC;

public class Game implements GameLogic {
    private final Player guesser;    // Той, хто відгадує
    private final Player responder; // Той, хто загадує
    private final int maxRange;

    public Game(Player guesser, Player responder, int maxRange) {
        this.guesser = guesser;
        this.responder = responder;
        this.maxRange = maxRange;
    }

    @Override
    public void play() {
        int secretNumber;

        // Визначаємо, хто загадує число
        if (responder instanceof Human) {
            System.out.println("Загадайте число для комп'ютера (від 1 до " + maxRange + "):");
            secretNumber = responder.makeGuess(); // Людина загадує число
        } else {
            secretNumber = (int) (Math.random() * maxRange) + 1; // Комп'ютер загадує число
            System.out.println("Комп'ютер загадує число...");
        }

        System.out.println("Гра починається!");
        int attempts = 0;

        while (true) {
            attempts++;
            int guess = guesser.makeGuess(); // Гравець або комп'ютер робить здогад

            System.out.println((guesser instanceof Human ? "Гравець" : "Комп'ютер") + " думає: " + guess);

            if (guess == secretNumber) {
                System.out.println((guesser instanceof Human ? "Гравець" : "Комп'ютер") +
                        " вгадав число за " + attempts + " спроб!");
                break;
            } else if (guess > secretNumber) {
                System.out.println("Число менше.");
                if (guesser instanceof PC pcPlayer) {
                    pcPlayer.updateRange(false); // Зменшуємо верхню межу
                }
            } else {
                System.out.println("Число більше.");
                if (guesser instanceof PC pcPlayer) {
                    pcPlayer.updateRange(true); // Збільшуємо нижню межу
                }
            }
        }
    }
}
