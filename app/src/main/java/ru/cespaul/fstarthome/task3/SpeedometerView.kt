package ru.cespaul.fstarthome.task3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import ru.cespaul.fstarthome.R
import java.lang.StrictMath.min

class SpeedometerView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val panel = ResourcesCompat.getDrawable(resources, R.drawable.ic_panel, null)
    private val arrow = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow, null)
    private var viewSize = 600

    private var degreesArrow = 0F

    private val rotateCenterX = viewSize / 2f
    private val rotateCenterY = viewSize / 2f
    private val rotateStep = 30F
    private var rotateArrowState: ArrowChangeState = ArrowChangeState.NONE

    private var panelColor: Int? = Color.BLACK
    private var arrowColor: Int? = Color.GREEN

    private companion object {
        const val DEGREES_ARROW = "state"
        const val SUPER_STATE = "super_state"
    }

    init {
        val typedArray = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.SpeedometerView,
            defStyleAttr,
            defStyleRes
        )

        try {
            panelColor = typedArray.getColor(R.styleable.SpeedometerView_panelColor, Color.BLACK)
            arrowColor = typedArray.getColor(R.styleable.SpeedometerView_panelColor, Color.GREEN)
        } finally {
            typedArray.recycle()
        }
    }

    override fun onSaveInstanceState(): Parcelable? =
        Bundle().apply {
            putFloat(DEGREES_ARROW, degreesArrow)
            putParcelable(SUPER_STATE, super.onSaveInstanceState())
        }

    override fun onRestoreInstanceState(state: Parcelable?) {
        var superState = state

        if (state is Bundle) {
            val degreesStateArrow = state.getFloat(DEGREES_ARROW)

            degreesArrow = degreesStateArrow

            superState = state.getParcelable(SUPER_STATE)
        }
        rotateArrowState = ArrowChangeState.RESTORE

        return super.onRestoreInstanceState(superState)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = measureDimension(viewSize, widthMeasureSpec)
        val height = measureDimension(viewSize, heightMeasureSpec)

        viewSize = min(width, height)

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

        panel?.setBounds(0, 0, viewSize, viewSize)
        arrow?.setBounds(0, 0, viewSize, viewSize)

        canvas?.let { panel?.draw(it) }
        rotateArrow(rotateArrowState, canvas)
        canvas?.let { arrow?.draw(it) }
    }

    fun changeDirection(arrowChangeState: ArrowChangeState) {
        rotateArrowState = arrowChangeState
        invalidate()
    }

    private fun rotateArrow(arrowChangeState: ArrowChangeState, canvas: Canvas?) {
        when (arrowChangeState) {
            ArrowChangeState.DOWN -> rotateArrowDown(canvas)
            ArrowChangeState.UP -> rotateArrowUp(canvas)
            ArrowChangeState.RESTORE -> restoreArrowState(canvas)
            ArrowChangeState.NONE -> return
        }
        rotateArrowState = ArrowChangeState.NONE
    }

    private fun rotateArrowUp(canvas: Canvas?) {
        when (degreesArrow) {
            0f -> {
                canvas?.rotate(degreesArrow + rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow += rotateStep
            }
            30f -> {
                canvas?.rotate(degreesArrow + rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow += rotateStep
            }
            60f -> {
                canvas?.rotate(degreesArrow + rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow += rotateStep
            }

            90f -> {
                canvas?.rotate(degreesArrow + rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow += rotateStep
            }
            120f -> {
                canvas?.rotate(degreesArrow + rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow += rotateStep
            }
            150f -> {
                canvas?.rotate(degreesArrow + rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow += rotateStep
            }
            180f -> {
                canvas?.rotate(degreesArrow + rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow += rotateStep
            }
            210f -> {
                canvas?.rotate(degreesArrow + rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow += rotateStep
            }
            else -> canvas?.rotate(degreesArrow, rotateCenterX, rotateCenterY)
        }
    }

    private fun rotateArrowDown(canvas: Canvas?) {
        when (degreesArrow) {
            0f -> return
            30f -> {
                canvas?.rotate(degreesArrow - rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow -= rotateStep
            }
            60f -> {
                canvas?.rotate(degreesArrow - rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow -= rotateStep
            }

            90f -> {
                canvas?.rotate(degreesArrow - rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow -= rotateStep
            }
            120f -> {
                canvas?.rotate(degreesArrow - rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow -= rotateStep
            }
            150f -> {
                canvas?.rotate(degreesArrow - rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow -= rotateStep
            }
            180f -> {
                canvas?.rotate(degreesArrow - rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow -= rotateStep
            }
            210f -> {
                canvas?.rotate(degreesArrow - rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow -= rotateStep
            }
            240f -> {
                canvas?.rotate(degreesArrow - rotateStep, rotateCenterX, rotateCenterY)
                degreesArrow -= rotateStep
            }
            else -> canvas?.rotate(degreesArrow, rotateCenterX, rotateCenterY)
        }
    }

    private fun restoreArrowState(canvas: Canvas?) {
        canvas?.rotate(degreesArrow, rotateCenterX, rotateCenterY)
        rotateArrowState = ArrowChangeState.NONE
    }
}