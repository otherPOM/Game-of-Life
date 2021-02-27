package life;

import life.controller.ConsoleGameController;
import life.view.ConsoleGameView;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var consoleController = new ConsoleGameController();
        var model = consoleController.initNewModel();
        model.addView(new ConsoleGameView());

        var i = 15;
        while (i-- > 0) {
            consoleController.nextGeneration();
            Thread.sleep(1);
        }
    }
}
