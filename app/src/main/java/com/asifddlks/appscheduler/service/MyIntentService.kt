package com.asifddlks.appscheduler.service

import android.app.Activity
import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.asifddlks.appscheduler.utility.extentions.showNotification

//
// Created by Asif Ahmed on 13/7/22.
//

class MyIntentService : IntentService("MyIntentService") {

    val context = this

    override fun onHandleIntent(intent: Intent?) {
        intent?.apply {
            when (intent.action) {
                ACTION_SEND -> {
                    //data
                    //val message = getStringExtra(EXTRA_MESSAGE)
                    Log.d(this@MyIntentService.javaClass.simpleName,data.toString())
                    //context.startActivity(Intent())
                    context.showNotification("From Alarm Manager",data.toString())
                }
            }
        }
    }

    companion object {
        const val ACTION_SEND = "ACTION_SEND"
        const val EXTRA_MESSAGE = "EXTRA_MESSAGE"
    }

}