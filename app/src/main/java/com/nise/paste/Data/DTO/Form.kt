package com.nise.paste.Data.DTO

data class Form(
    var age:Int,
    var email:String,
    var id:Int,
    var name:String,
    var toDo:List<toDo>
)

data class toDo(
    var content:String,
    var id:String,
    var isCompleted:Boolean
)

data class User(
    var id:Int,
    var token:String
)

