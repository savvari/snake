package com.andriod.games.Snake;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 15/09/2013
 * Time: 06:43
 * To change this template use File | Settings | File Templates.
 */
public class AssetsTest extends Activity {
    TextView textView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = new TextView(this);
        setContentView(textView);

        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open("texts/myawesometext.txt");
            textView.setText(loadTextFile(inputStream));
        } catch (IOException e) {
            textView.setText("Error openning file.");
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    textView.setText("Error closing file.");
                }
            }
        }
    }

    private String loadTextFile(InputStream inputStream) throws IOException {
        StringBuilder text = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while((line = reader.readLine()) != null) {
            text.append(line);
        }

        return text.toString();
    }
}