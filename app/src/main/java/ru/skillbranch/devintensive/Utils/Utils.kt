package ru.skillbranch.devintensive.Utils

import androidx.lifecycle.Transformations.map
import java.io.File.separator

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
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

    fun toDragonSpeak (phrase: String):String?{
        val sup = phrase.replace(Regex("а..я")){

            when(it.value) {
                "а" ->  "a"
                "б" ->  "b"
                "в" ->  "v"
                "г" ->  "g"
                "д" ->  "d"
                "е" ->  "e"
                "ё" ->  "e"
                "ж" ->  "zh"
                "з" ->  "z"
                 "и" ->  "i"
                 "й" ->  "i"
                 "к" ->  "k"
                 "л" ->  "l"
                 "м" ->  "m"
                 "н" ->  "n"
                 "о" ->  "o"
                 "п" ->  "p"
                 "р" ->  "r"
                 "с" ->  "s"
                 "т" ->  "t"
                 "у" ->  "u"
                 "ф" ->  "f"
                 "х" ->  "h"
                 "ц" ->  "c"
                 "ч" ->  "ch"
                 "ш" ->  "sh"
                 "щ" ->  "sh'"
                 "ъ" ->  ""
                 "ы" ->  "i"
                 "ь" ->  ""
                 "э" ->  "e"
                 "ю" ->  "yu"
                 "я" ->  "ya"
                 "А" ->  "A"
                 "Б" ->  "B"
                 "В" ->  "V"
                 "Г" ->  "G"
                 "Д" ->  "D"
                 "Е" ->  "E"
                 "Ё" ->  "E"
                 "Ж" ->  "Zh"
                 "З" ->  "Z"
                 "И" ->  "I"
                 "Й" ->  "I"
                 "К" ->  "K"
                 "Л" ->  "L"
                 "М" ->  "M"
                 "Н" ->  "N"
                 "О" ->  "O"
                 "П" ->  "P"
                 "Р" ->  "R"
                 "С" ->  "S"
                 "Т" ->  "T"
                 "У" ->  "U"
                 "Ф" ->  "F"
                 "Х" ->  "H"
                 "Ц" ->  "C"
                 "Ч" ->  "Ch"
                 "Ш" ->  "Sh"
                 "Щ" ->  "Sh'"
                 "Ъ" ->  ""
                 "Ы" ->  "I"
                 "Ь" ->  ""
                 "Э" ->  "E"
                 "Ю" ->  "Yu"
                 "Я" ->  "Ya"
                 else ->  it.value
            }
        }
        return sup
    }

    fun transliteration(payload:String, divider:String = " "): String? {

        val wordsList: List<String>? = payload.split(" ")

//        val transer : HashMap<String, String> = hashMapOf(
//        val transer : HashMap<Char, String> = hashMapOf(
//            "а" to "a",
//            "б" to "b",
//            "в" to "v",
//            "г" to "g",
//            "д" to "d",
//            "е" to "e",
//            "ё" to "e",
//            "ж" to "zh",
//            "з" to "z",
//            "и" to "i",
//            "й" to "i",
//            "к" to "k",
//            "л" to "l",
//            "м" to "m",
//            "н" to "n",
//            "о" to "o",
//            "п" to "p",
//            "р" to "r",
//            "с" to "s",
//            "т" to "t",
//            "у" to "u",
//            "ф" to "f",
//            "х" to "h",
//            "ц" to "c",
//            "ч" to "ch",
//            "ш" to "sh",
//            "щ" to "sh'",
//            "ъ" to "",
//            "ы" to "i",
//            "ь" to "",
//            "э" to "e",
//            "ю" to "yu",
//            "я" to "ya",
//            "А" to "A",
//            "Б" to "B",
//            "В" to "V",
//            "Г" to "G",
//            "Д" to "D",
//            "Е" to "E",
//            "Ё" to "E",
//            "Ж" to "Zh",
//            "З" to "Z",
//            "И" to "I",
//            "Й" to "I",
//            "К" to "K",
//            "Л" to "L",
//            "М" to "M",
//            "Н" to "N",
//            "О" to "O",
//            "П" to "P",
//            "Р" to "R",
//            "С" to "S",
//            "Т" to "T",
//            "У" to "U",
//            "Ф" to "F",
//            "Х" to "H",
//            "Ц" to "C",
//            "Ч" to "Ch",
//            "Ш" to "Sh",
//            "Щ" to "Sh'",
//            "Ъ" to "",
//            "Ы" to "I",
//            "Ь" to "",
//            "Э" to "E",
//            "Ю" to "Yu",
//            "Я" to "Ya"
//        )

//        return payload.map.forEach {it -> transer(it) }.toString()
        return payload.forEach { it -> toDragonSpeak(it.toString()) }.toString()
        //        return wordsList(0)?.forEach { it -> transer(it) }

//        return wordsList?.map { it -> it.getValue(transer) }?.joinToString(separator = divider)
//        return wordsList?.map { it -> it.getValue(transer) }?.joinToString(separator = divider)


//        if (transer[it] != mull) payload.replace(it, transer[it])
//        return payload.forEach(mapOf(transer))
//        return

//        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }


    fun toInitials(firstName: String?, lastName: String?): String? {
        when {
            firstName.isNullOrBlank() && lastName.isNullOrBlank() -> return null
            firstName.isNullOrBlank() -> return lastName?.get(0).toString().capitalize()
            lastName.isNullOrBlank() -> return firstName?.get(0).toString().capitalize()
            else -> return firstName?.get(0).toString().capitalize() + lastName?.get(0).toString().capitalize()
        }
    }
}