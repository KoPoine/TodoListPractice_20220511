package com.neppplus.todolistpractice_20220511.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.neppplus.todolistpractice_20220511.R
import com.neppplus.todolistpractice_20220511.models.TodoData

class TodoListAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<TodoData>
): ArrayAdapter<TodoData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(R.layout.todo_list_item, null)
        }

        val row = tempRow!!


        return row
    }
}