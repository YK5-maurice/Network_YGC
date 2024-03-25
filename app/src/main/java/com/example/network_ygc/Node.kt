package com.example.network_ygc

import android.graphics.RectF

class Node(var x:Float, var y:Float, var radus:Float) : RectF()  {


    init {
        left=x-radus
        right=x+radus
        top=y-radus
        bottom=y+radus
    }
}