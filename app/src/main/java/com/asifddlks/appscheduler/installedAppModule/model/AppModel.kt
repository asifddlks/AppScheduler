package com.asifddlks.appscheduler.installedAppModule.model

import android.content.Intent
import android.graphics.drawable.Drawable

//
// Created by Asif Ahmed on 13/7/22.
//
data class AppModel(val appName:String, val packageName:String, val versionName:String,val appIcon:Drawable, val launcherIntent:Intent?)
