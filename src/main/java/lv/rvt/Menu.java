package lv.rvt;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static String[] options = {"Start", "Options", "Rules", "Exit"};
    private static int selected = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        RandomWordGenerator generator = new RandomWordGenerator();

        while (true) {
            printMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    selected = 0;
                    break;
                case "2":
                    selected = 1;
                    break;
                case "3":
                    selected = 2;
                    break;
                case "4":
                    selected = 3;
                    break;
                case "":
                    System.out.println("\nJūs izvēlējāties: " + options[selected]);
                    if (options[selected].equals("Exit")) return;
                    if (options[selected].equals("Rules")) {
                        printRules();
                    }
                    if (options[selected].equals("Start")) {
                        try {
                            String word = generator.getWord();
                            Game game = new Game();
                            game.start(word);
                        } catch (Exception e) {
                            System.out.println("Error starting game: " + e.getMessage());
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid input. Use '1', '2', '3', '4' to select options and press Enter to confirm.");
                    break;
            }
        }
    }

    private static void printRules() {
        System.out.println("Wordle is a popular word puzzle game where players have six attempts to guess a five-letter word.");
        System.out.println("Rules:");
        System.out.println("1. Guess a five-letter word.");
        System.out.println("2. Feedback:");
        System.out.println("   🟢 - Correct letter & position.");
        System.out.println("   🟡 - Correct letter, wrong position.");
        System.out.println("   ⚪ - Letter not in word.");
        System.out.println("3. You have six attempts.");
        System.out.println("4. Only real five-letter words are allowed.");
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("\nIzvēlieties opciju ar '1'-'4' un nospiediet Enter:");
        for (int i = 0; i < options.length; i++) {
            if (i == selected) {
                System.out.println("> " + options[i]);
            } else {
                System.out.println("  " + options[i]);
            }
        }
    }
}
