package com.mustafa.uiperformancetests

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mustafa.uiperformancetests.bycode.ByCodeActivity
import com.mustafa.uiperformancetests.compose.ComposeActivity
import com.mustafa.uiperformancetests.databinding.ActivityMainBinding
import com.mustafa.uiperformancetests.xml.XMLActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var repeatCount = 0
    private var didCalculate = true
    private var targetActivity = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            xmlBtn.setOnClickListener {
                repeatCount = 0
                didCalculate = false
                targetActivity = "XMLActivity"
                startActivity(Intent(root.context, XMLActivity::class.java))
            }

            byCodeBtn.setOnClickListener {
                repeatCount = 0
                didCalculate = false
                targetActivity = "ByCodeActivity"
                startActivity(Intent(root.context, ByCodeActivity::class.java))
            }

            composeBtn.setOnClickListener {
                repeatCount = 0
                didCalculate = false
                targetActivity = "ComposeActivity"
                startActivity(Intent(root.context, ComposeActivity::class.java))
            }
        }
        window.decorView.post {
            Log.d("ERROR", " MainActivity decorView ")
        }
    }

//    override fun onPause() {
//        super.onPause()
//
//    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
//        if (repeatCount != 0) {
//            when (targetActivity) {
//                "XMLActivity" -> startActivity(Intent(binding.root.context, XMLActivity::class.java))
//                "ByCodeActivity" -> startActivity(Intent(binding.root.context, ByCodeActivity::class.java))
//            }
//            repeatCount--
//        } else if (!didCalculate) {
//            didCalculate = true
//            targetActivity = ""
//            binding.apply {
//                xmlLbl.text =
//                    "number of tries = ${Numbers.XML.onCreate.size}\n" +
//                            "onCreate min ${Numbers.XML.onCreate.min()?.toInt()} max ${Numbers.XML.onCreate.max()?.toInt()} avg ${Numbers.XML.onCreate.average().toInt()}\n" +
//                            "viewTree min ${Numbers.XML.viewTreeObserver.min()?.toInt()} max ${Numbers.XML.viewTreeObserver.max()?.toInt()} avg ${Numbers.XML.viewTreeObserver.average().toInt()}\n" +
//                            "decorView min ${Numbers.XML.decorView.min()?.toInt()} max ${Numbers.XML.decorView.max()?.toInt()} avg ${Numbers.XML.decorView.average().toInt()}\n" +
//                            "WindowFocus min ${Numbers.XML.onWindowFocusChanged.min()?.toInt()} max ${Numbers.XML.onWindowFocusChanged.max()?.toInt()} avg ${Numbers.XML.onWindowFocusChanged.average().toInt()}"
//
//                byCodeLbl.text =
//                    "number of tries = ${Numbers.ByCode.onCreate.size}\n" +
//                    "onCreate min ${Numbers.ByCode.onCreate.min()?.toInt()} max ${Numbers.ByCode.onCreate.max()?.toInt()} avg ${Numbers.ByCode.onCreate.average().toInt()}\n" +
//                            "viewTree min ${Numbers.ByCode.viewTreeObserver.min()?.toInt()} max ${Numbers.ByCode.viewTreeObserver.max()?.toInt()} avg ${Numbers.ByCode.viewTreeObserver.average().toInt()}\n" +
//                            "decorView min ${Numbers.ByCode.decorView.min()?.toInt()} max ${Numbers.ByCode.decorView.max()?.toInt()} avg ${Numbers.ByCode.decorView.average().toInt()}\n" +
//                            "WindowFocus min ${Numbers.ByCode.onWindowFocusChanged.min()?.toInt()} max ${Numbers.ByCode.onWindowFocusChanged.max()?.toInt()} avg ${Numbers.ByCode.onWindowFocusChanged.average().toInt()}"
//            }
//        }
    }

    @SuppressLint("SetTextI18n")
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            if (repeatCount != 0) {
                when (targetActivity) {
                    "XMLActivity" -> startActivity(Intent(binding.root.context, XMLActivity::class.java))
                    "ByCodeActivity" -> startActivity(Intent(binding.root.context, ByCodeActivity::class.java))
                }
                repeatCount--
            } else if (!didCalculate) {
                didCalculate = true
                targetActivity = ""
                binding.apply {
                    xmlLbl.text =
                        "number of tries = ${Numbers.XML.onCreate.size}\n" +
                                "onCreate ------- min ${Numbers.XML.onCreate.min()?.toInt()} max ${Numbers.XML.onCreate.max()?.toInt()} avg ${Numbers.XML.onCreate.average().toInt()}\n" +
                                "viewTree ------- min ${Numbers.XML.viewTreeObserver.min()?.toInt()} max ${Numbers.XML.viewTreeObserver.max()?.toInt()} avg ${Numbers.XML.viewTreeObserver.average().toInt()}\n" +
                                "decorView ----- min ${Numbers.XML.decorView.min()?.toInt()} max ${Numbers.XML.decorView.max()?.toInt()} avg ${Numbers.XML.decorView.average().toInt()}\n" +
                                "WindowFocus min ${Numbers.XML.onWindowFocusChanged.min()?.toInt()} max ${Numbers.XML.onWindowFocusChanged.max()?.toInt()} avg ${Numbers.XML.onWindowFocusChanged.average().toInt()}"

                    byCodeLbl.text =
                        "number of tries = ${Numbers.ByCode.onCreate.size}\n" +
                                "onCreate ------- min ${Numbers.ByCode.onCreate.min()?.toInt()} max ${Numbers.ByCode.onCreate.max()?.toInt()} avg ${Numbers.ByCode.onCreate.average().toInt()}\n" +
                                "viewTree ------- min ${Numbers.ByCode.viewTreeObserver.min()?.toInt()} max ${Numbers.ByCode.viewTreeObserver.max()?.toInt()} avg ${Numbers.ByCode.viewTreeObserver.average().toInt()}\n" +
                                "decorView ----- min ${Numbers.ByCode.decorView.min()?.toInt()} max ${Numbers.ByCode.decorView.max()?.toInt()} avg ${Numbers.ByCode.decorView.average().toInt()}\n" +
                                "WindowFocus min ${Numbers.ByCode.onWindowFocusChanged.min()?.toInt()} max ${Numbers.ByCode.onWindowFocusChanged.max()?.toInt()} avg ${Numbers.ByCode.onWindowFocusChanged.average().toInt()}"
                }
            }
        }
    }
}
