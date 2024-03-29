package com.example.network_ygc
import android.content.Context
import com.google.gson.Gson

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

    fun clear() {
        listeArc.clear()
        listeNode.clear()
    }


}