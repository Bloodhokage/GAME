package src.player;

import java.util.Scanner;

public class Human implements Player {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int makeGuess() {
        System.out.print("Ваше число: ");
        return scanner.nextInt();
    }
}