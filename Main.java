package life;

import life.controller.ConsoleGameController;
import life.view.ConsoleGameView;

public class Main {
    public static void main(String[] args) {
        var consoleController = new ConsoleGameController();
        var model = consoleController.initNewModel();
        model.addView(new ConsoleGameView());
        consoleController.jumpToGeneration();
    }
}
