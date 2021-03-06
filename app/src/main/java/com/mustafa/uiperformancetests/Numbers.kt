package com.mustafa.uiperformancetests

object Numbers {
    object XML {
        val onCreate = ArrayList<Long>()
        val viewTreeObserver = ArrayList<Long>()
        val decorView = ArrayList<Long>()
        val onResume = ArrayList<Long>()
        val onWindowFocusChanged = ArrayList<Long>()
    }

    object ByCode {
        val onCreate = ArrayList<Long>()
        val viewTreeObserver = ArrayList<Long>()
        val decorView = ArrayList<Long>()
        val onResume = ArrayList<Long>()
        val onWindowFocusChanged = ArrayList<Long>()
    }

    object Compose {
        val onCreate = ArrayList<Long>()
        val viewTreeObserver = ArrayList<Long>()
        val decorView = ArrayList<Long>()
        val onResume = ArrayList<Long>()
        val onWindowFocusChanged = ArrayList<Long>()
    }
}