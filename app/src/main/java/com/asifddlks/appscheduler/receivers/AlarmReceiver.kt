package com.asifddlks.appscheduler.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.asifddlks.appscheduler.utility.extentions.showNotification

//
// Created by Asif Ahmed on 14/7/22.
//
class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            ALARM_RUNNING -> {
                Log.d(this@AlarmReceiver.javaClass.simpleName,intent.data.toString())
                //context.startActivity(Intent())
                context.showNotification("From Alarm Manager",intent.data.toString())
                Toast.makeText(context, "alarm ran", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val ALARM_RUNNING = "alarm.running"
    }
}