package ru.skillbranch.devintensive.extensions

fun String.truncate(cutter:Int = 16):String?{
    val String = this

    if (String.length >cutter) return String.substring(0, cutter).trimEnd()+"..." else return this



}