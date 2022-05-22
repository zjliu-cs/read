package com.jaycola99.book.widget

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.jaycola99.book.util.Utils

class WaveView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val mPaint = Paint()
    private val mPath = Path()
    private var mItemWaveLength: Int = 0
    private var mOriginY: Int = 0
    private var mRange: Int = 0
    private var mOffsetX = 0
    private lateinit var mAnimator: ValueAnimator

    init {
        mPaint.color = Color.BLUE
        mItemWaveLength = Utils.dip2px(context, 150f)
        mOriginY = Utils.dip2px(context, 60f)
        mRange = Utils.dip2px(context, 50f)
        initAnimator()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPath.reset()   //重置路径对象
        val halfWaveLen = mItemWaveLength / 2
        mPath.moveTo((-mItemWaveLength + mOffsetX).toFloat(), mOriginY.toFloat())
        //勾勒出一段连绵起伏的波浪曲线
        for (i in -mItemWaveLength until width + mItemWaveLength step mItemWaveLength) {
            mPath.rQuadTo(
                (halfWaveLen / 2).toFloat(),
                (-mRange).toFloat(),
                halfWaveLen.toFloat(),
                0f
            )
            mPath.rQuadTo((halfWaveLen / 2).toFloat(), mRange.toFloat(), halfWaveLen.toFloat(), 0f)
        }
        mPath.lineTo(width.toFloat(), height.toFloat())
        mPath.lineTo(0f, height.toFloat())
        mPath.close()   //闭合区域
        canvas?.drawPath(mPath, mPaint) //在画布上按照指定路径绘制线条
    }

    fun startAnim() {
        if (!mAnimator.isStarted) {
            mAnimator.start()
        } else {
            mAnimator.resume()
        }
    }

    fun stopAnim() {
        mAnimator.pause()
    }

    private fun initAnimator() {
        mAnimator = ValueAnimator.ofInt(0, mItemWaveLength)
        mAnimator.apply {
            duration = 5000 //动画持续时间
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
            //动画的刷新监听器
            addUpdateListener {
                mOffsetX = it.animatedValue as Int
                postInvalidate()
            }
        }
    }
}