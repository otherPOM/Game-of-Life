package life.view;

import java.io.IOException;

public class ConsoleGameView extends GameView {

    @Override
    public void update(int gen, int aliveCount, boolean[][] field) {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException ignored) {}

        System.out.println("Generation #" + gen);
        System.out.println("Alive: " + aliveCount);
            for (boolean[] booleans : field) {
                for (boolean aBoolean : booleans) {
                    System.out.print(aBoolean ? 'O' : ' ');
                }
                System.out.println();
        }
    }
}
