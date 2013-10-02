package com.andriod.games.Snake.framework.impl;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.andriod.games.Snake.framework.Input;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 01/10/2013
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class AndroidInput implements Input {
    AccelerometerHandler accelerometerHandler;
    KeyboardHandler keyHandler;
    TouchHandler touchHandler;

    public AndroidInput(Context context, View view, float scaleX, float scaleY) {
        accelerometerHandler = new AccelerometerHandler(context);
        keyHandler = new KeyboardHandler(view);
        if(Build.VERSION.SDK_INT < 5) {
            touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
        } else {
            touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
        }
    }

    @Override
    public  boolean isKeyPressed(int keyCode) {
        return keyHandler.isKeyPressed(keyCode);
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    @Override
    public float getAccelX() {
        return accelerometerHandler.getAccelX();
    }

    @Override
    public float getAccelY() {
        return  accelerometerHandler.getAccelY();
    }

    @Override
    public float getAccelZ() {
        return accelerometerHandler.getAccelZ();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }

    @Override
    public List<KeyEvent> getKeyEvents() {
        return keyHandler.getKeyEvents();
    }
}
