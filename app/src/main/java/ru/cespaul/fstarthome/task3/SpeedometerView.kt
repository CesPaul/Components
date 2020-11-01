package ru.cespaul.fstarthome.task3

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import ru.cespaul.fstarthome.R
import java.lang.StrictMath.min

class SpeedometerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var size = 600

    private var degreesArrow = 0F

    private val px = size / 2f
    private val py = size / 2f
    private val increment = 30F

    private val panel = ResourcesCompat.getDrawable(resources, R.drawable.ic_panel, null)
    private val arrow = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow, null)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = measureDimension(size, widthMeasureSpec)
        val height = measureDimension(size, heightMeasureSpec)

        size = min(width, height)

        setMeasuredDimension(width, height)
    }

    private fun measureDimension(minSize: Int, measureSpec: Int): Int {
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        return when (specMode) {
            MeasureSpec.EXACTLY -> specSize
            MeasureSpec.AT_MOST -> minSize.coerceAtMost(specSize)
            else -> minSize
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

            panel?.setBounds(0, 0, size, size)
            arrow?.setBounds(0, 0, size, size)

        canvas?.let { panel?.draw(it) }
        rotateArrowUp(canvas)
        canvas?.let { arrow?.draw(it) }
    }

    /*fun rotate(arrowChangeDirection: ArrowChangeDirection, canvas: Canvas?) {
        b?.invoke(arrowChangeDirection, canvas)
        invalidate()
    }

    private fun rotateArrow(arrowChangeDirection: ArrowChangeDirection, canvas: Canvas?) {
        when (arrowChangeDirection) {
            ArrowChangeDirection.DOWN -> rotateArrowDown(canvas)
            ArrowChangeDirection.UP -> rotateArrowUp(canvas)
        }
    }*/

    fun rotateArrowUp(canvas: Canvas?) {
        when (degreesArrow) {
            0f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow += increment
            }
            30f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow += increment
            }
            60f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow += increment
            }

            90f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow += increment
            }
            120f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow += increment
            }
            150f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow += increment
            }
            180f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow += increment
            }
            210f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
            }
        }
    }

    /*private fun rotateArrowDown(canvas: Canvas?) {
        when (degreesArrow) {
            0f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
            }
            30f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow -= increment
            }
            60f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow -= increment
            }

            90f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow -= increment
            }
            120f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow -= increment
            }
            150f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow -= increment
            }
            180f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow -= increment
            }
            210f -> {
                canvas?.rotate(degreesArrow + increment, px, py)
                degreesArrow -= increment
            }
        }
    }*/

}