package ru.skillbranch.devintensive.extensions

fun String.truncate(cutter:Int = 16):String?{
    val String = this

    if (String.length >cutter) return String.substring(0, cutter).trimEnd()+"..." else return this

}

fun String.stripHtml():String?{
    val String = this
//    val matchResult = """\d+"""
//    val matchResult = """<\s*a[^>]*>(.*?)<\s*/\s*a>"""
    val matchResult = """<.*?>"""
    val mR2 = """&amp;"""
    val mR3 = """&lt;"""
    val mR4 = """&gt;"""
    val mR5 = """&prime;"""
    val mR6 = """&Prime;"""
    val mR7 = """&quot;"""
    val mR8 = """\\s+"""
    return String.replace(matchResult.toRegex(), "").replace(mR2.toRegex(),"").
        replace(mR3.toRegex(), "").replace(mR4.toRegex(), "").
        replace(mR5.toRegex(), "").replace(mR6.toRegex(), "").
        replace(mR7.toRegex(), "").replace(mR8.toRegex(), " ")

}
