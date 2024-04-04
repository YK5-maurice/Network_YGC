package com.example.network_ygc

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import kotlin.math.pow
import kotlin.math.sqrt

class DrawableGraph(val graph: Graph, val currentArc: Arc? = null) : Drawable() {



    var redPaint: Paint = Paint().apply { color=Color.RED }
    var redPaint1: Paint = Paint().apply { color=Color.GREEN;strokeWidth=5f }




    override fun draw(canvas: Canvas) {
        for (node in graph.listeNode) {
            redPaint.style= Paint.Style.FILL
            canvas.drawRect(node, redPaint)
        }


        for (arc in graph.listeArc) {
            //miseAJoursArc(arc)

                // Appliquer le style de peinture
                redPaint1.style = Paint.Style.STROKE
                // Dessiner le chemin de l'arc sur le canvas
                canvas.drawPath(arc, redPaint1)

        }
        if (currentArc != null) {

            redPaint1.style=Paint.Style.STROKE
           // canvas.drawPath(currentArc, redPaint1)
            canvas.drawLine(currentArc.nodeStart.x, currentArc.nodeStart.y, currentArc.nodeEnd.x, currentArc.nodeEnd.y, redPaint1)

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

    // une fonction pour trouver les nodes les plus proches du nouveau arc
    fun rechercheNode(startX:Float, startY: Float, listeNode: MutableList<Node> = mutableListOf()): Node? {
        var nodeTrouve: Node? =null // Initialisation du node qui sera renvoyer à null
        var distanceMinimale: Float? = null // Initialisation de la distance minimale à null
        for (node in listeNode) {
            val X = startX.minus(node.x)
            val Y = startY.minus(node.y)
            val distance = sqrt(X.pow(2) + Y.pow(2))
            // Mettre à jour la distance minimale si la nouvelle distance est plus petite
            if (distanceMinimale == null || distance < distanceMinimale) {
                // verifie si la distance du node trouve est assez proche pour etre considere
                if (distance <=100f) {
                    distanceMinimale = distance
                    nodeTrouve=node
                }
            }
        }
        return nodeTrouve
    }


    //fonction pour trouver les nodes d'un arc
    fun miseAJoursArc(arc: Arc) {
        var newNodeStart:Node?=null
        var newNodeEnd:Node?=null
        for (node in graph.listeNode){
            if (arc.nodeStart.id==node.id) {
                newNodeStart= node
            }
            if (arc.nodeEnd.id==node.id){
                newNodeEnd=node
            }
        }

        if (newNodeStart!=null && newNodeEnd!=null){
            graph.removeArc(arc)
            val newArc=Arc(arc.label,newNodeStart,newNodeEnd)
            graph.addArc(newArc)
        }else{
            graph.removeArc(arc)
        }

    }


}