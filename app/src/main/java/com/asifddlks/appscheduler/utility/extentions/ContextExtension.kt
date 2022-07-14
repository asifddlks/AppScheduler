package com.asifddlks.appscheduler.utility.extentions

import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.asifddlks.appscheduler.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Created by
 * Asif Ahmed
 */

fun Context.showNotification(contentTitle:String, contentText:String) {
    val intent = Intent(this, MainActivity::class.java)
    val CHANNEL_ID = "APP_SCHEDULER"
    val notificationChannel =
        NotificationChannel(CHANNEL_ID, "App Scheduler", NotificationManager.IMPORTANCE_HIGH)

    var pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        PendingIntent.getService(this, 1, intent, PendingIntent.FLAG_MUTABLE)
    } else {
        PendingIntent.getService(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }
    val notification: Notification =
        NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(contentTitle)
            .setContentText(contentText)
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.sym_action_chat, "", pendingIntent)
            .setChannelId(CHANNEL_ID)
            .setSmallIcon(R.drawable.sym_action_chat)
            .build()

    val notificationManager = applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(notificationChannel)
    notificationManager.notify(1, notification)
}