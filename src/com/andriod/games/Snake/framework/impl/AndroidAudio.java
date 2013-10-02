package com.andriod.games.Snake.framework.impl;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import com.andriod.games.Snake.framework.Audio;
import com.andriod.games.Snake.framework.Music;
import com.andriod.games.Snake.framework.Sound;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 27/09/2013
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public class AndroidAudio implements Audio {
    AssetManager assets;
    SoundPool soundPool;

    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    @Override
    public Music newMusic(String filename) {
        try {
            AssetFileDescriptor assetFileDescriptor = assets.openFd(filename);
            return new AndroidMusic(assetFileDescriptor);
        } catch(IOException e) {
            throw new RuntimeException("Error loading music file");
        }
    }

    @Override
    public Sound newSound(String fileName) {
        try {
            AssetFileDescriptor assetFileDescriptor = assets.openFd(fileName);
            int soundId = soundPool.load(assetFileDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("");
        }
    }
}
