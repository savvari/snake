package com.andriod.games.Snake.framework;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 22/09/2013
 * Time: 06:58
 * To change this template use File | Settings | File Templates.
 */
public interface Graphics {
    public static enum PixmapFormat {
        ARGB8888, ARGB4444, RGB567
    }

    Pixmap newPixmap(String fileName, PixmapFormat format);
    void clear(int color);
    void drawPixel(int x, int y, int color);
    void drawLine(int x, int y, int x2, int y2, int color);
    void drawRect(int x, int y, int width, int height, int color);
    void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight);
    void drawPixmap(Pixmap pixmap, int x, int y);
    int getWidth();
    int getHeight();
}
