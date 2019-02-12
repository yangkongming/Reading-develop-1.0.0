package com.hankkin.reading.utils

import android.content.Context

/**
 * Created by wenxin on 2018/11/17.
 */
object WeatherUtils {

    fun getWeatherImg(code: String?, context: Context?): Int {
        val rescoure = context!!.resources
        return rescoure.getIdentifier("w" + code, "mipmap", context.packageName)
    }

}