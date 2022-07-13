package com.asifddlks.appscheduler.installedAppModule.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.asifddlks.appscheduler.databinding.ActivityInstalledAppBinding
import com.asifddlks.appscheduler.installedAppModule.viewModel.InstalledAppViewModel
import com.asifddlks.appscheduler.utility.ViewModelFactory
import com.tvl.stockx.investingTabModule.contractor.InstalledAppViewInterface

class InstalledAppActivity : AppCompatActivity(),InstalledAppViewInterface {

    private lateinit var binding: ActivityInstalledAppBinding
    private val viewModel by viewModels<InstalledAppViewModel> { ViewModelFactory(this, application, this) }
    private lateinit var installedAppAdapter:InstalledAppAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstalledAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        viewModel.loadData(packageManager)
    }

    private fun initRecyclerView() {
        installedAppAdapter = InstalledAppAdapter(viewModel.appList,object :
            InstalledAppAdapter.ItemInterface{
            override fun onItemClick(launcherIntent: Intent?) {
                launcherIntent?.let {
                    startActivity(it)
                }
            }
        })
        //PackageInfoUtility(packageManager).getAllInstalledAppList()
        binding.recyclerView.adapter = installedAppAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun notifyView() {
        installedAppAdapter.notifyDataSetChanged()
    }
}