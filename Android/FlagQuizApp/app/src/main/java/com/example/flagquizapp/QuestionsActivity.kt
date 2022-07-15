package com.example.flagquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

// 요소를 클릭할 수 있게 만들기 위해 onClickListener 생성
// "AppCompatActivity"에서 "QuestionsActivity" 상속받는 동시에 "OnClickListener" 구현
class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var mUserName: String? = null // 사용자 이름 변수
    private var mCorrectAnswers: Int = 0 // 맞힌 문제 개수 변수

    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        // "MainActivity"에서 "PutExtra"로 보낸 데이터를 받아옴
        // "intent"로 지금의 액티비티에 "USER_NAME"의 위치에서 세부사항을 가져올 수 있음
        // "getStringExtra"를 사용해 문자열의 형태로 가져옴
        mUserName = intent.getStringExtra(Constants.USER_NAME)


        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)
        btnSubmit = findViewById(R.id.btnSubmit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)
        // questionList 객체 생성
        mQuestionsList = Constants.getQuestions()

        /*
        // questionList 객체의 사이즈를 "LogCat"에 표시
        Log.i("QuestionList size : ", " ${mQuestionsList?.size}")

        for(i in mQuestionsList!!) {
            Log.e("Questions", i.question)
        }*/

        setQuestion()

        defaultOptionsView()


    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        Log.i("list", question.toString())

        progressBar?.progress = mCurrentPosition // progressBar 설정
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}" // progressBar TexView 설정

        tvQuestion?.text = question.question // 질문 설정

        ivImage?.setImageResource(question.image) // 질문 이미지 설정

        tvOptionOne?.text = question.optionOne // 1. 객관식 문항 설정
        tvOptionTwo?.text = question.optionTwo // 2. 객관식 문항 설정
        tvOptionThree?.text = question.optionThree // 3. 객관식 문항 설정
        tvOptionFour?.text = question.optionFour // 4. 객관식 문항 설정
        
        // 마지막 문제일 경우 버튼 Text 변경 
        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "제출하기"
        } else {
            btnSubmit?.text = "확인"
        }
    }

    // 새 "Position"이 로딩됐을 때 디폴트값의 옵션을 설정하는 메서드
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)

        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tvOptionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tvOptionTwo -> {
                tvOptionTwo?.let{
                    selectedOptionView(it, 2)
                }
            }
            R.id.tvOptionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tvOptionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btnSubmit ->{
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg) // 틀릴경우
                    }else {
                        mCorrectAnswers++
                    }
                    // else 문제 넣지 않는 이유는 정답을 맞추든 안맞추든 정답을 표시해주기 때문
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)// 맞힌경우

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text = "제출"
                    } else {
                        btnSubmit?.text = "다음 문제"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    // 정답 선택 시 TextView 색상 변경 메서드
    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}