package life.controller;

import life.model.GameOfLife;

public abstract class GameController {
    protected GameOfLife model;

    public abstract GameOfLife initNewModel();

    public abstract void jumpToGeneration();

    public abstract void nextGeneration();
}
