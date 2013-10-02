package com.andriod.games.Snake.game;

import com.andriod.games.Snake.framework.Screen;
import com.andriod.games.Snake.framework.impl.AndroidGame;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 22/09/2013
 * Time: 06:45
 * To change this template use File | Settings | File Templates.
 */
public class MrNomGame extends AndroidGame {
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}