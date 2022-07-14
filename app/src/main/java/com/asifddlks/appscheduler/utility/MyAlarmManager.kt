package com.asifddlks.appscheduler.utility

//
// Created by Asif Ahmed on 13/7/22.
//
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import com.asifddlks.appscheduler.service.MyIntentService

object MyAlarmManager {

    fun setAlarmByID(context: Context, alarmTime: Long, id: String) {
        val alarmManager: AlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime, createPendingIntent(context,id))
    }

    fun cancelAlarmByID(context: Context, id:String) {
        createPendingIntent(context,id).let {
            val alarmManager: AlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(it)
        }
    }

    private fun createPendingIntent(context: Context, id:String):PendingIntent{
        val alarmIntent = Intent(context, MyIntentService::class.java)
        alarmIntent.action = MyIntentService.ACTION_SEND
        //intent.putExtra(MyIntentService.EXTRA_MESSAGE, message)
        alarmIntent.data = Uri.parse("alarmID://$id")

        //pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        var pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.getService(context, 0, alarmIntent, PendingIntent.FLAG_MUTABLE)
        } else {
            PendingIntent.getService(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        return pendingIntent
    }

}