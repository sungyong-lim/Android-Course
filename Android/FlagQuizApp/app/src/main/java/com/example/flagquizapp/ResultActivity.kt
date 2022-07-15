package com.example.flagquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_result.*
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvScore: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)
        val ivScore: ImageView = findViewById(R.id.iv_score)
        val tvCongratulations: TextView = findViewById(R.id.tv_congratulations)

        tvName.text = intent.getStringExtra(Constants.USER_NAME) // 받아오는 값 String 형, userName 표시

        val totalQuestions = intent?.getIntExtra(Constants.TOTAL_QUESTION, 0) // 받아오는 값 Int 형
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0) // 받아오는 값 Int 형

        // 맞춘 갯수에 따라 이미지 변경
        if(correctAnswers == 10) {
            ivScore.setImageResource(R.drawable.ic_trophy)
            tvCongratulations.text = "축하합니다. 모든 문제를 맞췄습니다!!!!"
        } else if(correctAnswers >= 5) {
            ivScore.setImageResource(R.drawable.ic_highscore)
            tvCongratulations.text = "축하합니다. 우수한 성적입니다."
        } else {
            ivScore.setImageResource(R.drawable.ic_lowscore)
            tvCongratulations.text = "아쉽네요. 조금 더 노력하세요."
        }

        tvScore.text = "Your Score is $correctAnswers out of $totalQuestions" // score 표시

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        
        
    }
}