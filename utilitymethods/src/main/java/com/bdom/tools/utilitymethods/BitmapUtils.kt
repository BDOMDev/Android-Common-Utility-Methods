package com.bdom.tools.utilitymethods

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import android.R.bool
import android.graphics.Matrix
import android.graphics.Paint


/**
 * Created by Oshan on 2/14/19.
 * Azbow Pvt. Ltd.
 */
object BitmapUtils {

    /**
     * Apply monochrome color filter on the supplied bitmap.
     *
     * @param view The view to get bitmap from
     * @param width Width of the required bitmap
     * @param height Height of the required bitmap
     *
     * @return The new bitmap representing the view
     */
    fun loadBitmapFromView(view: View, width: Int, height: Int): Bitmap {
        val b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val c = Canvas(b)
        view.layout(0, 0, view.layoutParams.width, view.layoutParams.height)
        view.draw(c)
        return b
    }

    /**
     * Scale down a bitmap from the existing bitmap when possible
     *
     * @param originalBitmap Original bitmap that needs to be scaled down
     * @param maxImageSize maz size of the bitmap
     * @param filter should the bitmap be filtered
     *
     * @return Bitmap - Scaled down bitmap
     */
    fun scaleDownBitmap(originalBitmap: Bitmap, maxImageSize: Float, filter: Boolean): Bitmap {
        val ratio = Math.min(maxImageSize / originalBitmap.width, maxImageSize / originalBitmap.height)
        val width = Math.round(ratio * originalBitmap.width)
        val height = Math.round(ratio * originalBitmap.height)

        return Bitmap.createScaledBitmap(originalBitmap, width, height, filter)
    }


    /**
     * Scale a bitmap from the existing bitmap when possible
     *
     * @param originalBitmap Original bitmap that needs to be scaled
     * @param desiredWidth width of the desired bitmap
     * @param desiredHeight height of the desired bitmap
     *
     * @return Bitmap - Scaled bitmap
     */
    fun scaleBitmap(originalBitmap: Bitmap, desiredWidth: Int, desiredHeight: Int): Bitmap {
        val output = Bitmap.createBitmap(desiredWidth, desiredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val m = Matrix()
        m.setScale(desiredWidth.toFloat() / originalBitmap.width, desiredHeight.toFloat() / originalBitmap.height)
        canvas.drawBitmap(originalBitmap, m, Paint())
        return output
    }


}
