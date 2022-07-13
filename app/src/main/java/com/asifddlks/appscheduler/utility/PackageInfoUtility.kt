package com.asifddlks.appscheduler.utility

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.util.Log
import com.asifddlks.appscheduler.installedAppModule.model.AppModel


//
// Created by Asif Ahmed on 13/7/22.
//
class PackageInfoUtility(private val packageManager: PackageManager) {

    fun getAllInstalledAppList(): ArrayList<AppModel>{
        val appList = ArrayList<AppModel>()

        val packages = packageManager.getInstalledPackages(PackageManager.GET_META_DATA)

        for (packageInfo in packages)
        {
            if (!isSystemPackage(packageInfo.applicationInfo)) {
                val appName = packageInfo.applicationInfo.loadLabel(packageManager).toString()
                val packageName = packageInfo.applicationInfo.packageName
                val versionName = packageInfo.versionName
                val icon: Drawable = packageInfo.applicationInfo.loadIcon(packageManager)
                val launchIntent = packageManager.getLaunchIntentForPackage(packageInfo.packageName)

                Log.d(this@PackageInfoUtility.javaClass.simpleName, "App Name:$appName")
                Log.d(this@PackageInfoUtility.javaClass.simpleName, "App Icon:$icon")
                Log.d(this@PackageInfoUtility.javaClass.simpleName, "packageName :$packageName")
                Log.d(this@PackageInfoUtility.javaClass.simpleName, "versionName :$versionName")
                Log.d(this@PackageInfoUtility.javaClass.simpleName, "Source dir : " + packageInfo.applicationInfo.sourceDir)
                Log.d(this@PackageInfoUtility.javaClass.simpleName, "Launch Activity :" + packageManager.getLaunchIntentForPackage(packageInfo.packageName))
                Log.d(this@PackageInfoUtility.javaClass.simpleName, "isSystemPackage :" + isSystemPackage(packageInfo.applicationInfo))

                appList.add(AppModel(appName, packageName, versionName, icon, launchIntent))
            }
        }
        return appList
    }

    private fun isSystemPackage(pkgInfo: ApplicationInfo): Boolean {
        return pkgInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0
    }
}



