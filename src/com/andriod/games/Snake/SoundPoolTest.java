package com.andriod.games.Snake;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 15/09/2013
 * Time: 07:38
 * To change this template use File | Settings | File Templates.
 */
public class SoundPoolTest extends Activity implements View.OnTouchListener {
    TextView textView;
    SoundPool soundPool;
    int explosionId = -1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setOnTouchListener(this);
        setContentView(textView);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
        AssetManager assetManager = getAssets();
        try {
            AssetFileDescriptor fD = assetManager.openFd("sounds/explosion.ogg");
            explosionId = soundPool.load(fD, 1);
        } catch (IOException e) {
            textView.setText("Error getting sound file.");
        }
    }

    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP) {
           if(explosionId != -1) {
               soundPool.play(explosionId, 1, 1, 0, 0, 1);
           }
        }
        return true;
    }
}