package com.neppplus.todolistpractice_20220511.adapters

import android.content.Context
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.neppplus.todolistpractice_20220511.R
import com.neppplus.todolistpractice_20220511.models.TodoData
import com.willy.ratingbar.ScaleRatingBar

class TodoListAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<TodoData>
): ArrayAdapter<TodoData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)
        }

        val row = tempRow!!

        val data = mList[position]

        val ratingBar = row.findViewById<ScaleRatingBar>(R.id.todoRatingBar)
        val todoTitle = row.findViewById<TextView>(R.id.todoTxt)
        val cb = row.findViewById<CheckBox>(R.id.finishedCb)

        ratingBar.rating = data.rating.toFloat()
        todoTitle.text = data.todoTitle
        cb.isChecked = data.isFinished
        if (data.isFinished) {
            todoTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            todoTitle.paintFlags = 0
        }
        cb.setOnCheckedChangeListener { compoundButton, b ->
            data.isFinished = b
            Log.d("isFinished", "${data.isFinished}")
            if (b) {
                todoTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                todoTitle.paintFlags = 0
            }
        }

        return row
    }
}