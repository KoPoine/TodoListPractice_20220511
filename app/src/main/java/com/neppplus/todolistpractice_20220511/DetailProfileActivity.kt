package com.neppplus.todolistpractice_20220511

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.todolistpractice_20220511.models.UserData
import kotlinx.android.synthetic.main.activity_detail_profile.*

class DetailProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_profile)
        setupEvents()
        setValues()
    }

    fun setupEvents() {
        changeBtn.setOnClickListener {
            val nick = nickEdt.text.toString()
            val phoneNum = phoneEdt.text.toString()
            val homeTxt = homeEdt.text.toString()

            val userData = UserData(nick, phoneNum, homeTxt)

            val resultIntent = Intent()
            resultIntent.putExtra("userData",userData)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    fun setValues() {

    }
}