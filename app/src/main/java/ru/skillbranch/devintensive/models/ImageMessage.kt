package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class ImageMessage (
    id:String,
    from:User?,
    chat: Chat,
    isIncoming : Boolean = false,
    date: Date = Date(),
    var image:String?
) : BaseMessage(id, from, chat, isIncoming, date){
    override fun formatMessage(): String
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        override fun formatMesage(): String = "id:$id ${from?.firstName}" +
                    "${if(isIncoming) "получил" else "отправил" } изображение \"$image\" ${date.humanizeDiff()}"
}