package com.example.flagquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuestionsActivity : AppCompatActivity() {
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)

        // questionList 객체 생성
        val questionList = Constants.getQuestions()
        // questionList 객체의 사이즈를 "LogCat"에 표시
        Log.i("QuestionList size : ", " ${questionList.size}")

        for(i in questionList) {
            Log.e("Questions", i.question)
        }

        var currentPosition = 1
        val question: Question = questionList[currentPosition - 1]
        Log.i("list", question.toString())


        progressBar?.progress = currentPosition // progressBar 설정
        tvProgress?.text = "$currentPosition/${progressBar?.max}" // progressBar TexView 설정

        tvQuestion?.text = question.question // 질문 설정

        ivImage?.setImageResource(question.image) // 질문 이미지 설정

        tvOptionOne?.text = question.optionOne // 1. 객관식 문항 설정
        tvOptionTwo?.text = question.optionTwo // 2. 객관식 문항 설정
        tvOptionThree?.text = question.optionThree // 3. 객관식 문항 설정
        tvOptionFour?.text = question.optionFour // 4. 객관식 문항 설정




    }
}