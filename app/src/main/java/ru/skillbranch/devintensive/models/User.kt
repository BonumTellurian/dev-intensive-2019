package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.Utils.Utils
import java.util.*

data class User (
        val id: String,
        var firstName: String?,
        var lastName: String?,
        var avatar: String?,
        var rating: Int = 0,
        var respect: Int = 0,
        val lastVisit: Date? = null,
//        val lastVisit: Date? = Date(),
        val isOnline: Boolean = false
//    var introBit :String = "$firstName $lastName!!!!"
) {

//    var intoBit :String

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id:String) : this(id, "John","Doe")

    init {

        println("It's Alive!!! \n" +
                "${if(lastName === "Doe") "His name id $firstName $lastName" else "And hist name is $firstName $lastName!!!" }\n")
    }


    companion object Factory {
        private var lastId : Int = -1
        fun makeUser(fullName: String?) : User {
            lastId++

//            var (firstName, lastName) = Utils.parseFullName(fullName)
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastId", firstName = firstName, lastName = lastName )
        }
    }



}