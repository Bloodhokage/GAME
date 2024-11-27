package player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human implements Player {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int makeGuess() {
        while (true) {
            try {
                System.out.print("Ваше число: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Будь ласка, введіть ціле число!");
                scanner.next(); // Очищуємо некоректний ввід
            }
        }
    }
}
