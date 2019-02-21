package com.bdom.tools.utilitymethods

import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

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


object TextValidationUtils {


    /**
     * Check weather the given url is valid
     *
     * @param urlString The url to validate
     *
     * @return Boolean true if valid false if not valid
     */
    fun isValidURL(urlString: String): Boolean {
        return Patterns.WEB_URL.matcher(urlString).matches()
    }

    /**
     * Check weather the given email address is valid
     *
     *
     * @param emailString The email to validate
     *
     * @return Boolean true if valid false if not valid
     */
    fun isValidEmail(emailString: CharSequence): Boolean {
        return !TextUtils.isEmpty(emailString) && Patterns.EMAIL_ADDRESS.matcher(emailString).matches()
    }

    /**
     * Check weather the given phone Number is valid
     *
     * This pattern is intended for searching for things that look like they might be phone numbers in
     * arbitrary text, not for validating whether something is in fact a phone number. It will miss many
     * things that are legitimate phone numbers.
     *
     * Optionally, a + sign followed immediately by one or more digits. Spaces, dots, or dashes may follow.
     * Optionally, sets of digits in parentheses, separated by spaces, dots, or dashes.
     * A string starting and ending with a digit, containing digits, spaces, dots, and/or dashes.
     *
     * @param phoneNumber The phone number to validate
     *
     * @return Boolean true if valid false if not valid
     */
    fun isValidPhoneNumber(phoneNumber: CharSequence): Boolean {
        return android.util.Patterns.PHONE.matcher(phoneNumber).matches();
    }


    /**
     * Check weather the given EditText is empty
     *
     * @param editText The EditText to check empty
     *
     * @return Boolean true if empty, false if not empty
     */
    fun isEmpty(editText: EditText): Boolean {
        val input = editText.text.toString().trim { it <= ' ' }
        return input.isEmpty()
    }

    /**
     * Check weather the EditTexts in the given ViewGroup empty
     *
     * @param viewGroup The ViewGroup to check empty
     *
     * @return Boolean true if empty, false if not empty
     */
    fun isAllEditTextsEmpty(viewGroup: ViewGroup): Boolean {
        val focusables = viewGroup.getFocusables(View.FOCUS_DOWN)

        var isEmpty = false
        focusables.forEach {
            if (it is EditText)
                isEmpty = TextValidationUtils.isEmpty(it)
        }

        return isEmpty

    }

    /**
     * Reset a EditText to empty
     *
     * @param editText The EditText to reset
     *
     */
    fun resetToEmpty(editText: EditText?) {
        editText?.setText("")
    }


    /**
     * Check weather the given string contains digits only
     *
     * @param text The string to check digits
     *
     * @return Boolean true if digits only, false if not digits only
     */
    fun isDigitsOnly(text: String): Boolean {
        try {
            text.toDouble()
            return true
        } catch (ex: NumberFormatException) {
            return false
        }
    }


    /**
     * Check weather the given EdiText contains digits only
     *
     * @param editText The EdiText to check digits
     *
     * @return Boolean true if empty, false if not empty
     */
    fun isDigitsOnly(editText: EditText): Boolean {
        try {
            editText.text.toString().toDouble()
            return true
        } catch (ex: NumberFormatException) {
            return false
        }
    }


    /**
     * Check weather the given string contains Integer digits only
     *
     * @param text The string to check digits
     *
     * @return Boolean true if digits only, false if not digits only
     */
    fun isIntegerDigitsOnly(text: String): Boolean {
        try {
            text.toInt()
            return true
        } catch (ex: NumberFormatException) {
            return false
        }
    }


    /**
     * Check weather the given EdiText contains Integer digits only
     *
     * @param editText The EdiText to check digits
     *
     * @return Boolean true if empty, false if not empty
     */
    fun isIntegerDigitsOnly(editText: EditText): Boolean {
        try {
            editText.text.toString().toInt()
            return true
        } catch (ex: NumberFormatException) {
            return false
        }
    }



}