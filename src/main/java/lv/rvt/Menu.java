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
                    System.out.println("\nJus izvelejaties " + options[selected]);
                    if (options[selected].equals("Exit")) return;
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
