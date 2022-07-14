package com.asifddlks.appscheduler.utility

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.asifddlks.appscheduler.R
import com.asifddlks.appscheduler.installedAppModule.model.AppModel
import com.asifddlks.appscheduler.installedAppModule.view.InstalledAppAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog


//
// Created by Asif Ahmed on 13/7/22.
//
class CustomBottomSheetDialog(val context: Context) {

    fun showInstalledApp(interactor: InstalledAppInterface) {
        val dialog = BottomSheetDialog(context)

        // on below line we are inflating a layout file which we have created.
        val view = LayoutInflater.from(context).inflate(R.layout.layout_bottom_sheet_installed_app, null)

        dialog.setContentView(view)

        // on below line we are creating a variable for our button
        // which we are using to dismiss our dialog.
        val buttonDismiss = view.findViewById<Button>(R.id.buttonDismiss)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        buttonDismiss.setOnClickListener {
            dialog.dismiss()
        }

        val appList:MutableList<AppModel> = ArrayList()
        appList.addAll(PackageInfoUtility(context.packageManager).getAllInstalledAppList())

        val installedAppAdapter = InstalledAppAdapter(appList,object :
            InstalledAppAdapter.ItemInterface{
            override fun onItemClick(appModel: AppModel) {
                interactor.onItemClick(appModel)
                dialog.dismiss()
            }
        })
        recyclerView.adapter = installedAppAdapter

        dialog.setCancelable(true)
        dialog.show()
    }

    interface InstalledAppInterface{
        fun onItemClick(appModel: AppModel)
    }

}