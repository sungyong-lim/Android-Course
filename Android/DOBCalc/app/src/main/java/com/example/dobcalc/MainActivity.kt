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
    
    // 분 단위로 계산한 값을 표시할 변수 생성
    private var tvAgeInMinutes: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)

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
       val dpb = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
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

           // null 안정성
           // "Date"를 선택 했을 시 아래 코드를 실행 -> 그렇지 않으면 실행 X
            theDate?.let {
                // 1970년 부터 선택한 시간이 얼마나 지났는지 알 수 있음
                // 60000으로 나누는 이유 => 초 단위로 바뀌도록 10000을 나누고 분 단위로 나오게 60으로 나눠야함
                //                         이걸 합쳐서 60000으로 나눔
                val selectedDateInMinutes = theDate.time / 60000 // 선택한 날짜와 1970년 1월 1일 사이에 지난 시간을 구하는 변수 생성

                // currentTimeMillis => 1970년 1월 1일 부터 지난 시간을 ms 단위로 알려줌
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis())) // 현재 시각을 구함


                // null 안전성
                currentDate?.let {
                    val currentDateInMinutes = currentDate.time / 60000 // 분단위로 계산하기 위한 변수 생성

                    val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes // 현재 시간과 선택한 시간의 차

                    // "TextView"에 "text"를 변경
                    tvAgeInMinutes?.text = differenceInMinutes.toString()
                }

            }
        }, year, month, day )

        // 한시간은 360만 밀리초 이기 때문에 거기에 24를 곱하면
        dpb.datePicker.maxDate = System.currentTimeMillis() - 86400000 // dataPicker 를 어제 날짜까지만 선택할 수 있게 설정하는 코드
        dpb.show()

    }
}