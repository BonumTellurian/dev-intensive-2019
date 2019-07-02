package ru.skillbranch.devintensive.Utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        //TO DO FIX ME!!!
//        val fullName = fullName?.trim()
//        val parts: List<String>? = fullName?.split(" ")
        val parts: List<String>? = fullName?.trim()?.split(" ")
//        val parts: Pair<String?, String> = fullName?.split(" ")

        val firstName =parts?.getOrNull(0)
        val lastName =parts?.getOrNull( 1)
//        val lastName = fullName.trimIndent(firstName)

//        println("========")
//        println(firstName)
//        println(lastName)
//        println("========###=====")

        when {
            fullName.isNullOrBlank() -> return null to null
            lastName.isNullOrBlank() -> return firstName to null
            else -> return Pair(firstName, lastName)
        }
//        return Pair(firstName, lastName)
//        return firstName to lastName

    }

//    fun transliteration(payload:String, divider:String = " "): String {

//        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
//    }


    fun toInitials(firstName: String?, lastName: String?): String? {
        when {
            firstName.isNullOrBlank() && lastName.isNullOrBlank() -> return null
            firstName.isNullOrBlank() -> return lastName?.get(0).toString().capitalize()
            lastName.isNullOrBlank() -> return firstName?.get(0).toString().capitalize()
            else -> return firstName?.get(0).toString().capitalize() + lastName?.get(0).toString().capitalize()
        }
//            val qIns = parseFullName(payload
//        )
//        return qIns
//        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}