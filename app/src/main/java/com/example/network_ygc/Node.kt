package com.example.network_ygc

import android.graphics.RectF

class Node(val x:Float, val y:Float, val radus:Float) : RectF()  {


    init {
        left=x-radus
        right=x+radus
        top=y-radus
        bottom=y+radus
    }
}