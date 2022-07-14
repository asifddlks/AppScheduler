package com.asifddlks.appscheduler.utility

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import java.util.*

//
// Created by Asif Ahmed on 13/7/22.
//
class AppTimerTask(private val context: Context, private val appTimerTaskInterface: AppTimerTaskInterface) : TimerTask() {

    override fun run() {
        val activity = context as Activity
        activity.runOnUiThread {
            Log.d(this@AppTimerTask.javaClass.simpleName,"Timer triggered")
            Toast.makeText(context,"Timer triggered",Toast.LENGTH_SHORT).show()

            appTimerTaskInterface.timerTriggered()
        }

    }

    interface AppTimerTaskInterface{
        fun timerTriggered()

    }
}

