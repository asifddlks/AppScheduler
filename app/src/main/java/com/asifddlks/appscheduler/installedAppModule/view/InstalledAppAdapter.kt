package com.asifddlks.appscheduler.installedAppModule.view

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asifddlks.appscheduler.databinding.ItemInstalledAppBinding
import com.asifddlks.appscheduler.installedAppModule.model.AppModel

//
// Created by Asif Ahmed on 13/7/22.
//

class InstalledAppAdapter(
    private val dataList: List<AppModel>,
    private val itemInterface: ItemInterface
) :
    RecyclerView.Adapter<InstalledAppAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val binding = ItemInstalledAppBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.textViewAppName.text = dataList[position].appName
        holder.binding.textViewPackageName.text = dataList[position].packageName
        holder.binding.textViewVersionName.text = dataList[position].versionName
        holder.binding.imageViewAppIcon.setImageDrawable(dataList[position].appIcon)

        holder.itemView.setOnClickListener {
            itemInterface.onItemClick(dataList[position].launcherIntent)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return dataList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(val binding: ItemInstalledAppBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface ItemInterface {
        fun onItemClick(launcherIntent:Intent?)
    }
}