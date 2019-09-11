package com.bdom.tools.utilitymethods

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import java.lang.NullPointerException


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

object KeyboardUtils {

    /**
     * Hides the soft keyboard
     *
     * @param activity activity reference of the current activity
     *
     */
    fun hideKeyboard(activity: Activity) {
        try {
            val view = activity.currentFocus
            val methodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            assert(view != null)
            methodManager.hideSoftInputFromWindow(view!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        } catch(e: NullPointerException){
            e.printStackTrace()
        }
    }

    /**
     * Shows the soft keyboard from activity
     *
     * @param activity activity reference of the current activity
     *
     **/
    fun showKeyboardFromActivity(activity: Activity) {
        val view = activity.currentFocus
        val methodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        assert(view != null)
        methodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    /**
     * Shows the soft keyboard from fragment
     *
     * @param context context reference of the parent activity of fragment
     *
     **/
    fun showKeyboardFromFragment(context: Context) {
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

}