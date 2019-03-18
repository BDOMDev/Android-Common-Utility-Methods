package com.bdom.tools.utilitymethods

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.util.Log
import android.telephony.TelephonyManager
import android.net.Network
import android.os.Build
import android.support.v4.content.ContextCompat.getSystemService






/**
 * Created by Oshan on 2/22/19.
 * Azbow Pvt. Ltd.
 */

object NetworkUtils {


    /**
     * Get the network info
     *
     * android.permission.ACCESS_NETWORK_STATE permission required
     *
     * @param context to get NetworkInfo
     *
     * @return {@link NetworkInfo}
     */
    @SuppressLint("MissingPermission")
    fun getNetworkInfo(context: Context): NetworkInfo? {
        try {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm.activeNetworkInfo
        } catch (e: Exception) {
            Log.v("connectivity", e.toString())
            return null
        }
    }

    /**
     * Check if the device is connected to a network
     *
     * @param context
     *
     * @return Boolean
     */
    fun isConnected(context: Context): Boolean {
        val info = getNetworkInfo(context)
        return info != null && info.isConnectedOrConnecting
    }


    /**
     * Check if there is any connection to a Wifi network
     *
     * @param context
     *
     * @return Boolean
     */
    fun isConnectedToWifi(context: Context): Boolean {
        val info = getNetworkInfo(context)
        return info != null && info.isConnected && info.type == ConnectivityManager.TYPE_WIFI
    }


    /**
     * Check if there is any connection to a mobile network
     *
     * @param context
     *
     * @return Boolean
     */
    fun isConnectedToMobile(context: Context): Boolean {
        val info = getNetworkInfo(context)
        return info != null && info.isConnected && info.type == ConnectivityManager.TYPE_MOBILE
    }


}