package com.example.network_ygc

import android.graphics.Path

class Arc(var label:String, var nodeStart: Node, var nodeEnd: Node): Path() {

    init {
        moveTo(nodeStart.x, nodeStart.y) // Déplace le point de départ du chemin
        //quadTo(startX, startY, (startX + endX) / 2, (startY + endY) / 2) // Ajoute une courbe quadratique au chemin
        lineTo(nodeEnd.x, nodeEnd.y) // Ajoute une ligne droite au chemin
    }

}