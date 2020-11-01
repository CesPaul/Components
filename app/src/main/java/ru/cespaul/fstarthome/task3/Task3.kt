package ru.cespaul.fstarthome.task3

import android.graphics.Canvas
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.fragment_task3.*
import ru.cespaul.fstarthome.R


class Task3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        speedUp.setOnClickListener {
            val canvas = Canvas()
            speedometerView.rotateArrowUp(canvas)
            speedometerView.invalidate()
        }

        /*speedDown.setOnClickListener {
            val canvas = Canvas()
            speedometerView.rotateArrowDown(canvas)
            speedometerView.invalidate()
            speedometerView.requestLayout()
        }*/
    }
}