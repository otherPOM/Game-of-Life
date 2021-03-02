package life;

import life.model.GameModel;
import life.view.GameOfLife;

public class Main {
    public static void main(String[] args) throws Exception {
        var model = new GameModel(30);
        model.addView(new GameOfLife());
        Thread.sleep(1000);

        var i = 15;
        while (i-- > 0) {
            model.nextGeneration();
            Thread.sleep(100);
        }
    }
}
