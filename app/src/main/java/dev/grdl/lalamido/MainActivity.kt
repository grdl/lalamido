package dev.grdl.lalamido

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun randomize(view: View) {
        val minorScales = listOf("a", "e", "b", "f#", "c#", "g#", "d#", "d", "g", "c", "f", "bb")

        val parent: View = view.parent as View

        val scale = parent.findViewById<TextView>(R.id.scaleName)
        scale.text = minorScales.random()
    }
}