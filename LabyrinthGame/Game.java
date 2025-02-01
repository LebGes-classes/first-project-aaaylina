import java.util.Scanner;

public class Game {
    private Labyrinth labyrinth;
    private Player player;
    private int level;  // Счетчик уровней

    public Game() {
        level = 1;
        labyrinth = new Labyrinth(level);
        player = new Player(1, 1);
    }

    public void movePlayer(char direction) {
        int newX = player.getX();
        int newY = player.getY();

        switch (direction) {
            case 'w': newX--; break;
            case 's': newX++; break;
            case 'a': newY--; break;
            case 'd': newY++; break;
            default:
                System.out.println("Invalid move!");
                return;
        }

        if (labyrinth.isMoveValid(newX, newY)) {
            player.move(newX - player.getX(), newY - player.getY());
        } else {
            System.out.println("You can't move there!");
        }
    }

    public void printLabyrinth() { 
        ClearConsole clear = new ClearConsole();
        clear.clear_console();

        System.out.println("Level: " + level);

        char[][] lab = labyrinth.getLabyrinth();
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (i == player.getX() && j == player.getY()) {
                    System.out.print("@ ");
                } else if (i == labyrinth.getExitX() && j == labyrinth.getExitY()) {
                    System.out.print("  ");
                } else {
                    System.out.print(lab[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void nextLevel() {
        level++;
        labyrinth = new Labyrinth(level); // Генерируем новый лабиринт
        player = new Player(1, 1); // Перемещаем игрока на стартовую позицию
        System.out.println("Congratulations! You've reached Level " + level);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printLabyrinth();
            System.out.println("Enter your move (w/a/s/d) or q to quit:");
            char input = scanner.next().charAt(0);

            if (input == 'q') {
                System.out.println("Thanks for playing!");
                break;
            }
            movePlayer(input);

            if (player.getX() == labyrinth.getExitX() && player.getY() == labyrinth.getExitY()) {
                nextLevel();
            }
        }
    }
}
