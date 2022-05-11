package com.neppplus.todolistpractice_20220511.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.neppplus.todolistpractice_20220511.R
import com.neppplus.todolistpractice_20220511.adapters.TodoListAdapter
import com.neppplus.todolistpractice_20220511.models.TodoData
import kotlinx.android.synthetic.main.fragment_todo.*

class TodoFragment: Fragment() {

    val todoList = ArrayList<TodoData>()

    lateinit var mTodoAdapter : TodoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (todoList.isEmpty() ) {
            todoList.add( TodoData(4.5, "오늘 수업 수강하기", "neppPlus 학원", false) )
            todoList.add( TodoData(4.0, "오늘 수업 복습하기", "집", false) )
            todoList.add( TodoData(3.5, "오늘 수업 출석하기", "neppPlus 학원", true) )
            todoList.add( TodoData(3.0, "오늘 수업 수강하기", "neppPlus 학원", false) )
            todoList.add( TodoData(2.5, "오늘 수업 수강하기", "neppPlus 학원", false) )
        }
    }

    fun setupEvents() {

    }

    fun setValues() {

        mTodoAdapter = TodoListAdapter(requireContext(), R.layout.todo_list_item, todoList)
        todoListView.adapter = mTodoAdapter
        
        todoListView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(requireContext(), "${i}번째 리스트입니다.", Toast.LENGTH_SHORT).show()
        }
    }
}