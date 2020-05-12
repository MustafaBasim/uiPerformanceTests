package com.mustafa.uiperformancetests

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mustafa.uiperformancetests.bycode.ByCodeActivity
import com.mustafa.uiperformancetests.compose.ComposeActivity
import com.mustafa.uiperformancetests.databinding.ActivityMainBinding
import com.mustafa.uiperformancetests.xml.XMLActivity

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

            byCodeBtn.setOnClickListener {
                startActivity(Intent(root.context, ByCodeActivity::class.java))
            }

            composeBtn.setOnClickListener {
                startActivity(Intent(root.context, ComposeActivity::class.java))
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        binding.apply {
            xmlLbl.text =
                "number of tries = ${Numbers.XML.onResume.size}\n" +
                        "onCreate ------- min ${Numbers.XML.onCreate.min()} max ${Numbers.XML.onCreate.max()} avg ${Numbers.XML.onCreate.average().toInt()}\n" +
                        "viewTree ------- min ${Numbers.XML.viewTreeObserver.min()} max ${Numbers.XML.viewTreeObserver.max()} avg ${Numbers.XML.viewTreeObserver.average().toInt()}\n" +
                        "decorView ----- min ${Numbers.XML.decorView.min()} max ${Numbers.XML.decorView.max()} avg ${Numbers.XML.decorView.average().toInt()}\n" +
                        "onResume ------ min ${Numbers.XML.onResume.min()} max ${Numbers.XML.onResume.max()} avg ${Numbers.XML.onResume.average().toInt()}\n" +
                        "WindowFocus min ${Numbers.XML.onWindowFocusChanged.min()} max ${Numbers.XML.onWindowFocusChanged.max()} avg ${Numbers.XML.onWindowFocusChanged.average().toInt()}"

            byCodeLbl.text =
                "number of tries = ${Numbers.ByCode.onResume.size}\n" +
                        "onCreate ------- min ${Numbers.ByCode.onCreate.min()} max ${Numbers.ByCode.onCreate.max()} avg ${Numbers.ByCode.onCreate.average().toInt()}\n" +
                        "viewTree ------- min ${Numbers.ByCode.viewTreeObserver.min()} max ${Numbers.ByCode.viewTreeObserver.max()} avg ${Numbers.ByCode.viewTreeObserver.average().toInt()}\n" +
                        "decorView ----- min ${Numbers.ByCode.decorView.min()} max ${Numbers.ByCode.decorView.max()} avg ${Numbers.ByCode.decorView.average().toInt()}\n" +
                        "onResume ------ min ${Numbers.ByCode.onResume.min()} max ${Numbers.ByCode.onResume.max()} avg ${Numbers.ByCode.onResume.average().toInt()}\n" +
                        "WindowFocus min ${Numbers.ByCode.onWindowFocusChanged.min()} max ${Numbers.ByCode.onWindowFocusChanged.max()} avg ${Numbers.ByCode.onWindowFocusChanged.average().toInt()}"

            composeLbl.text =
                "number of tries = ${Numbers.Compose.onResume.size}\n" +
                        "onCreate ------- min ${Numbers.Compose.onCreate.min()} max ${Numbers.Compose.onCreate.max()} avg ${Numbers.Compose.onCreate.average().toInt()}\n" +
                        "viewTree ------- min ${Numbers.Compose.viewTreeObserver.min()} max ${Numbers.Compose.viewTreeObserver.max()} avg ${Numbers.Compose.viewTreeObserver.average().toInt()}\n" +
                        "decorView ----- min ${Numbers.Compose.decorView.min()} max ${Numbers.Compose.decorView.max()} avg ${Numbers.Compose.decorView.average().toInt()}\n" +
                        "onResume ------ min ${Numbers.Compose.onResume.min()} max ${Numbers.Compose.onResume.max()} avg ${Numbers.Compose.onResume.average().toInt()}\n" +
                        "WindowFocus min ${Numbers.Compose.onWindowFocusChanged.min()} max ${Numbers.Compose.onWindowFocusChanged.max()} avg ${Numbers.Compose.onWindowFocusChanged.average().toInt()}"
        }
    }
}
