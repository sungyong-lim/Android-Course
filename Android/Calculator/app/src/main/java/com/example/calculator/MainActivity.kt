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

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null

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

    }

    // 숫자 추가 메서드
    private fun onDigit(v: View) {
        // append(text: CharSequence) => CharSequence 형식의 파라미터는 이미 존재하는 텍스트에 뭔가 추가한다는 의미
        tvInput?.append((v as Button).text) // "view"를 버튼으로 바꿈 -> v:View 는 받아오는 "button"을 의미함 그래서 그 버튼 속성 중 "text"를 받아옴
    }

    // 전체 삭제 메서드
    private fun onClear(v: View) {
        tvInput?.text = ""
    }

}