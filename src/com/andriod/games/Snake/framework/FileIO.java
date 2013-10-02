package com.andriod.games.Snake.framework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 22/09/2013
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public interface FileIO {
    InputStream readAsset(String fileName) throws IOException;
    InputStream readFile(String fileName) throws IOException;
    OutputStream writeFile(String fileName) throws IOException;
}
