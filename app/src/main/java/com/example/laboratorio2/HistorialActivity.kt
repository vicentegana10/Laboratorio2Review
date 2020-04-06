package com.example.laboratorio2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.historialactivity.*
import java.util.regex.Matcher
import java.util.regex.Pattern


class HistorialActivity : AppCompatActivity() {

    private val exampleList = ArrayList<ExampleItem>()


    private fun evalLeftToRight(text: String): Double {
        var result = 0.0
        var actualOperant = ' '
        val pattern: Pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/]))")
        val m: Matcher = pattern.matcher(text)
        while (m.find()) {
            val part: String = m.group()
            if (part == "+") actualOperant = '+' else if (part == "-") actualOperant =
                '-' else if (part == "*") actualOperant =
                '*' else if (part == "/") actualOperant = '/' else {
                val actualNumber = part.toDouble()
                when (actualOperant) {
                    ' ' -> result = actualNumber
                    '+' -> result += actualNumber
                    '-' -> result -= actualNumber
                    '*' -> result *= actualNumber
                    '/' -> result /= actualNumber
                }
            }
        }
        return result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.historialactivity)
        val savedExtra = intent.getStringExtra("value1")
        val mytext : String = savedExtra

        val r: String = evalLeftToRight(mytext).toString()
        addOperation(mytext,r,exampleList)
        //val item = ExampleItem(mytext,r)
        //val insertIndex = exampleList.size     // estos tampoco me sirvieron
        //exampleList.add(insertIndex, item)
        //recycler_view.adapter?.notifyItemInserted(insertIndex)

        recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }


    private fun addOperation(string: String,resultado:String, list: ArrayList<ExampleItem>)  {
        val item = ExampleItem(string,resultado)
        list += item
        list.remove(item);
        list.add(0,item);
    }
}