package life.view;

public class ConsoleGameView extends GameView {

    @Override
    public void update(int gen, boolean[][] field) {
            for (boolean[] booleans : field) {
                for (boolean aBoolean : booleans) {
                    System.out.print(aBoolean ? 'O' : ' ');
                }
                System.out.println();
        }
    }
}
