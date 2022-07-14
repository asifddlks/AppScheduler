package com.asifddlks.appscheduler.utility

//
// Created by Asif Ahmed on 13/7/22.
//

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import com.asifddlks.appscheduler.receivers.AlarmReceiver
import com.asifddlks.appscheduler.receivers.AlarmReceiver.Companion.ALARM_RUNNING


object MyAlarmManager {

    fun setAlarmByID(context: Context, alarmTime: Long, id: String) {
        val mScreenStateReceiver = AlarmReceiver()
        val screenStateFilter = IntentFilter()
        screenStateFilter.addAction("alarm.running")
        context.registerReceiver(mScreenStateReceiver, screenStateFilter)

        val alarmManager: AlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmTime, createPendingIntent(context,id))
    }

    fun cancelAlarmByID(context: Context, id:String) {
        createPendingIntent(context,id).let {
            val alarmManager: AlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(it)
        }
    }

    private fun createPendingIntent(context: Context, id:String):PendingIntent{

        val alarmIntent = Intent(context, AlarmReceiver::class.java)
        alarmIntent.action = ALARM_RUNNING
        alarmIntent.data = Uri.parse("alarmID://$id")

        var pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_MUTABLE)
        } else {
            PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        return pendingIntent
    }

}