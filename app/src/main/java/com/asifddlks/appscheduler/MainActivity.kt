package com.asifddlks.appscheduler

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asifddlks.appscheduler.installedAppModule.view.InstalledAppActivity
import com.asifddlks.appscheduler.databinding.ActivityMainBinding
import com.asifddlks.appscheduler.scheduledTaskModule.view.ScheduledTaskActivity


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //startActivity(Intent(this,InstalledAppActivity::class.java))
        startActivity(Intent(this,ScheduledTaskActivity::class.java))
        finish()
    }
}