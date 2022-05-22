package com.jaycola99.book

import android.app.Activity

object ActivityCollector {
    private val activities = ArrayList<Activity>()

    //添加activity
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    //删除activity
    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    //关闭所有activity
    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }
}