package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.Utils.Utils
//import ru.skillbranch.devintensive.Utils.Utils.parseFullName
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView

//import ru.skillbranch.devintensive.models.User
//import ru.skillbranch.devintensive.models.UserView

fun User.toUserView() : UserView {

//    val nickName = Utils.transliteration("$firstName $lastName")
//    val nickName = Utils.transliteration("$firstName $lastName")
//    val nickName = Utils.transliteration("$firstName $lastName")
//    val initials = Utils.toInitials("$fullName")
//    val initials = Utils.toInitials("$firstName $lastName")
//    val initials = Utils.toInitials("$firstName ${this.lastName}")

    val nickName: String = Utils.transliteration("$firstName $lastName").toString()
    val initials = Utils.toInitials(firstName, lastName)

//    val firstName = parseFullName(fullName)

//    val nickName = Utils.transliteration("${this.firstName} ${this.lastName}")
//    val initials = Utils.toInitials("${this.firstName} ${this.lastName}")

    val status = if(lastVisit == null) "Ещё ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"

//    return UserView(
//        id,
//        fullName = "$firstName $lastName",
//
//        avatar = avatar,
//        nickName = nickName,
//        initials = initials,
//        status = status)
    return UserView(
        id,
        "$firstName $lastName",
        nickName,
        avatar,
        status,
        initials
    )
}

