package com.andriod.games.Snake.framework;

import android.provider.MediaStore;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 22/09/2013
 * Time: 07:06
 * To change this template use File | Settings | File Templates.
 */
public interface Game {
    Input getInput();
    FileIO getFileIO();
    Graphics getGraphics();
    Audio getAudio();
    void setScreen(Screen screen);
    Screen getCurrentScreen();
    Screen getStartScreen();
}
