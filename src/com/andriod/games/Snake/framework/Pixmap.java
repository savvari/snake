package com.andriod.games.Snake.framework;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 22/09/2013
 * Time: 06:54
 * To change this template use File | Settings | File Templates.
 */
public interface Pixmap {
    int getWidth();
    int getHeight();
    Graphics.PixmapFormat getFormat();
    void dispose();
}
