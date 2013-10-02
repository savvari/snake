package com.andriod.games.Snake.framework;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 22/09/2013
 * Time: 21:19
 * To change this template use File | Settings | File Templates.
 */
public interface Music {
    void play();
    void stop();
    void pause();
    void setLooping(boolean looping);
    void setVolume(float volume);
    boolean isPlaying();
    boolean isStopped();
    boolean isLooping();
    void dispose();
}
