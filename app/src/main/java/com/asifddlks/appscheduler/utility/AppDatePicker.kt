package com.asifddlks.appscheduler.utility

import android.app.DatePickerDialog
import android.content.Context
import com.asifddlks.appscheduler.R
import java.util.*

class AppDatePicker(var context: Context, var dateInterface : DateTimePickerInterface?) :

DatePickerDialog.OnDateSetListener {

    private val selectedDate: Calendar = Calendar.getInstance()
    fun showDatePicker(){
        val datePickerDialog = DatePickerDialog(
            context,
            this,
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.minDate = Date().time
        datePickerDialog.show()
    }
    override fun onDateSet(p0: android.widget.DatePicker?, year: Int, month: Int, day: Int) {
        selectedDate.set(Calendar.YEAR,year)
        selectedDate.set(Calendar.MONTH,month)
        selectedDate.set(Calendar.DAY_OF_MONTH,day)
        dateInterface?.onDateTimeSelected(selectedDate)
    }


    interface DateTimePickerInterface {
        fun onDateTimeSelected(calendar: Calendar)
    }

}