package com.bdom.tools.utilitymethods

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import android.R.bool
import android.graphics.Matrix
import android.graphics.Paint


/*
 * Copyright (C) 2019 Oshan Madushanka
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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
