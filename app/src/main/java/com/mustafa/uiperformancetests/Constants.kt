package com.mustafa.uiperformancetests

/**
 * Created by: Mustafa Basim
 * E-mail: 96.mustafa.basim@gmail.com
 * Project name: UI Performance Tests
 * Package: com.mustafa.uiperformancetests
 * Date: 5/4/2020
 */

object Data {
    val list = ArrayList<User>().apply {
        var index = 1
        for (i in 1..30) {
            add(User("Mustafa - $index", R.drawable.ic_android, "This is a subtitle - $index"))
            index++
            add(User("Mustafa - $index", R.drawable.ic_favorite, "This is a subtitle - $index"))
            index++
            add(User("Mustafa - $index", R.drawable.ic_toys, "This is a subtitle - $index"))
            index++
        }
    }
}

class User(val name: String, val image: Int, val subtitle: String)