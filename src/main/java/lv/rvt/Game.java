package lv.rvt;
import java.util.Scanner;

public class Game {
    private static final int MAX_ATTEMPTS = 6;
    private Scanner scanner = new Scanner(System.in);

    public void start(String correctWord) {
        if (correctWord == null || correctWord.length() != 5) {
            System.out.println("Invalid word received. Game cannot start.");
            return;
        }

        System.out.println("Guess the 5-letter word. You have " + MAX_ATTEMPTS + " attempts.");

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Attempt " + attempt + ": ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() != 5) {
                System.out.println("Word must be 5 letters.");
                attempt--;
                continue;
            }

            if (guess.equals(correctWord)) {
                System.out.println("🟢🟢🟢🟢🟢 You guessed it!");
                // Result.saveResult(true, attempt, correctWord, guess);
                return;
            } else {
                showFeedback(correctWord, guess);
            }
        }

        // System.out.println("Out of attempts! The word was: " + correctWord);
        // Result.saveResult(false, MAX_ATTEMPTS, correctWord, "-");
    }

    private void showFeedback(String correct, String guess) {
        StringBuilder feedback = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char g = guess.charAt(i);
            if (g == correct.charAt(i)) {
                feedback.append("🟢");
            } else if (correct.contains(String.valueOf(g))) {
                feedback.append("🟡");
            } else {
                feedback.append("⚪");
            }
        }

        System.out.println("Feedback: " + feedback);
    }
}
