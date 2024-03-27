package com.example.network_ygc

class Graph {

    /* c'est le graphe qu'on sauvegarde c'est lui qui va contenir
    * les (liste), les nodes (liste) et les positions de ces objets
    * */


    val listeNode = mutableListOf<Node>()

    val listeArc = mutableListOf<Arc>()
    fun addNode(node: Node) {
        // Ajoute le nœud fourni en paramètre à la liste
        listeNode.add(node)
    }

    fun addArc(arc: Arc){
        listeArc.add(arc)
    }

<<<<<<< HEAD
    fun removeNode(node: Node){
        listeNode.remove(node)
    }

    fun removeArc(arc: Arc){
        listeArc.remove(arc)
=======
    fun clear() {
        listeArc.clear()
        listeNode.clear()
>>>>>>> 7577a14a07e8caea21e1d02a3fee4dca4d1ef8da
    }
}