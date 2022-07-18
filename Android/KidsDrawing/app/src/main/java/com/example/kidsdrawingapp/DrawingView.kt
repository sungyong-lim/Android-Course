package com.example.kidsdrawingapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class DrawingView(context: Context, attrs: AttributeSet) : View(context, attrs){

    private var mDrawPath : CustomPath? = null
    private var mCanvasBitmap: Bitmap? = null // bitmap => 이미 그려진 그림을 가져오는 것
    private var mDrawPaint: Paint? = null // 그림을 그리는 도구
    private var mCanvasPaint: Paint? = null
    private var mBrushSize: Float = 0.toFloat()  // 그림붓 두께
    private var color = Color.BLACK // 그림붓 색상
    private var canvas: Canvas? = null// 그림을 그릴 수 있는 도화지

    init {
        setUpDrawing()
    }

    private fun setUpDrawing() {
        mDrawPaint = Paint()
        mDrawPath = CustomPath(color, mBrushSize)
        mDrawPaint!!.color = color // 그림붓 색상
        mDrawPaint!!.style = Paint.Style.STROKE // 그림붓 테두리 => 채우지는 않고 외곽선만 그림
        mDrawPaint!!.strokeJoin = Paint.Join.ROUND // 그림붓 둥근 형태
        mDrawPaint!!.strokeCap = Paint.Cap.ROUND // 둥근 모양으로 끝이 장식됨, Cap 은 선 끝의 위치를 정함
        mCanvasPaint = Paint(Paint.DITHER_FLAG) //블리팅 시 디더링을 활성화하는 페인트 플래그
        mBrushSize = 20.toFloat() // 브러쉬 사이즈 설정
    }


    // CustomPath 클래스를 DrawingView 내부에서만 사용 => internal
    // 변수를 가져오거나 내보낼 수 있음 => inner
    // path 타입 => Canvas 에 어떤 도형을 그리는데 미리 그려진 궤적 정보
    // 컬러, 브러쉬 두께를 상속 받음
    internal inner class CustomPath(var color: Int, var brushThickness: Float) : Path() {

    }

}