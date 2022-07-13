package com.example.flagquizapp

// 문제 ID, 문제 Questions, 문제 이미지, 객관식 1 ~ 4번, 정답
data class Question(
    var id: Int,
    var question: String,
    var image: Int,
    var optionOne: String,
    var optionTwo: String,
    var optionThree: String,
    var optionFour: String,
    var correctAnswer: Int
)
