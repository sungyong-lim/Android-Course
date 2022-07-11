package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    // TextView 변수를 "nullable"로 만든 이유는 지금 초기화 하지 않을 거지만 나중에 변수를 부여할 수 있기 때문임
    // 접근 제한자를 "private"로 만들어놔야 나중에 다른 클래스에서 사용할 수 없음
    private var tvSelectedDate : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)

        btnDatePicker.setOnClickListener { clickDatePicker() }
    }

    // datePicker 다이얼로그 창 띄우는 메서드
    private fun clickDatePicker() {
        // Calendar Object 생성 -> 현재 날짜의 달력을 가져옴
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR) // 연도
        val month = myCalendar.get(Calendar.MONTH) // 월
        val day = myCalendar.get(Calendar.DAY_OF_MONTH) // 날짜 => 22일 처럼 출력

        // OnDateSetListener => DatePickerDialog "확인" 버튼 클릭 시 호출되는 메서드
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
            Toast.makeText(this, "$selectedYear-${selectedMonth + 1}-$selectedDayOfMonth", Toast.LENGTH_SHORT).show()

            // DatePickerDialog에서 선택한 날짜를 "selectedDate" 변수에 할당
            val selectedDate = "$selectedYear/${selectedMonth+1}/$selectedDayOfMonth"
            // "tvSelectedDate"에 "text"에 "selectedDate"를 할당
            tvSelectedDate?.text = selectedDate
            
            // "SimpleDateFormat"은 날짜에 사용할 패턴을 정의해줌
            // 패턴 "dd/MM/yyyy", 달력 언어 설정 "Locale.KOREA"
            val sdf = SimpleDateFormat("yyyy/MM/dd", Locale.KOREA)

            // 문자열 "selectedDate"를 파싱
            // pasre = 형변환에 사용됨
            val theDate = sdf.parse(selectedDate)
            println("theDate $theDate")

            // 날짜를 기준으로 분 단위로 계산


        }, year, month, day ).show()

    }
}