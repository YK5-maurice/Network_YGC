package com.example.network_ygc

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable

class DrawableGraph(val graph: Graph, val currentArc: Arc? = null) : Drawable() {



    var redPaint: Paint = Paint().apply { color=Color.RED }
    var redPaint1: Paint = Paint().apply { color=Color.GREEN;strokeWidth=5f }




    override fun draw(canvas: Canvas) {
        for (node in graph.listeNode) {
            redPaint.style= Paint.Style.FILL
            canvas.drawRect(node, redPaint)
        }


        for (arc in graph.listeArc){
            redPaint1.style=Paint.Style.STROKE
            canvas.drawPath(arc,redPaint1)
        }

        if (currentArc != null) {

            redPaint1.style=Paint.Style.STROKE
           // canvas.drawPath(currentArc, redPaint1)
            canvas.drawLine(currentArc.startX, currentArc.startY, currentArc.endX, currentArc.endY, redPaint1)

        }

    }



    override fun setAlpha(alpha: Int) {
        TODO("Not yet implemented")
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        TODO("Not yet implemented")
    }

    /*  override fun getOpacity(): Int {
          TODO("Not yet implemented")
      }*/

    override fun getOpacity(): Int = PixelFormat.UNKNOWN
}