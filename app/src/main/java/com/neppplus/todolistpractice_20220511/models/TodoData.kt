package com.neppplus.todolistpractice_20220511.models

import java.io.Serializable

class TodoData(
    val rating : Double,
    val todoTitle : String,
    val place : String,
    var isFinished : Boolean,
): Serializable {
}