package ru.cespaul.fstarthome.task3

import android.content.Context
import android.graphics.Canvas
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
    private val step = 30F

    private var arrowDirection: ArrowChangeDirection = ArrowChangeDirection.NONE

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
        rotateArrow(arrowDirection, canvas)
        canvas?.let { arrow?.draw(it) }
    }

    fun changeDirection(arrowChangeDirection: ArrowChangeDirection) {
        arrowDirection = arrowChangeDirection
        invalidate()
    }

    private fun rotateArrow(arrowChangeDirection: ArrowChangeDirection, canvas: Canvas?) {
        when (arrowChangeDirection) {
            ArrowChangeDirection.DOWN -> rotateArrowDown(canvas)
            ArrowChangeDirection.UP -> rotateArrowUp(canvas)
            ArrowChangeDirection.NONE -> return
        }
        arrowDirection = ArrowChangeDirection.NONE
    }

    private fun rotateArrowUp(canvas: Canvas?) {
        when (degreesArrow) {
            0f -> {
                canvas?.rotate(degreesArrow + step, px, py)
                degreesArrow += step
            }
            30f -> {
                canvas?.rotate(degreesArrow + step, px, py)
                degreesArrow += step
            }
            60f -> {
                canvas?.rotate(degreesArrow + step, px, py)
                degreesArrow += step
            }

            90f -> {
                canvas?.rotate(degreesArrow + step, px, py)
                degreesArrow += step
            }
            120f -> {
                canvas?.rotate(degreesArrow + step, px, py)
                degreesArrow += step
            }
            150f -> {
                canvas?.rotate(degreesArrow + step, px, py)
                degreesArrow += step
            }
            180f -> {
                canvas?.rotate(degreesArrow + step, px, py)
                degreesArrow += step
            }
            210f -> {
                canvas?.rotate(degreesArrow + step, px, py)
            }
        }
    }

    private fun rotateArrowDown(canvas: Canvas?) {
        when (degreesArrow) {
            0f -> return
            30f -> {
                canvas?.rotate(degreesArrow - step, px, py)
                degreesArrow -= step
            }
            60f -> {
                canvas?.rotate(degreesArrow - step, px, py)
                degreesArrow -= step
            }

            90f -> {
                canvas?.rotate(degreesArrow - step, px, py)
                degreesArrow -= step
            }
            120f -> {
                canvas?.rotate(degreesArrow - step, px, py)
                degreesArrow -= step
            }
            150f -> {
                canvas?.rotate(degreesArrow - step, px, py)
                degreesArrow -= step
            }
            180f -> {
                canvas?.rotate(degreesArrow - step, px, py)
                degreesArrow -= step
            }
            210f -> {
                canvas?.rotate(degreesArrow - step, px, py)
                degreesArrow -= step
            }
        }
    }
}