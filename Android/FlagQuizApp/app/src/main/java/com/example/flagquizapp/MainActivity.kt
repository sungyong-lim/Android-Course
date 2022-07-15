package com.example.flagquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnStart: Button = findViewById(R.id.btnStart)
        var etName: EditText = findViewById(R.id.etName)
        btnStart.setOnClickListener{
            if(etName.text.isEmpty()) {
                Toast.makeText(this,
                    "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                var intent = Intent(this, QuestionsActivity::class.java)
                // 추가적인 정보 값을 한 액티비티에서 다른 액티비티로 옮기고 난 뒤에 다른 액티비티에서 정보값을 회수할 수 있음
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent)
                finish() // "MainActivity"를 닫음 -> 화면이 전환되면 뒤로가기를 눌러도 "MainActivity"로 돌아가지 않음
            }
        }
    }
}