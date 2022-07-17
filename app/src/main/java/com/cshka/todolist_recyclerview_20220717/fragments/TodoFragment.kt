package com.cshka.todolist_20220717.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cshka.todolist_20220717.adapters.TodoRecyclerViewAdapter
import com.cshka.todolist_20220717.datas.TodoData
import com.cshka.todolist_recyclerview_20220717.R
import kotlinx.android.synthetic.main.fragment_todo.*

class TodoFragment : Fragment() {
    lateinit var mTodoListAdapter: TodoRecyclerViewAdapter

    val todoList = ArrayList<TodoData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        todoList.add( TodoData(4.5, "오늘 수업 수강하기", "neppPlus 학원", false) )
        todoList.add( TodoData(4.0, "오늘 수업 복습하기", "집", false) )
        todoList.add( TodoData(3.5, "오늘 수업 출석하기", "neppPlus 학원", true) )
        todoList.add( TodoData(3.0, "오늘 수업 수강하기", "neppPlus 학원", false) )
        todoList.add( TodoData(2.5, "오늘 수업 수강하기", "neppPlus 학원", false) )

        mTodoListAdapter = TodoRecyclerViewAdapter(requireContext(), todoList)
        todoRecyclerView.adapter = mTodoListAdapter

        todoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}