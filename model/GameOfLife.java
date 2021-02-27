package life.model;

import life.view.GameView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class GameOfLife {
    private int gen;

    private final List<GameView> views;
    private final boolean[][] field;

    public GameOfLife(int n, int seed) {
        views = new ArrayList<>();
        field = new boolean[n][n];
        var rand = new Random(seed);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = rand.nextBoolean();
            }
        }
        gen = 1;
    }

    public void addView(GameView view) {
        views.add(view);
    }

    public void updateView() {
        views.forEach(view -> view.update(gen, field));
    }

    public void jumpToGeneration(int m) {
        while (m-- > 0) {
            nextG();
        }
        updateView();
    }

    public void nextGeneration() {
        nextG();
        updateView();
    }

    private void nextG() {
        var newField = new boolean[field.length][field[0].length];
        for (int i = 0; i < newField.length; i++) {
            for (int j = 0; j < newField[i].length; j++) {
                newField[i][j] = cellEvolution(i, j);
            }
        }
        IntStream.range(0, newField.length)
                .forEach(i -> System.arraycopy(newField[i], 0, field[i], 0, newField[i].length));
        gen++;
    }

    private boolean cellEvolution(int i, int j) {
        var liveNeighbors = countOfLiveNeighbors(i, j);
        if (field[i][j]) {
            return liveNeighbors == 2 || liveNeighbors == 3;
        } else {
            return liveNeighbors == 3;
        }
    }

    private int countOfLiveNeighbors(int i, int j) {
        var left = j > 0 ? j - 1 : field[i].length - 1;
        var right = j < field[i].length - 1 ? j + 1 : 0;
        var up = i > 0 ? i - 1 : field.length - 1;
        var down = i < field.length - 1 ? i + 1 : 0;

        var count = 0;
        count = field[up][left] ? count + 1 : count;
        count = field[up][j] ? count + 1 : count;
        count = field[up][right] ? count + 1 : count;
        count = field[i][left] ? count + 1 : count;
        count = field[i][right] ? count + 1 : count;
        count = field[down][left] ? count + 1 : count;
        count = field[down][j] ? count + 1 : count;
        count = field[down][right] ? count + 1 : count;

        return count;
    }
}
