package player;

public class PC implements Player {
    private final int maxRange;
    private int min = 1;
    private int max;

    public PC(int maxRange) {
        this.maxRange = maxRange;
        this.max = maxRange;
    }

    @Override
    public int makeGuess() {
        int guess = (min + max) / 2; // Використовуємо середнє значення
        return guess;
    }

    public void updateRange(boolean isGreater) {
        if (isGreater) {
            min = (min + max) / 2 + 1; // Якщо число більше, збільшуємо мінімум
        } else {
            max = (min + max) / 2 - 1; // Якщо число менше, зменшуємо максимум
        }
    }
}
