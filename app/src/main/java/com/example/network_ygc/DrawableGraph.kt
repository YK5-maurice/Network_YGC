package com.example.network_ygc

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable

class DrawableGraph(val graph: Graph) : Drawable() {



    var redPaint: Paint = Paint().apply { color=Color.RED }
    var redPaint1: Paint = Paint().apply { color=Color.GREEN;strokeWidth=5f }

    var p= Arc()




    override fun draw(canvas: Canvas) {
        for (node in graph.listeNode) {
            canvas.drawRect(node, redPaint)
        }

        p.moveTo( graph.listeNode[0].x,  graph.listeNode[0].y)
        p.lineTo( graph.listeNode[2].x,  graph.listeNode[2].y)

        redPaint1.style=Paint.Style.STROKE
        canvas.drawPath(p, redPaint1)

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