package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null

    // 소수점이 이미 입력이 됬는지 확인하기 위한 변수
    private var lastNumeric = false // 마지막 숫자
    private var lastDot = false //소수점

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)


        btnOne.setOnClickListener { onDigit(btnOne) }
        btnTwo.setOnClickListener { onDigit(btnTwo) }
        btnThree.setOnClickListener { onDigit(btnThree) }
        btnFour.setOnClickListener { onDigit(btnFour) }
        btnFive.setOnClickListener { onDigit(btnFive) }
        btnSix.setOnClickListener { onDigit(btnSix) }
        btnSeven.setOnClickListener { onDigit(btnSeven) }
        btnEight.setOnClickListener { onDigit(btnEight) }
        btnNine.setOnClickListener { onDigit(btnNine) }
        btnZero.setOnClickListener { onDigit(btnZero) }
        btnClr.setOnClickListener { onClear(btnClr) }
        btnDot.setOnClickListener { onDecimalPoint(btnDot) }

    }

    // 숫자 추가 메서드
    private fun onDigit(v: View) {
        // append(text: CharSequence) => CharSequence 형식의 파라미터는 이미 존재하는 텍스트에 뭔가 추가한다는 의미
        tvInput?.append((v as Button).text) // "view"를 버튼으로 바꿈 -> v:View 는 받아오는 "button"을 의미함 그래서 그 버튼 속성 중 "text"를 받아옴
        lastNumeric = true
        lastDot = false
    }

    // 전체 삭제 메서드
    private fun onClear(v: View) {
        tvInput?.text = ""
    }

    private fun onDecimalPoint(v: View) {
        // 마지막 입력 값이 숫자이고 소수점이 아니라면 실행
        if(lastNumeric && !lastDot) {
            tvInput?.append(".")
            // 플래그 => lastNumeric, lastDot 처럼 지금 무언가가 활성 상태인지 정지 상태인지를 알려주는 플래그라는 기능
            lastNumeric = false
            lastDot = true
        }
    }

}