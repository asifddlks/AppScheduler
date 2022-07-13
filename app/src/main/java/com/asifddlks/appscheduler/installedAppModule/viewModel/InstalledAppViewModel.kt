package com.asifddlks.appscheduler.installedAppModule.viewModel

import android.app.Application
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel
import com.asifddlks.appscheduler.installedAppModule.model.AppModel
import com.asifddlks.appscheduler.utility.PackageInfoUtility
import com.tvl.stockx.investingTabModule.contractor.InstalledAppViewInterface

//
// Created by Asif Ahmed on 13/7/22.
//

class InstalledAppViewModel(private val viewInterface: InstalledAppViewInterface) : ViewModel() {

    val appList:MutableList<AppModel> = ArrayList()

    fun loadData(packageManager: PackageManager) {
        appList.addAll(PackageInfoUtility(packageManager).getAllInstalledAppList())
        viewInterface.notifyView()
    }


}