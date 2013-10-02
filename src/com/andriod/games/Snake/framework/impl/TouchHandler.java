package com.andriod.games.Snake.framework.impl;

import android.view.View;
import com.andriod.games.Snake.framework.Input;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 01/10/2013
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
public interface TouchHandler extends View.OnTouchListener {
    boolean isTouchDown(int pointer);
    int getTouchX(int pointer);
    int getTouchY(int pointer);
    List<Input.TouchEvent> getTouchEvents();
}
