import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    
    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void display() {
        while (true) {
            System.out.println("=== Labyrinth Game ===");
            System.out.println("1. Start game");
            System.out.println("2. Rules");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    startGame();
                    break;
                case "2":
                    printRules();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Incorrect choice. Please try again.");
            }
        }
    }

    private void startGame() {
        Game game = new Game();
        game.startGame();
    }

    private void printRules() {
        System.out.println("\n=== Rules ===");
        System.out.println("1. You are represented as '@' in the labyrinth.");
        System.out.println("2. Move using 'w' (up), 'a' (left), 's' (down), 'd' (right).");
        System.out.println("3. Avoid walls represented by '#'.");
        System.out.println("4. Your goal is to reach the exit (empty space in the upper part of the labyrinth).");
        System.out.println("5. Press 'q' during the game to quit.");
        System.out.println();
    }
}

