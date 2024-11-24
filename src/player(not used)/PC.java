package src.player;

import java.util.Random;

public class PC implements Player {
    private final Random random = new Random();
    private final int maxRange;

    public PC(int maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public int makeGuess() {
        return random.nextInt(maxRange) + 1; // Генерація випадкового числа
    }
}
