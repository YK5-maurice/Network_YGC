package com.example.network_ygc

import android.graphics.RectF

class Node(var id: Int, var x:Float, var y:Float, var radus:Float, var label:String?) : RectF()  {


    init {
        label= null
        id=0
        left=x-radus
        right=x+radus
        top=y-radus
        bottom=y+radus
    }
}