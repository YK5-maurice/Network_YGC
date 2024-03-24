package com.example.network_ygc

class Graph {


    val listeNode = mutableListOf<Node>()
    fun addNode(node: Node) {
        // Ajoute le nœud fourni en paramètre à la liste
        listeNode.add(node)
    }
}