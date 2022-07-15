package com.example.flagquizapp

object Constants {

    const val USER_NAME : String = "user_name" // 이름 변수
    const val TOTAL_QUESTION: String = "total_questions" // 총 문제 개수 변수
    const val CORRECT_ANSWERS: String = "correct_answers" // 맞힌 문제 개수 변수


    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1번 문제
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia"," New Zealand",
            1
        )
        questionsList.add(que1)

        // 2번 문제
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "뉴질랜드", "오스트리아",
            "호주"," 아르메니아",
            3
        )
        questionsList.add(que2)


        // 3번 문제
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "벨라루스", "콜롬비아",
            "브루나이","브라질",
            4
        )
        questionsList.add(que3)

        // 4번 문제
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "바하마", "벨기에",
            "바베이도스","벨리즈",
            2
        )
        questionsList.add(que4)

        // 5번 문제
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "가봉", "프랑스",
            "피지","핀란드",
            3
        )
        questionsList.add(que5)

        // 6번 문제
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "조지아","독일",
            "그리스","정답 없음",
            2
        )
        questionsList.add(que6)

        // 7번 문제
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "도미니카 공화국", "이집트",
            "덴마크","에티오피아",
            3
        )
        questionsList.add(que7)

        // 8번 문제
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "아일랜드", "이란",
            "헝가리","인도",
            4
        )
        questionsList.add(que8)

        // 9번 문제
        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "쿠웨이트", "요르단",
            "수단","팔레스타인",
            1
        )
        questionsList.add(que9)

        // 10번 문제
        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "몽골", "뉴질랜드",
            "파키스탄","알제리",
            2
        )
        questionsList.add(que10)

        return questionsList
    }
}