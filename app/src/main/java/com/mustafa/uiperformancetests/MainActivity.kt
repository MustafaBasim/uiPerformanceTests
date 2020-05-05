package com.mustafa.uiperformancetests

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mustafa.uiperformancetests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var repeatCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            xmlBtn.setOnClickListener {
                startActivity(Intent(root.context, XMLActivity::class.java))
                repeatCount = 5
            }
        }
        window.decorView.post {
            Log.d("ERROR", " MainActivity decorView ")
        }
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onResume() {
        super.onResume()
        if (repeatCount != 0) {
            startActivity(Intent(binding.root.context, XMLActivity::class.java))
            repeatCount--
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            if (repeatCount != 0) {
                startActivity(Intent(binding.root.context, XMLActivity::class.java))
                repeatCount--
            }
        }
    }
}
