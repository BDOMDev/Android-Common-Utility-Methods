package com.bdom.tools.utilitymethods

import android.graphics.Color
import kotlin.random.Random


/**
 * Created by Oshan on 2/20/19.
 * Azbow Pvt. Ltd.
 */

object ColorUtils {


    val randomColor : Int
        get() = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))



}