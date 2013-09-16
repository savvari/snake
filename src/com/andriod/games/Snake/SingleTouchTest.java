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
 * Date: 07/09/2013
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */
public class SingleTouchTest extends Activity implements View.OnTouchListener {
    TextView textView;
    StringBuilder builder = new StringBuilder();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setText("Touch and Drag(One finger only!)...");
        textView.setOnTouchListener(this);
        setContentView(textView);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN    :   builder.append("Down, ");
                                                break;

            case MotionEvent.ACTION_UP      :   builder.append("Up, ");
                                                break;

            case MotionEvent.ACTION_MOVE    :   builder.append("Move, ");
                                                break;

            case MotionEvent.ACTION_CANCEL  :   builder.append("Cancel, ");
                                                break;
        }

        builder.append(motionEvent.getX()).append(",").append(motionEvent.getY()).append("\n");
        Log.d("SingleTouchTest", builder.toString());

        textView.setText(builder);
        return true;
    }
}