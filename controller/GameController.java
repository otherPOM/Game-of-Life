package life.controller;

import life.model.GameModel;

public abstract class GameController {
    protected GameModel model;

    public abstract GameModel initNewModel();

    public abstract void jumpToGeneration();

    public abstract void nextGeneration();
}
