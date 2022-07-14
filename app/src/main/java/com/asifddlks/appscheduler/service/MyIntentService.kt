package com.asifddlks.appscheduler.service

import android.app.IntentService
import android.content.Intent
import android.util.Log

//
// Created by Asif Ahmed on 13/7/22.
//

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        intent?.apply {
            when (intent.action) {
                ACTION_SEND_TEST_MESSAGE -> {
                    val message = getStringExtra(EXTRA_MESSAGE)
                    Log.d(this@MyIntentService.javaClass.simpleName,message.toString())
                }
            }
        }
    }

    companion object {
        const val ACTION_SEND_TEST_MESSAGE = "ACTION_SEND_TEST_MESSAGE"
        const val EXTRA_MESSAGE = "EXTRA_MESSAGE"
    }

}