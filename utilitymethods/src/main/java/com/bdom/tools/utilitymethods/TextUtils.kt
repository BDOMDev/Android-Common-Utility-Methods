package com.bdom.tools.utilitymethods

import android.os.Build
import android.text.Html
import android.text.Spanned


/**
 * Created by Oshan on 2/20/19.
 * Azbow Pvt. Ltd.
 */

object TextUtils {


    /**
     * Converts html string to a Spanned
     *
     * @param htmlString html content string
     *
     * @return A spanned sting from htmlString
     */
    fun fromHtml(htmlString: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(htmlString, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(htmlString)
        }
    }

}