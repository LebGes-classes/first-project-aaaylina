public class Labyrinth {
    private char[][] labyrinth;
    private int exitX;
    private int exitY;

    public Labyrinth(int level) {
        initializeLabyrinth(level);
        setExitPosition();
    }

    private void initializeLabyrinth(int level) {
        int size = 15 + level * 2; // Увеличиваем размер лабиринта с каждым уровнем
        labyrinth = new char[size][size];

        // Заполняем лабиринт стенами
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                labyrinth[i][j] = '#';
            }
        }

        // Делаем проходы (начинаем с центра)
        for (int i = 1; i < size - 1; i += 2) {
            for (int j = 1; j < size - 1; j += 2) {
                labyrinth[i][j] = ' ';
                if (Math.random() > 0.3) {
                    labyrinth[i][j + 1] = ' ';
                }
                if (Math.random() > 0.3) {
                    labyrinth[i + 1][j] = ' ';
                }
            }
        }

        // Устанавливаем начальную позицию игрока
        labyrinth[1][1] = ' ';

        // Добавляем случайные препятствия
        for (int i = 0; i < level * 2; i++) {
            int x = (int) (Math.random() * (size - 2)) + 1;
            int y = (int) (Math.random() * (size - 2)) + 1;
            if (labyrinth[x][y] == ' ') {
                labyrinth[x][y] = '#';
            }
        }
    }

    private void setExitPosition() {
        exitX = 0; 
        exitY = (int) (Math.random() * (labyrinth[0].length - 2)) + 1; // Генерация выхода сверху
        labyrinth[exitX][exitY] = ' '; // Открываем выход
    }

    public char[][] getLabyrinth() {
        return labyrinth;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }

    public boolean isMoveValid(int x, int y) {
        return x >= 0 && x < labyrinth.length &&
                y >= 0 && y < labyrinth[x].length &&
                labyrinth[x][y] != '#';
    }
}
