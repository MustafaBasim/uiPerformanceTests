package com.mustafa.uiperformancetests

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mustafa.uiperformancetests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            xmlBtn.setOnClickListener {
                startActivity(Intent(root.context, XMLActivity::class.java))
            }
        }
    }
}
