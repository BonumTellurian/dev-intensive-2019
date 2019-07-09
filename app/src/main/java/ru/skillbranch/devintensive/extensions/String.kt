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
    return String.replace(matchResult.toRegex(), "")
}
