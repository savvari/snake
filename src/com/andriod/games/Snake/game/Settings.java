package com.andriod.games.Snake.game;

import com.andriod.games.Snake.framework.FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 01/10/2013
 * Time: 12:13
 * To change this template use File | Settings | File Templates.
 */
public class Settings {
    public static boolean soundEnabled = true;
    public static int[] highscores = new int[] {-1, -1, -1, -1, -1};

    public static void load(FileIO files) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(files.readFile(".mrnom")));
            soundEnabled = Boolean.parseBoolean(in.readLine());
            for(int i = 0; i< 5; i++) {
                highscores[i]  = Integer.parseInt(in.readLine());
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(in != null) {
                    in.close();
                }
            } catch (Exception e){}
        }
    }

    public static void save(FileIO files) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(files.writeFile(".mrnom")));
            out.write(Boolean.toString(soundEnabled));
            out.write("\n");
            for(int i=0; i<5 ; i++) {
                out.write(Integer.toString(highscores[i]));
                out.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null) {
                    out.close();
                }
            } catch (Exception e) {}
        }
    }

    public static void addScore(int score) {
        for (int i = 0; i<5; i++) {
            if(highscores[i] < score) {
                for(int j=4; j>i; j--) {
                    highscores[j] = highscores[j-1];
                }
                highscores[i] = score;
                break;
            }
        }
    }

}
