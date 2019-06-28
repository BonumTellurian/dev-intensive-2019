package ru.skillbranch.devintensive.extensions

//import ru.skillbranch.devintensive.Utils.Utils
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import java.util.*

fun User.toUserView() : UserView {

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName lastName)
    val status = if(lastVisit == null) "Ещё ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",

        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = )
}

private fun Date.humanizeDiff(date.Date = Date()): String {
    TODO ("not implemented") // To change body of created function use File | Settings | File Templates.
}