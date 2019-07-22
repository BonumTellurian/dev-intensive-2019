package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Activity.hideKeyboard(){
    if (currentFocus != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}


// https://stackoverflow.com/questions/41790357/close-hide-the-android-soft-keyboard-with-kotlin

//fun Fragment.hideKeyboard() {
//    view?.let { activity?.hideKeyboard(it) }
////    activity.hideKeyboard(view)
//}
//
//fun Activity.hideKeyboard() {
//    hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
//}
//
//fun Context.hideKeyboard(view: View) {
//    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
//    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
//}


//fun Activity.hideKeyboard(){


//    View?.apply {
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(View.windowToken, 0)
//    }

//    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//    imm.hideSoftInputFromWindow(windowToken, 0)


//    fun Fragment.hideKeyboard() {
//        activity?.hideKeyboard(view)
//    }
//
//    fun Activity.hideKeyboard() {
//        hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
//    }
//
//    fun Context.hideKeyboard(view: View) {
//        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
//    }

//}