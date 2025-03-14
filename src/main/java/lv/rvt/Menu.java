
package lv.rvt;
import java.io.IOException;
public class Menu {
    private static String[] options = {"Start", "Options", "Rules", "Exit"};
    private static int selected = 0;

    public static void main(String[] args) throws IOException {
        while (true) {
            printMenu();
            int key = readKey(); 
            switch (key) {
                case 1: 
                    if (System.in.available() > 0 && System.in.read() == 91) {
                        int arrowKey = System.in.read();
                        if (arrowKey == 65) selected = (selected - 1 + options.length) % options.length;
                        if (arrowKey == 66) selected = (selected + 1) % options.length; 
                    }
                    break;
                case 2: 
                    System.out.println("\nJus izveleja " + options[selected]);
                    if (options[selected].equals("Exit")) return; 
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nIzmanto bultinas lai parvietoties pa Menu ↑ ↓");
        for (int i = 0; i < options.length; i++) {
            if (i == selected) {
                System.out.println("> " + options[i]);
            } else {
                System.out.println("  " + options[i]);
            }
        }
    }

    private static int readKey() throws IOException {
        return System.in.read();
    }
}