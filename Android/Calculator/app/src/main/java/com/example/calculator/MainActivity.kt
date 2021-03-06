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

        // 액션바 로고
        var actionBar = supportActionBar
        actionBar?.setIcon(R.drawable.logo)
        actionBar?.setDisplayUseLogoEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

        tvInput = findViewById(R.id.tvInput)

        // 숫자 버튼 onClick
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
        
        // 전체 지우기 버튼  onClick
        btnClr.setOnClickListener { onClear(btnClr) }

        // 소수점 버튼 onClick
        btnDot.setOnClickListener { onDecimalPoint(btnDot) }

        // 연산자 버튼 onClick
        btnPlus.setOnClickListener { onOperator(btnPlus) }
        btnSub.setOnClickListener { onOperator(btnSub) }
        btnMul.setOnClickListener { onOperator(btnMul) }
        btnDiv.setOnClickListener { onOperator(btnDiv) }
        
        // 등호 버튼 onClick 
        btnEqual.setOnClickListener { onEqual(btnEqual) }

        // Back 버튼 onClick
        btnBack.setOnClickListener { onBack(btnBack) }

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

    private fun onOperator(v: View) {
        // 매개 변수를 넘기기 전에 let(안전 호출 기호)를 사용해 값을 구함
        // "tvInput"과 "text"가 null(비어 있지 않으면) 아니면 텍스트 그 자체인 "CharSequence" 넘겨줌
        tvInput?.text?.let {
            if(lastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((v as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }
    
    // 등호 버튼 클릭 시 호출되는 메서드
    private fun onEqual(v: View) {

        // 마지막 입력 값이 숫자이면 실행되면 "TextView"에 텍스트를 스트링 형식으로 받아오는 제어문
        if(lastNumeric) {
            var tvValue = tvInput?.text.toString()
            var prefix = ""


            try {
                if(tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1) //"tvValue"의 첫 입력 값을 지운다는 뜻 즉, index 1번 부터 문자열을 다시 만든다는 의미
                }

                if(tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")

                    var oneValue = splitValue[0]
                    var twoValue = splitValue[1]

                    if(prefix.isNotEmpty()) {
                        oneValue = prefix + oneValue
                    }

                    tvInput?.text = removeZeroAfterDot((oneValue.toDouble() + twoValue.toDouble()).toString())

                } else if(tvValue.contains("-")) { // 뺄셈 연산
                    // "tvValue"를 "split"을 사용해서 해당 연산자를 기준으로 나눔 99 - 5
                    val splitValue = tvValue.split("-")

                    var oneValue = splitValue[0] // 첫번째 숫자 99
                    var twoValue = splitValue[1] // 두번째 숫자  5
//                    var result = oneValue.toDouble() - twoValue.toDouble()

                    // prefix가 비어있지 않다면 즉, 첫번째 숫자가 -이면 실행
                    if(prefix.isNotEmpty()) {
                        oneValue = prefix + oneValue
                    }

                   tvInput?.text = removeZeroAfterDot((oneValue.toDouble() - twoValue.toDouble()).toString())

                } else if(tvValue.contains("*")) {
                    val splitValue = tvValue.split("*")

                    var oneValue = splitValue[0]
                    var twoValue = splitValue[1]

                    if(prefix.isNotEmpty()) {
                        oneValue = prefix + oneValue
                    }

                    tvInput?.text = removeZeroAfterDot((oneValue.toDouble() * twoValue.toDouble()).toString())


                } else if(tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")

                    var oneValue = splitValue[0]
                    var twoValue = splitValue[1]

                    if(prefix.isNotEmpty()) {
                        oneValue = prefix + oneValue
                    }

                    tvInput?.text = removeZeroAfterDot((oneValue.toDouble() / twoValue.toDouble()).toString())
                }


            }catch (e: ArithmeticException) { // 산술적 오류 => 0으로 나누거나 산술적으로 계산이 불가능하면 실행
                e.printStackTrace()
            }
        }

   }

    // 계산 결과가 Int 형식이면 .0을 제거하는 메서드
    private fun removeZeroAfterDot(result: String): String {
        var value = result
        if(result.contains(".0"))  // 만약 계산식 뒤에 .0이 붙어있으면 실행 ex) 10.0, 652.0, 대신 78.1은 안됨
            value = result.substring(0, result.length - 2) // "value"에 0부터 마지막 2개의 문자열을 제외한 값이 출력
        return value
    }

    // 연산자가 추가됐는지 확인하는 메서드
    private fun isOperatorAdded(value: String): Boolean {
        // "value"의 시작 문자가 특정 문자("-")로 시작하는지 확인하는 코드
        return if(value.startsWith("-")) {
            false // 특정 문자("-") 무시
        } else {
            println(value.contains("/"))
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }
    }

    // 문자열 한개씩 제거하는 메서드
    private fun onBack(v: View) {
        var tvValue = tvInput?.text.toString()
        if(tvValue.isNotEmpty()){
            tvValue = tvValue?.substring(0, tvValue.length - 1).toString()
            println(tvValue)
            tvInput?.text =  tvValue
        }

    }

}