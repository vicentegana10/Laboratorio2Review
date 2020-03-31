package com.example.laboratorio2


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.historialactivity.*


class HistorialActivity : AppCompatActivity() {

    companion object {
        var VARIABLE = "variable"
    }
    private var variable: String = "hola"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.historialactivity)
        //variable = intent.getStringExtra(textView.text as String)


        val exampleList = ArrayList<ExampleItem>()

        addOperation("Ejemplo3",exampleList)
        addOperation("Ejemplo2",exampleList)
        addOperation("Ejemplo1",exampleList)
        addOperation(variable,exampleList)
        //addOperation(textView.text as String,exampleList)


        recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun addOperation(string: String, list: ArrayList<ExampleItem>)  {
        val item = ExampleItem(string)
        list += item
        list.remove(item);
        list.add(0,item);
    }
}