package com.andriod.games.Snake.framework.impl;

import android.content.res.AssetManager;
import android.graphics.*;
import com.andriod.games.Snake.framework.Graphics;
import com.andriod.games.Snake.framework.Pixmap;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: sridharavvari
 * Date: 27/09/2013
 * Time: 08:48
 * To change this template use File | Settings | File Templates.
 */
public class AndriodGraphics implements Graphics {
    AssetManager assets;
    Bitmap frameBuffer;
    Canvas canvas;
    Paint paint;
    Rect srcRect = new Rect();
    Rect dstRect = new Rect();

    public AndriodGraphics(AssetManager assets, Bitmap frameBuffer) {
        this.assets = assets;
        this.frameBuffer = frameBuffer;
        this.canvas = new Canvas(frameBuffer);
        this.paint = new Paint();
    }

    @Override
    public Pixmap newPixmap(String fileName, PixmapFormat format) {
        Bitmap.Config config = null;
        if(format == PixmapFormat.RGB567) {
            config = Bitmap.Config.RGB_565;
        } else if(format == PixmapFormat.ARGB4444) {
            config  = Bitmap.Config.ARGB_4444;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = config;

        InputStream in = null;
        Bitmap bitmap = null;
        try {
            in = assets.open(fileName);
            bitmap = BitmapFactory.decodeStream(in, null, options);
            if(bitmap==null) {
                throw new RuntimeException("error loading: ");
            }
        } catch(IOException e) {
            throw new RuntimeException("Could not load");
        } finally {
            if(in != null) {
                try{in.close();}catch(IOException e) {}
            }
        }

        if(bitmap.getConfig() == Bitmap.Config.RGB_565) {
            format = PixmapFormat.RGB567;
        } else if(bitmap.getConfig() == Bitmap.Config.ARGB_4444) {
            format = PixmapFormat.ARGB4444;
        } else {
            format = PixmapFormat.ARGB8888;
        }

        return new AndroidPixmap(bitmap, format);
    }

    @Override
    public void clear(int color) {
        canvas.drawRGB((color & 0xff0000)>>16, (color & 0xff00) >>8, (color & 0xff));
    }

    @Override
    public void drawPixel(int x, int y, int color) {
        paint.setColor(color);
        canvas.drawPoint(x, y, paint);
    }

    @Override
    public void drawLine(int x, int y, int x2, int y2, int color) {
        paint.setColor(color);
        canvas.drawLine(x, y, x2, y2, paint);
    }

    @Override
    public void drawRect(int x, int y, int width, int height, int color) {
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x, y, x+width-1, y+width-1, paint);
    }

    @Override
    public void drawPixmap(Pixmap pixmap, int x, int y , int srcX, int srcY,
                           int srcWidth, int srcHeight) {
        srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth - 1;
        srcRect.bottom = srcY + srcHeight - 1;

        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + srcWidth - 1;
        dstRect.bottom = y + srcHeight - 1;

        canvas.drawBitmap(((AndroidPixmap)pixmap).bitmap, srcRect, dstRect, null);
    }

    @Override
    public void drawPixmap(Pixmap pixmap, int x, int y) {
        canvas.drawBitmap(((AndroidPixmap)pixmap).bitmap, x, y, null);
    }

    @Override
    public int getWidth() {
        return frameBuffer.getWidth();
    }

    @Override
    public int getHeight() {
        return frameBuffer.getHeight();
    }
}
