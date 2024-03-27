package com.example.network_ygc

class Graph {


    val listeNode = mutableListOf<Node>()

    val listeArc = mutableListOf<Arc>()
    fun addNode(node: Node) {
        // Ajoute le nœud fourni en paramètre à la liste
        listeNode.add(node)
    }

    fun addArc(arc: Arc){
        listeArc.add(arc)
    }

    fun removeNode(node: Node){
        listeNode.remove(node)
    }

    fun removeArc(arc: Arc){
        listeArc.remove(arc)
    }
}