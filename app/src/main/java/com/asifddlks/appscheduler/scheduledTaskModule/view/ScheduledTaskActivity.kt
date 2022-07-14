package com.asifddlks.appscheduler.scheduledTaskModule.view

import android.app.AlarmManager
import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.asifddlks.appscheduler.databinding.ActivityScheduledTaskBinding
import com.asifddlks.appscheduler.scheduledTaskModule.contractor.ScheduledTaskViewInterface
import com.asifddlks.appscheduler.scheduledTaskModule.viewModel.ScheduledTaskViewModel
import com.asifddlks.appscheduler.utility.*
import com.asifddlks.appscheduler.utility.extentions.showNotification
import java.util.*


class ScheduledTaskActivity : AppCompatActivity(), ScheduledTaskViewInterface {

    lateinit var binding: ActivityScheduledTaskBinding
    private val viewModel by viewModels<ScheduledTaskViewModel> { ViewModelFactory(this, application, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduledTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        showNotification("Hello","TVL")
    }

    private fun scheduleAlarm(id:String) {
        AppDatePicker(this, object : AppDatePicker.DateTimePickerInterface {
            override fun onDateTimeSelected(calendar: Calendar) {
                //val date : Date = calendar.time
                AppTimePicker(this@ScheduledTaskActivity, object : AppTimePicker.TimePickerInterface{
                    override fun onTimeSelected(calendar: Calendar) {
                        MyAlarmManager.setAlarmByID(applicationContext,calendar.timeInMillis,id)
                    }
                }, calendar).showPicker()
            }
        }).showDatePicker()
    }

    private fun initListeners() {
        binding.floatingActionAddButton.setOnClickListener {
            scheduleAlarm("test")
        }
    }

    override fun notifyView() {

    }
}