package com.bdom.tools.utilitymethods

import android.content.Context
import android.graphics.Color
import kotlin.random.Random
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.widget.ImageView


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

object ColorUtils {


    /**
     * Returns a random color value
     *
     *
     * @return Int Color value
     */
    val randomColor : Int
        get() = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))


    /**
     * Checks whether the color has alpha component.
     *
     * @param color The color to check the alpha component.
     *
     * @return {@code true} if the color has alpha component.
     */
    fun hasAlpha(@ColorInt color: Int): Boolean {
        return Color.alpha(color) != 255
    }


    /**
     * apply dark element to a given color
     *
     * @param color The color to darken.
     * @param amount The amount to darken the color. (0 - unchanged, 1 - completely dark)
     *
     * @return Int The darker color.
     */
    @ColorInt
    fun getDarkerColor(@ColorInt color: Int, amount: Float): Int {
        val red = (Color.red(color) * (1 - amount) / 255 * 255).toInt()
        val green = (Color.green(color) * (1 - amount) / 255 * 255).toInt()
        val blue = (Color.blue(color) * (1 - amount) / 255 * 255).toInt()

        return Color.argb(Color.alpha(color), red, green, blue)
    }

    /**
     * Get hexadecimal string from the color integer.
     *
     * @param color The color to get the hex code.
     * @param includeAlpha {@code true} to include alpha in the string.
     *
     * @return The hexadecimal string of the given color integer.
     */
    fun getColorString(@ColorInt color: Int, includeAlpha: Boolean): String {
        val colorString: String
        if (includeAlpha)
            colorString = String.format("%08X", color)
        else
            colorString = String.format("%06X", 0xFFFFFF and color)

        return "#$colorString"
    }

    /**
     * set a color filter to imageView
     *
     * @param context The appication context
     * @param imageView imageView to set the color filter
     * @param color color resource int
     *
     */
    fun setTintColorToImageView(context: Context, imageView: ImageView, @ColorRes color: Int) {
        imageView.setColorFilter(ContextCompat.getColor(context, color), android.graphics.PorterDuff.Mode.MULTIPLY);
    }

}