package life.controller;

import life.model.GameModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleGameController extends GameController {
    private final Scanner scan;

    public ConsoleGameController() {
        scan = new Scanner(System.in);
    }

    @Override
    public GameModel initNewModel() {
        try {
            var n = scan.nextInt();
            model = new GameModel(n);
            return model;
        } catch (InputMismatchException e) {
            System.out.println("Wrong input, try again");
            return initNewModel();
        }
    }

    @Override
    public void jumpToGeneration() {
        try {
            var m = scan.nextInt();
            model.jumpToGeneration(m);
        } catch (InputMismatchException e) {
            System.out.println("Wrong input, try again");
            jumpToGeneration();
        }
    }

    @Override
    public void nextGeneration() {
        model.nextGeneration();
    }
}
