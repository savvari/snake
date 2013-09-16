package com.andriod.games.Snake;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 14/09/2013
 * Time: 05:19
 * To change this template use File | Settings | File Templates.
 */
public class MultiTouchTest extends Activity implements View.OnTouchListener {
    TextView textView;
    int x[] = new int[10];
    int y[] = new int[10];
    int id[] = new int[10];
    boolean touched[] = new boolean[10];
    StringBuilder builder = new StringBuilder();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = new TextView(this);
        textView.setText("Touch and drag (multiple fingers supported)!");
        textView.setOnTouchListener(this);

        setContentView(textView);

        for(int i=0; i<10; i++) {
            id[i] = -1;
        }

        updateTextView();
    }

    private void updateTextView() {
        builder.setLength(0);

        for(int i=0; i<10; i++) {
            builder.append(touched[i])
                    .append(", ")
                    .append(x[i])
                    .append(", ")
                    .append("y[i]")
                    .append(", ")
                    .append(id[i])
                    .append("\n");
        }
        textView.setText(builder);
    }

    public boolean onTouch(View v, MotionEvent event) {
        int pointerIndex = event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        int action = event.getAction() & MotionEvent.ACTION_MASK;
        int pointerCount = event.getPointerCount();

        for(int i=0; i<10; i++) {
            if(i>=pointerCount) {
                touched[i] = false;
                x[i] = -1;
                y[i] = -1;
                id[i] = -1;
                continue;
            }

            if(action != MotionEvent.ACTION_MOVE && i != pointerIndex) {
                continue;
            }

            int pointerId = event.getPointerId(i);
            Log.e("MultiTouchTest", String.format("[i, pointerCount, pointerId, pointerIndex, action]:[%s, %s, %s, %s, %s]", i, pointerCount, pointerId, pointerIndex, action));

            switch (action) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_POINTER_DOWN:
                    touched[i] = true;
                    x[i] = (int) event.getX(i);
                    y[i] = (int) event.getY(i);
                    id[i] = pointerId;
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_POINTER_UP:
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_OUTSIDE:
                    touched[i] = false;
                    id[i] = -1;
                    x[i] = (int) event.getX(i);
                    y[i] = (int) event.getY(i);
                    break;
                case MotionEvent.ACTION_MOVE:
                    touched[i] = true;
                    id[i] = pointerId;
                    x[i] = (int) event.getX(i);
                    y[i] = (int) event.getY(i);
                    break;

            }
        }

        updateTextView();
        return true;
    }
}