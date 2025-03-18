package lv.rvt;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static String[] options = {"Start", "Options", "Rules", "Exit"};
    private static int selected = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
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
                case "enter":
                    System.out.println("\nJūs izvēlējāties " + options[selected]);
                    if (options[selected].equals("Exit")) return;
                    break;
                default:
                    System.out.println("Invalid input. Use '1', '2', '3', '4' to select options and 'enter' to confirm.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nIzmantojiet '1', '2', '3', '4', lai izveletos opcijas, un 'enter', lai apstiprinātu:");
        for (int i = 0; i < options.length; i++) {
            if (i == selected) {
                System.out.println("> " + options[i]);
            } else {
                System.out.println("  " + options[i]);
            }
        }
    }
}