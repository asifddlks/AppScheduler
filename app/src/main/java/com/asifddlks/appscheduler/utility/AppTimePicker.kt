package com.asifddlks.appscheduler.utility

import android.app.TimePickerDialog
import android.content.Context
import android.widget.TimePicker
import java.util.*

class AppTimePicker(var context: Context,
                    var timePickerInterface: TimePickerInterface?,
                    var selectedTime: Calendar) : TimePickerDialog.OnTimeSetListener {


    fun showPicker(){
        val timePickerDialog = TimePickerDialog(
            context,
            this,
            selectedTime.get(Calendar.HOUR_OF_DAY),
            selectedTime.get(Calendar.MINUTE),
            false
        )
        //timePickerDialog. = Date().time
        timePickerDialog.show()
    }


    override fun onTimeSet(p0: TimePicker?, hour: Int, min: Int) {
        selectedTime.set(Calendar.HOUR_OF_DAY,hour)
        selectedTime.set(Calendar.MINUTE,min)
        timePickerInterface?.onTimeSelected(selectedTime)
    }

    interface TimePickerInterface {
        fun onTimeSelected(calendar: Calendar)
    }
}