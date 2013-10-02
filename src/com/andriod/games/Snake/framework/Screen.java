package com.andriod.games.Snake.framework;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 22/09/2013
 * Time: 07:04
 * To change this template use File | Settings | File Templates.
 */
public abstract class Screen {
    protected final Game game;
    public Screen(Game game) {
        this.game = game;
    }

    public abstract void update(float deltaTime);
    public abstract void present(float deltaTime);
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();
}
