package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)

        btnDatePicker.setOnClickListener { clickDatePicker() }
    }

    // datePicker 다이얼로그 창 띄우는 메서드
    private fun clickDatePicker() {
        // Calendar Object 생성 -> 현재 날짜의 달력을 가져옴
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR) // 연도
        val month = myCalendar.get(Calendar.MONTH) // 월
        val day = myCalendar.get(Calendar.DAY_OF_MONTH) // 날짜 => 7월 22일 처럼 출력

        // OnDateSetListener => DatePickerDialog "확인" 버튼 클릭 시 호출되는 메서드
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
            Toast.makeText(this, "DatePicker Work", Toast.LENGTH_SHORT).show()

        }, year, month, day ).show()

    }
}