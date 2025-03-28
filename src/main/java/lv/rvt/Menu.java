package lv.rvt;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.event.SwingPropertyChangeSupport;

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
                    System.out.println("\nJus izvelejaties " + options[selected]);
                    if (options[selected].equals("Exit")) return;
                    if (options[selected].equals("Rules"))
                        System.out.println("Wordle is a popular word puzzle game where players have six attempts to guess a five-letter word. Each guess provides feedback to help the player get closer to the correct answer.");
                        System.out.println(" ");
                        System.out.println("Wordle Rules:");
                        System.out.println(" ");
                        System.out.println("1. Guess a five-letter word – You enter a word and submit it.");
                        System.out.println(" ");
                        System.out.println("2. Color-coded feedback:");
                        System.out.println(" ");
                        System.out.println("🟢: The letter is in the correct position.");
                        System.out.println("🟡: The letter is in the word but in the wrong position.");
                        System.out.println("⚪: The letter is not in the word at all.");
                        System.out.println(" ");
                        System.out.println("3. Six attempts – You have up to six tries to guess the correct word.");
                        System.out.println(" ");
                        System.out.println("4. Valid words only – Every guess must be a real five-letter word.");
                        System.out.println();
                    if (options[selected].equals("Start")) {
                        generator.start();
                    }
                    break;
                default:
                    System.out.println("Invalid input. Use '1', '2', '3', '4' to select options and press Enter to confirm.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nIzmantojiet '1', '2', '3', '4', lai izvēlētos opcijas, un Enter, lai apstiprinātu:");
        for (int i = 0; i < options.length; i++) {
            if (i == selected) {
                System.out.println("> " + options[i]);
            } else {
                System.out.println("  " + options[i]);
            }
        }
    }

}
