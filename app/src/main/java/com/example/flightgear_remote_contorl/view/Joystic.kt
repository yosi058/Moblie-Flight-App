package com.example.flightgear_remote_contorl.view


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import java.lang.Integer.min
import kotlin.Exception
import kotlin.math.sqrt

class Joystic @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val big_circle = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL_AND_STROKE
        isAntiAlias = true
    }
    private val little_circle = Paint().apply {
        color = Color.LTGRAY
        style = Paint.Style.FILL_AND_STROKE
        isAntiAlias = true
    }
    private var big_r: Float = 0.0f
    private var little_r: Float = 0.0f
    private var little_center: PointF = PointF()
    private var big_center: PointF = PointF()
    private var aileron: Float = 0.0f
    private var elevator: Float = 0.0f
    lateinit var update: (Float, Float) -> Unit

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onSizeChanged(width: Int, height: Int, oldw: Int, oldh: Int) {
        // make sure actual code handles padding well.
        little_r = 0.15f * min(width, height).toFloat()
        little_center = PointF(width / 2.0f, height / 2.0f)
        big_r = 0.4f * min(width, height).toFloat()
        big_center = PointF(width / 2.0f, height / 2.0f)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle(big_center.x, big_center.y, big_r, big_circle)
        canvas?.drawCircle(little_center.x, little_center.y, little_r, little_circle)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) {
            return true
        }
        when (event.action) {
            MotionEvent.ACTION_MOVE -> touchMove(event.x, event.y)
            MotionEvent.ACTION_UP -> touchMove(big_center.x, big_center.y)
        }
        return true
    }

    private fun touchMove(x: Float, y: Float) {
        val dis_center = dis(x, y, big_center.x, big_center.y)
        if (dis_center + little_r <= big_r) {
            little_center = PointF(x, y)
            aileron = (x - big_center.x) / big_r
            elevator = (big_center.y - y) / big_r
        } else {
            val new_x = (((x - big_center.x) / dis_center) * (big_r - little_r)) + big_center.x
            val new_y = (((y - big_center.y) / dis_center) * (big_r - little_r)) + big_center.y
            little_center = PointF(new_x.toFloat(), new_y.toFloat())
        }
        try {
            this.update(aileron, elevator)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        invalidate()
    }

    private fun dis(event_x: Float, event_y: Float, center_x: Float, center_y: Float): Double {
        val y = (event_y - center_y) * (event_y - center_y)
        val x = (event_x - center_x) * (event_x - center_x)
        val sum = (x + y).toDouble()
        return sqrt(sum)
    }
}



