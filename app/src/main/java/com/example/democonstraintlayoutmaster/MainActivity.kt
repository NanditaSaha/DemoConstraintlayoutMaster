package com.example.democonstraintlayoutmaster

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    private var isLargeLayout = false

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val constraintSet1 = ConstraintSet()
        val constraintSet2 = ConstraintSet()

        constraintSet2.clone(this, R.layout.activity_main_animated)
        setContentView(R.layout.activity_main)

        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint_layout)
        constraintSet1.clone(constraintLayout)

        val bakeButton = findViewById<Button>(R.id.btn_animate)

        bakeButton.setOnClickListener {

            TransitionManager.beginDelayedTransition(constraintLayout)
            if (isLargeLayout) {
                constraintSet1.applyTo(constraintLayout)
            } else {
                constraintSet2.applyTo(constraintLayout)
            }
            isLargeLayout = !isLargeLayout
        }

    }

}