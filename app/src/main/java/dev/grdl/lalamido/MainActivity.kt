package dev.grdl.lalamido

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    var minorScalesAll =  listOf("a", "e", "b", "f#", "c#", "g#", "d#", "d", "g", "c", "f", "bb")
    var majorScalesAll = listOf("C", "G", "D", "A", "E", "B", "F#", "F", "Bb", "Eb", "Ab", "Db")

    var practiceSet = mutableListOf<String>()
    var setSize = 0

    fun reset(view: View) {
        val parent: View = view.parent as View
        val scalesSelector = parent.findViewById<RadioGroup>(R.id.scalesSelector)

        when (scalesSelector.checkedRadioButtonId) {
            R.id.radioScaleMajor -> {
                practiceSet = majorScalesAll.toMutableList()
            }
            R.id.radioScaleMinor-> {
                practiceSet = minorScalesAll.toMutableList()
            }
            R.id.radioScaleBoth-> {
                practiceSet = (majorScalesAll + minorScalesAll).toMutableList()
            }
        }

        practiceSet.shuffle()
        setSize = practiceSet.size
    }


    fun randomize(view: View) {
        val parent: View = view.parent as View
        val scaleField = parent.findViewById<TextView>(R.id.scaleName)
        val progressField = parent.findViewById<TextView>(R.id.progress)

        if (practiceSet.isEmpty()) {
            reset(view)
        }

        progressField.text = "${practiceSet.size} / ${setSize}"

        val scale = practiceSet.removeLast()

        scaleField.text = scale
    }
}