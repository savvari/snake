package com.andriod.games.Snake;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 15/09/2013
 * Time: 06:12
 * To change this template use File | Settings | File Templates.
 */
public class AccelerometerTest extends Activity implements SensorEventListener {

    TextView textView;
    StringBuilder builder = new StringBuilder();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        setContentView(textView);

        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() == 0) {
            textView.setText("No accelerometer installed.");
        } else {
            Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            if(!manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME)) {
                textView.setText("Error registering listener.");
            }
        }
    }

    public void onSensorChanged(SensorEvent event) {
        builder.setLength(0);
        builder.append("x: ")
                .append(event.values[0])
                .append(", y: ")
                .append(event.values[1])
                .append(" z: ")
                .append(event.values[2]);

        textView.setText(builder);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
