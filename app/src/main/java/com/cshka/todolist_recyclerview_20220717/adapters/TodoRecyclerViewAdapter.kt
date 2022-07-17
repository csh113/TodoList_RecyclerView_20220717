package com.cshka.todolist_20220717.adapters

import android.content.Context
import android.graphics.Paint
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cshka.todolist_20220717.datas.TodoData
import com.cshka.todolist_recyclerview_20220717.R

class TodoRecyclerViewAdapter (
    val mContext : Context,
    val mList : ArrayList<TodoData>
        ) : RecyclerView.Adapter<TodoRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        // 바인드 하는 것 생성
        fun bind(item : TodoData) {
//            실제 데이터를 한칸 xml의 각 태그에 배치
            val todoRatingBar = itemView.findViewById<RatingBar>(R.id.todoRatingBar)
            val todoTxt = itemView.findViewById<TextView>(R.id.todoTitleTxt)
            val finishedCb = itemView.findViewById<CheckBox>(R.id.finishedCb)

            todoRatingBar.rating = item.rating.toFloat()
            todoTxt.text = item.todoTitle
            finishedCb.isChecked = item.isFinished

//            체크 박스 체크되어 있다면 -> 완료되었기에 TextView에 취소선 긋기
            if(item.isFinished) {
                todoTxt.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                todoTxt.paintFlags = 0
            }

//            Trello : 일반 버튼 클릭 외의 다양한 이벤트 처리
//            xml의 LinearLayout.id 해서 가져와서 바로 setOnClick TextView에도 이벤트가 가능함
//            CheckBox의 체크 여부 변경 감지 이벤트 - return 값 boolean 값
//            check가 되었으면
//            자동로그인에 활용함
            finishedCb.setOnCheckedChangeListener { compoundButton, isChecked ->
                Log.d(">>>>>>>>>> 체크 : ", "체크 되었니?? ")
                if(isChecked) {
                    todoTxt.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                } else {
                    todoTxt.paintFlags = 0
                }
            }
//            EditText의 내용 변경 감지 이벤트 - 회원 가입 구현 시 API로 하기
        }
    }

//    한칸의 xml을 실제 view와 연결하는 것 (ListView의 getView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { //??? 생성 -> MyViewHolder 를 넣어준다
        val row = LayoutInflater.from(mContext).inflate(R.layout.todo_list_item, parent, false)
        return MyViewHolder(row)
    }

//    우리가 만든 ViewHolder 클래스에 실제 데이터 연결
//    위치에 맞는 데이터 추출
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

//    전체 리스트의 갯수 - 리스트 자체를 모르므로 내부 생성자로 파라미터로 받아야 한다. mList
    override fun getItemCount(): Int {
        return mList.size
    }

}