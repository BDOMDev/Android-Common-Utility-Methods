package com.bdom.tools.utilitymethods;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by Oshan on 2/14/19.
 * Azbow Pvt. Ltd.
 */
public class BitmapUtils {

    /**
     * Apply monochrome color filter on the supplied bitmap.
     *
     * @param view The view to get bitmap from
     * @param width Width of the required bitmap
     * @param height Height of the required bitmap
     *
     * @return The new bitmap representing the view
     */
    public static Bitmap loadBitmapFromView(View view, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width , height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        view.layout(0, 0, view.getLayoutParams().width, view.getLayoutParams().height);
        view.draw(c);
        return b;
    }





}
