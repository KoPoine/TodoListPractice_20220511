package com.neppplus.todolistpractice_20220511.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.todolistpractice_20220511.DetailProfileActivity
import com.neppplus.todolistpractice_20220511.R
import com.neppplus.todolistpractice_20220511.models.UserData
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment: Fragment() {

    val REQ_FOR_EDIT = 1004

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQ_FOR_EDIT) {
                val userData = data?.getSerializableExtra("userData") as UserData

                if (userData.name.isNotBlank()) {
                    nickTxt.text = userData.name
                }

                if (userData.phoneNum.isNotBlank()) {
                    phoneTxt.text = userData.phoneNum
                }

                if (userData.home.isNotBlank()) {
                    homeTxt.text = userData.home
                }
            }
        }
    }

    fun setupEvents() {
        changeBtn.setOnClickListener {
            val myIntent = Intent(requireContext(), DetailProfileActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_EDIT)
        }
    }

    fun setValues() {

    }
}