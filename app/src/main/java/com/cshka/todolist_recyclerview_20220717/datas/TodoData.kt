package com.cshka.todolist_20220717.datas

import java.io.Serializable

class TodoData (
    val rating : Double,
    val todoTitle :  String,
    val todoPlace : String,
    val isFinished : Boolean,
        ) : Serializable {
}