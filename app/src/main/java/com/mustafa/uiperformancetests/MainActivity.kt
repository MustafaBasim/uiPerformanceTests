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
        Data.list.apply {
            var index = 1
            for (i in 1..50) {
                add(User("Mustafa - $index", R.drawable.ic_android, "This is a subtitle - $index"))
                index++
                add(User("Mustafa - $index", R.drawable.ic_favorite, "This is a subtitle - $index"))
                index++
                add(User("Mustafa - $index", R.drawable.ic_toys, "This is a subtitle - $index"))
                index++
            }
        }
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
                "number of tries = ${Numbers.XML.onCreate.size}\n" +
                        "onCreate ------- min ${Numbers.XML.onCreate.minOrNull()} max ${Numbers.XML.onCreate.maxOrNull()} avg ${Numbers.XML.onCreate.average().toInt()}\n" +
                        "onResume ------ min ${Numbers.XML.onResume.minOrNull()} max ${Numbers.XML.onResume.maxOrNull()} avg ${Numbers.XML.onResume.average().toInt()}\n" +
                        "viewTree ------- min ${Numbers.XML.viewTreeObserver.minOrNull()} max ${Numbers.XML.viewTreeObserver.maxOrNull()} avg ${Numbers.XML.viewTreeObserver.average().toInt()}\n" +
                        "decorView ----- min ${Numbers.XML.decorView.minOrNull()} max ${Numbers.XML.decorView.maxOrNull()} avg ${Numbers.XML.decorView.average().toInt()}\n" +
                        "WindowFocus min ${Numbers.XML.onWindowFocusChanged.minOrNull()} max ${Numbers.XML.onWindowFocusChanged.maxOrNull()} avg ${Numbers.XML.onWindowFocusChanged.average().toInt()}"

            byCodeLbl.text =
                "number of tries = ${Numbers.ByCode.onCreate.size}\n" +
                        "onCreate ------- min ${Numbers.ByCode.onCreate.minOrNull()} max ${Numbers.ByCode.onCreate.maxOrNull()} avg ${Numbers.ByCode.onCreate.average().toInt()}\n" +
                        "onResume ------ min ${Numbers.ByCode.onResume.minOrNull()} max ${Numbers.ByCode.onResume.maxOrNull()} avg ${Numbers.ByCode.onResume.average().toInt()}\n" +
                        "viewTree ------- min ${Numbers.ByCode.viewTreeObserver.minOrNull()} max ${Numbers.ByCode.viewTreeObserver.maxOrNull()} avg ${Numbers.ByCode.viewTreeObserver.average().toInt()}\n" +
                        "decorView ----- min ${Numbers.ByCode.decorView.minOrNull()} max ${Numbers.ByCode.decorView.maxOrNull()} avg ${Numbers.ByCode.decorView.average().toInt()}\n" +
                        "WindowFocus min ${Numbers.ByCode.onWindowFocusChanged.minOrNull()} max ${Numbers.ByCode.onWindowFocusChanged.maxOrNull()} avg ${Numbers.ByCode.onWindowFocusChanged.average().toInt()}"

            composeLbl.text =
                "number of tries = ${Numbers.Compose.onCreate.size}\n" +
                        "onCreate ------- min ${Numbers.Compose.onCreate.minOrNull()} max ${Numbers.Compose.onCreate.maxOrNull()} avg ${Numbers.Compose.onCreate.average().toInt()}\n" +
                        "onResume ------ min ${Numbers.Compose.onResume.minOrNull()} max ${Numbers.Compose.onResume.maxOrNull()} avg ${Numbers.Compose.onResume.average().toInt()}\n" +
                        "viewTree ------- min ${Numbers.Compose.viewTreeObserver.minOrNull()} max ${Numbers.Compose.viewTreeObserver.maxOrNull()} avg ${Numbers.Compose.viewTreeObserver.average().toInt()}\n" +
                        "decorView ----- min ${Numbers.Compose.decorView.minOrNull()} max ${Numbers.Compose.decorView.maxOrNull()} avg ${Numbers.Compose.decorView.average().toInt()}\n" +
                        "WindowFocus min ${Numbers.Compose.onWindowFocusChanged.minOrNull()} max ${Numbers.Compose.onWindowFocusChanged.maxOrNull()} avg ${Numbers.Compose.onWindowFocusChanged.average().toInt()}"
        }
    }
}
