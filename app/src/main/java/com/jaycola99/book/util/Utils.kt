package com.jaycola99.book.util

import android.content.Context

object Utils {
    fun dip2px(context: Context, dpValue: Float): Int {
        // 获取当前手机的像素密度
        val scale: Float = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt() // 四舍五入取整
    }

    // 根据手机的分辨率从 px(像素) 的单位 转成为 dp
    fun px2dip(context: Context, pxValue: Float): Int {
        // 获取当前手机的像素密度
        val scale: Float = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt() // 四舍五入取整
    }
}