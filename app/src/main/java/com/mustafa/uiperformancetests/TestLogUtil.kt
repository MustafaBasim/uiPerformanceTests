package com.mustafa.uiperformancetests

import android.app.Activity
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Auto open and finish Activity
 */
object AutoTestUtil {
    private var enableAutoTest = true
    private var testingTimes = 0
    private const val INTERVAL_TIME = 2500L
    private const val TOTAL_TEST_TIMES = 10


    /**
     * start test
     */
    fun startTest(mainActivity: Activity, cls: Class<*>) {
        if (!enableAutoTest) return
        Log.i("ERROR", "Test start, activity: ${cls.simpleName}")
        testingTimes = 0
        GlobalScope.launch(Dispatchers.Main) {
            while (testingTimes < TOTAL_TEST_TIMES) {
                mainActivity.startActivity(Intent(mainActivity, cls))
                ++testingTimes
                delay(INTERVAL_TIME)
                // clear old activity
                mainActivity.startActivity(Intent(mainActivity, mainActivity::class.java))
                delay(500)
            }
            Log.i("ERROR", "Test Done")
        }
    }
}