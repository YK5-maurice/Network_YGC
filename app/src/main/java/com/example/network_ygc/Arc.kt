package com.example.network_ygc

import android.graphics.Path

class Arc(var startX:Float, var startY:Float, var endX:Float , var endY: Float): Path() {

    init {
        moveTo(startX, startY) // Déplace le point de départ du chemin
        //quadTo(startX, startY, (startX + endX) / 2, (startY + endY) / 2) // Ajoute une courbe quadratique au chemin
        lineTo(endX, endY) // Ajoute une ligne droite au chemin
    }

}