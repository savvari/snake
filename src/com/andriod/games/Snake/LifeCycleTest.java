package com.andriod.games.Snake;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 07/09/2013
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 */
public class LifeCycleTest extends Activity {
    StringBuilder builder = new StringBuilder();
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = new TextView(this);
        textView.setText(builder);
        setContentView(textView);
    }

    private void log(String message) {
        Log.d("LifeCycleTest", message);
        builder.append(message);
        builder.append("/n");
        textView.setText(builder);
    }

    @Override
    public void onResume() {
        super.onResume();
        log("Resumed");
    }

    @Override
    public void onPause() {
        super.onPause();
        log("Paused");

        if(isFinishing()) {
            log("Finishing");
        }
    }
}