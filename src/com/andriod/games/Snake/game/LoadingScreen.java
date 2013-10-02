package com.andriod.games.Snake.game;

import com.andriod.games.Snake.framework.Game;
import com.andriod.games.Snake.framework.Graphics;
import com.andriod.games.Snake.framework.Screen;
import com.andriod.games.Snake.game.util.Assets;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 01/10/2013
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.png", Graphics.PixmapFormat.RGB567);
        Assets.logo = g.newPixmap("logo.png", Graphics.PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", Graphics.PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("buttons.png", Graphics.PixmapFormat.ARGB4444);
        Assets.help1 = g.newPixmap("help1.png", Graphics.PixmapFormat.ARGB4444);
        Assets.help2 = g.newPixmap("help2.png", Graphics.PixmapFormat.ARGB4444);
        Assets.help3 = g.newPixmap("help3.png", Graphics.PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", Graphics.PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", Graphics.PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pausemenu.png", Graphics.PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameover.png", Graphics.PixmapFormat.ARGB4444);
        Assets.headUp = g.newPixmap("headup.png", Graphics.PixmapFormat.ARGB4444);
        Assets.headLeft = g.newPixmap("headleft.png", Graphics.PixmapFormat.ARGB4444);
        Assets.headDown = g.newPixmap("headdown.png", Graphics.PixmapFormat.ARGB4444);
        Assets.headRight = g.newPixmap("headright.png", Graphics.PixmapFormat.ARGB4444);
        Assets.tail = g.newPixmap("tail.png", Graphics.PixmapFormat.ARGB4444);
        Assets.stain1 = g.newPixmap("stain1.png", Graphics.PixmapFormat.ARGB4444);
        Assets.stain2 = g.newPixmap("stain2.png", Graphics.PixmapFormat.ARGB4444);
        Assets.stain3 = g.newPixmap("stain3.png", Graphics.PixmapFormat.ARGB4444);
        Assets.click = game.getAudio().newSound("click.ogg");
        Assets.eat = game.getAudio().newSound("eat.ogg");
        Assets.bitten = game.getAudio().newSound("bitten.ogg");
        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
