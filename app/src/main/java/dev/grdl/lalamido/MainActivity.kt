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

    var minorScalesAll =  listOf("a", "e", "b", "f#", "c#", "g#", "d#", "d", "g", "c", "f", "bb")
    var practiceSet = mutableListOf<String>()
    var setSize = 12

    fun randomize(view: View) {
        val parent: View = view.parent as View
        val scaleField = parent.findViewById<TextView>(R.id.scaleName)
        val progressField = parent.findViewById<TextView>(R.id.progress)


        if (practiceSet.isEmpty()) {
            practiceSet = minorScalesAll.toMutableList()
            practiceSet.shuffle()
        }

        progressField.text = "${practiceSet.size} / ${setSize}"

        val scale = practiceSet.removeLast()

        scaleField.text = scale

    }
}