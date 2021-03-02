package life.view;

import life.model.GameModel;

import java.io.IOException;

public class ConsoleGameView implements GameView {

    @Override
    public void update(GameModel model) {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException ignored) {}

        System.out.println("Generation #" + model.getGen());
        System.out.println("Alive: " + model.getAliveCount());
            for (boolean[] booleans : model.getField()) {
                for (boolean aBoolean : booleans) {
                    System.out.print(aBoolean ? 'O' : ' ');
                }
                System.out.println();
        }
    }
}
