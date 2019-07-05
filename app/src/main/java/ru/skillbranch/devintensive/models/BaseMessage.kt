package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage (
    val id:String,
    val from:User?,
    val chat:Chat,
    val isIncoming: Boolean = false,
    val date:Date = Date()
) {

//    abstract fun formatMessage(id: String, from: User?, isIncoming: Boolean):String   //{
    abstract fun formatMessage():String   //{
//        return("$id, $from, $isIncoming")
//    }

    companion object AbstractFactory{

        var lastId = -1


//        fun makeMessage(from:User?, chat:Chat, date:Date = Date(), type:String="text", payload: Any? ):BaseMessage{
//            lastId++
//            return when(type){
//                "image" -> ImageMessage("$lastId", from, chat, date=date, image = payload as String)
//                    else -> TextMessage("$lastId", from, chat, date=date, text = payload as String)
//
//        }

        fun makeMessage(from:User?, chat:Chat, date:Date = Date(), type:String="text", payload: Any?, isIncoming: Boolean = false):BaseMessage{
            lastId++
            return when(type){
                "image" -> ImageMessage( "$lastId", from, chat, date=date, image = payload as String, isIncoming = isIncoming)
                    else -> TextMessage("$lastId", from, chat, date=date, text = payload as String, isIncoming = isIncoming)
            }
        }
    }

}

//        fun makeMessage(from:User?, chat:Chat, date:Date = Date(), type:String="text", payload: AlwaysOnHotwordDetector.EventPayload):BaseMessage{