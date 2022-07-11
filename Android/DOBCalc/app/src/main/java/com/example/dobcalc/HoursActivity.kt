package com.example.dobcalc

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class HoursActivity : AppCompatActivity() {

    private var tvHourSelectedDate: TextView? = null

    private var tvAgeInHours: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hours)

        tvHourSelectedDate = findViewById(R.id.tvHourSelectedDate)

        tvAgeInHours = findViewById(R.id.tvAgeInHours)

        val hourBtnDatePicker: Button = findViewById(R.id.hourBtnDatePicker)
        val btnMinutes: Button = findViewById(R.id.btnMinutes)
        btnMinutes.setOnClickListener { startActivity(
            Intent(this, MinutesActivity::class.java)
        ) }

        hourBtnDatePicker.setOnClickListener { clickDatePickerDialog() }
    }

    private fun clickDatePickerDialog() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val currentTime = System.currentTimeMillis()

        val dpb = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ _, selectedYear, selectedMonth, selectedDayOfMonth ->

            Toast.makeText(this,"$selectedYear/${selectedMonth + 1}/$selectedDayOfMonth", Toast.LENGTH_SHORT).show()

            val selectedDate = "$selectedYear/${selectedMonth + 1}/$selectedDayOfMonth"
            tvHourSelectedDate?.text = selectedDate

            val sdf = SimpleDateFormat("yyyy/MM/dd", Locale.KOREAN)

            val theDate = sdf.parse(selectedDate)

            theDate?.let {
                val selectedDateInHours = theDate.time / 3600000
                val currentDate = sdf.parse(sdf.format(currentTime))

                currentDate?.let {
                    val currentDateInHours = currentDate.time / 3600000

                    val differentInHours =  currentDateInHours - selectedDateInHours

                    tvAgeInHours?.text = "${ differentInHours.toString() } 시간"
                }
            }

        }, year, month, day)

        dpb.datePicker.maxDate = currentTime - 86400000
        dpb.show()

    }
}