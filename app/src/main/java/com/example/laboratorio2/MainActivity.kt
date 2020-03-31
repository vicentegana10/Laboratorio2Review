package com.example.laboratorio2


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.laboratorio2.HistorialActivity.Companion.VARIABLE
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.Float
import kotlin.String


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //btn.setOnClickListener {
        //    val intent = Intent(this, HistorialActivity::class.java)
        //    startActivity(intent)
        //}
    }
    var number1 = Float.Companion

    fun printTitle(view: View) {
        val button : Button = findViewById<Button>(view.id)
        textView.text = textView.text.toString() + button.text.toString()
    }


    fun printTitle2(view: View) {
        val button : Button = findViewById<Button>(view.id)
        textView.text = ""
    }

    fun erase(view: View) {
        val button : Button = findViewById<Button>(view.id)
        textView.text = removeLastChar(textView.text.toString())
    }

    private fun removeLastChar(str: String): String? {
        return str.substring(0, str.length - 1)
    }

    fun onClick(view: View) {
        //val intent = Intent(this, HistorialActivity::class.java)
        val intent = Intent(view.context, HistorialActivity::class.java)
        intent.putExtra(VARIABLE, textView.text as String)
        // Utilizar como en el ejemplo los nombre(VARIABLE) con mayúscula
        view.context.startActivity(intent)
    }





}
