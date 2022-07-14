package com.asifddlks.appscheduler.scheduledTaskModule.view

import android.R.attr.startYear
import android.app.AlarmManager
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.asifddlks.appscheduler.databinding.ActivityScheduledTaskBinding
import com.asifddlks.appscheduler.scheduledTaskModule.contractor.ScheduledTaskViewInterface
import com.asifddlks.appscheduler.scheduledTaskModule.viewModel.ScheduledTaskViewModel
import com.asifddlks.appscheduler.utility.*
import java.text.SimpleDateFormat
import java.util.*


class ScheduledTaskActivity : AppCompatActivity(), ScheduledTaskViewInterface {

    lateinit var binding: ActivityScheduledTaskBinding
    private val viewModel by viewModels<ScheduledTaskViewModel> { ViewModelFactory(this, application, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduledTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun testSchedule() {

        val timer = Timer()
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        AppDatePicker(this, object : AppDatePicker.DateTimePickerInterface {
            override fun onDateTimeSelected(calendar: Calendar) {
                //val date : Date = calendar.time
                AppTimePicker(this@ScheduledTaskActivity, object : AppTimePicker.TimePickerInterface{
                    override fun onTimeSelected(calendar: Calendar) {
                        //val date = calendar.time

                        MyAlarmManager.setAlarm(applicationContext,calendar.timeInMillis,"MyAlarmManager: ${calendar.time.toString()}")

                        /*

                        timer.schedule(AppTimerTask(this@ScheduledTaskActivity, object : AppTimerTask.AppTimerTaskInterface{
                            override fun timerTriggered() {

                            }
                        }), date)*/
                    }
                }, calendar).showPicker()
            }
        }).showDatePicker()
    }

    private fun initListeners() {
        binding.floatingActionAddButton.setOnClickListener {
            testSchedule()
        }
    }

    override fun notifyView() {

    }
}