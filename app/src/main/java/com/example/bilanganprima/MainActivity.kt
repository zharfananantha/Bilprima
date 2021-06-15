package com.example.bilanganprima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var listAllNum: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listAllNum = arrayListOf()

        addNumBtn.setOnClickListener {
            listAllNum.add(inputNum.text.toString().toInt())
            Toast.makeText(this, "Number Added", Toast.LENGTH_SHORT).show()
            inputNum.text?.clear()
        }

        showAllNumBtn.setOnClickListener {
            var tampungShowAll = ""
            for (element in listAllNum) {
                tampungShowAll = tampungShowAll + element.toString() + "\n"
            }
            showAllNumText.text = tampungShowAll
        }

        showNumPrimaBtn.setOnClickListener {
            var numPrima = ""
            for (element in listAllNum) {
                var cek = 0
                for(i in 1..element) {
                    if (element%i == 0)
                        cek++
                }
                if (cek == 2)
                    numPrima = numPrima + element.toString() + "\n"
            }
            if (numPrima.isEmpty())
                showAllNumPrimaText.text = "Tidak ada bilangan prima"
            else
                showAllNumPrimaText.text = numPrima
        }
    }
}