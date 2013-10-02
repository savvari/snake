package com.andriod.games.Snake.framework.impl;

import android.content.res.AssetManager;
import android.os.Environment;
import com.andriod.games.Snake.framework.FileIO;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 27/09/2013
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */
public class AndroidFileIO implements FileIO {
    AssetManager assets;
    String externalStoragePath;

    public AndroidFileIO(AssetManager assets) {
        this.assets = assets;
        this.externalStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator;
    }

    @Override
    public InputStream readAsset(String fileName) throws IOException {
        return assets.open(fileName);
    }

    @Override
    public InputStream readFile(String fileName) throws IOException {
        return new FileInputStream(externalStoragePath + fileName);
    }

    @Override
    public OutputStream writeFile(String fileName) throws IOException {
        return new FileOutputStream(externalStoragePath + fileName);
    }
}
