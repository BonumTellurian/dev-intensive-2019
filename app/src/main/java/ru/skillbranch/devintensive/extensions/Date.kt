package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date{
    var time = this.time

    time +=when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY

    }
    this.time = time
    return this
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(value: Int) : String {
        // http://codinghamster.info/php/correct-plural-form-of-a-noun/
        return when(this){
            SECOND -> when {
                value % 100 == 11 -> "$value секунд"
                value % 10 == 1 -> "$value секунду"
                value %100 in 12..14 -> "$value секунд"
                value %10 in 2..4 -> "$value секунды"
                else -> "$value секунд"
            }

            MINUTE -> when {
                value % 100 == 11 -> "$value минут"
                value % 10 == 1 -> "$value минуту"
                value %100 in 12..14 -> "$value минут"
                value %10 in 2..4 -> "$value минуты"
                else -> "$value минут"
            }

            HOUR -> when {
                value % 100 == 11 -> "$value часов"
                value % 10 == 1 -> "$value час"
                value %100 in 12..14 -> "$value часов"
                value %10 in 2..4 -> "$value часа"
                else -> "$value часов"
            }

            DAY -> when {
                value % 100 == 11 -> "$value дней"
                value % 10 == 1 -> "$value день"
                value %100 in 12..14 -> "$value дней"
                value %10 in 2..4 -> "$value дня"
                else -> "$value дней"
            }



        }
    }
}

//private fun Date.humanizeDiff(date:Date = Date()): String {
fun Date.humanizeDiff(date:Date = Date()): String {
    val diff = abs(this.time - date.time)/1000
    val diff_m = abs(this.time - date.time)/(1000*60)
    val diff_h = abs(this.time - date.time)/(1000*60*60)
    val diff_d = abs(this.time - date.time)/(1000*60*60*24)
//    val diff_d = abs(this.time - date.time)/(1000*60*60*24)
    val tense: String

//    when {
//        this.time - date.time > 0 -> tense = " через"
//        else -> tense = " назад"
//    }
    when {
        this.time - date.time > 0 -> tense = "Future"
        this.time - date.time < 0 -> tense = "Past"
//        else -> tense = "Past"
        else -> tense = "Wrong"
    }

    println("====")
    println(diff_d)
    println(diff_h)
//    println("${widget::class.qualifedName}")
//    System.out.println(diff.javaClass1.kotlin.qualifiedName)
//    var Nooo = Date.add
    println(tense)

     return when {
//         diff <= SECOND.absoluteValue -> "только что"
//         diff <= SECOND + 1 -> "только что" // Заменить на верхнюю
         diff <= 1 -> "только что" // Заменить на верхнюю
         diff <=  45 -> formatTenseTime("несколько секунд", tense)
         diff <=  75 -> formatTenseTime("минуту", tense)
//         diff <= MINUTE.absoluteValue * 45 -> formatTenseTime(formatWordTime(diff.toString()).first, tense)
         diff <=  45 * 60 -> formatTenseTime((diff_m.toString() + " " + formatWordTime(diff_m.toString()).first), tense)
         diff <=  75 * 60 -> formatTenseTime("час", tense)
         diff <=  22 * 60 * 60 -> formatTenseTime((diff_h.toString() + " " + formatWordTime(diff_h.toString()).second), tense)
         diff <=  26 * 60 * 60 -> formatTenseTime("день", tense)
//         diff <=  360 * 60 * 60 * 24 -> formatTenseTime((diff_d.toString() + " " + formatWordTime(diff_d.toString()).third), tense)
         diff <=  360 * 60 * 60 * 24 -> formatTenseTime((diff_d.toString() + " " + formatWordTime(diff_d.toString()).third), tense)
         else -> "более года назад"
    }
}

//fun formatTenseTime(dateString: String, tense:Boolean): String {
fun formatTenseTime(dateString: String?, tense:String): String {
    println("SOME-> "+tense)
    return when{
        tense == "Past" -> dateString + " назад"
        tense == "Future" -> "через " + dateString
        else -> "Some wrong"
    }
}

fun formatWordTime(dateString: String): Triple<String?,String?,String?>{
    val checkedNumberTwo = dateString.takeLast(2).toInt()
    val checkedNumber = dateString.takeLast(1).toInt()
    return when{
        checkedNumberTwo == 1 -> Triple("минута", "час", "день")
        checkedNumber == 1 -> Triple("минут", "часов", "дней")
        checkedNumber in 2..4 -> Triple("минуты", "часа", "дня")
        else -> Triple("минут", "часов", "дней")

    }
}

