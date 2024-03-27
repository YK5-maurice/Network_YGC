/*
package com.example.network_ygc

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import android.view.View

class MainActivity : AppCompatActivity() {
    lateinit var drawableGraph: DrawableGraph;
    private lateinit var textView: TextView
    private lateinit var gestureDetector: GestureDetectorCompat


    var graph = Graph()



    private val paint: Paint = Paint()
    private var startX = 100f
    private var startY = 100f
    private var endX = 500f
    private var endY = 500f
    private var isDrawing = false

    var arc1 =Arc(startX,startY,endX,endY)


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var node=Node(225f,332f,52f);
        var node1=Node(125f,132f,52f);
        graph.addNode(node)
        graph.addNode(node1)

        var arc = Arc(node.x,node.y,node1.x,node1.y)
        graph.addArc(arc)

        // Créez une instance de votre DrawableGraph
        drawableGraph = DrawableGraph(graph)

        // Assurez-vous que l'ImageView a un ID approprié dans votre fichier XML de mise en page
        val myImageView: ImageView = findViewById(R.id.myImageView)

        // Associez le MyDrawable à l'ImageView
        // myImageView.setImageDrawable(drawableGraph)

        // textView = findViewById(R.id.TextView)

        // Initialisation du GestureDetector
        gestureDetector = GestureDetectorCompat(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onLongPress(e: MotionEvent) {
                val node = Node(e.x,e.y,100f)

                // Récupérer les coordonnées du point lors du clic long
                val x = e.y
                val y = e.x
                // Afficher les coordonnées dans le TextView (à adapter selon vos besoins)
                // textView.text = "Coordonnées du clic long : x = $x, y = $y"


                graph.addNode(node)
                // Créez une instance de votre DrawableGraph
                drawableGraph = DrawableGraph(graph)
                // Assurez-vous que l'ImageView a un ID approprié dans votre fichier XML de mise en page
                val myImageView: ImageView = findViewById(R.id.myImageView)
                // Associez le MyDrawable à l'ImageView
                myImageView.setImageDrawable(drawableGraph)
            }
        })

        if (isDrawing) {
            drawableGraph = DrawableGraph(graph)
            // Assurez-vous que l'ImageView a un ID approprié dans votre fichier XML de mise en page
            val myImageView: ImageView = findViewById(R.id.myImageView)
            // Associez le MyDrawable à l'ImageView
            myImageView.setImageDrawable(drawableGraph)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Utiliser le GestureDetector pour gérer les événements tactiles
        gestureDetector.onTouchEvent(event)



       /* when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
                isDrawing = true
                aa()
            }
            MotionEvent.ACTION_MOVE -> {
                endX = event.x
                endY = event.y
                invalidateMenu()
               aa()
            }
            MotionEvent.ACTION_UP -> {
                isDrawing = false
                graph.addArc(arc1)
                aa()
            }


        }*/

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
                isDrawing = true
                //invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                endX = event.x
                endY = event.y
                invalidateMenu()
            }
            MotionEvent.ACTION_UP -> {
                isDrawing = false
                // invalidate()
            }
        }
        return true


    }

    fun aa(){
        if (isDrawing) {
            drawableGraph = DrawableGraph(graph)
            // Assurez-vous que l'ImageView a un ID approprié dans votre fichier XML de mise en page
            val myImageView: ImageView = findViewById(R.id.myImageView)
            // Associez le MyDrawable à l'ImageView
            myImageView.setImageDrawable(drawableGraph)
        }
    }

}
*/


package com.example.network_ygc

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var drawableGraph: DrawableGraph
    private lateinit var gestureDetector: GestureDetectorCompat

    var graph = Graph()

    private var startX = 0f
    private var startY = 0f
    private var endX = 0f
    private var endY = 0f
    private var isDrawing = false

    // arc en cours de realisation
    private var currentArc: Arc? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        var node = Node(225f, 332f, 52f)
        var node1 = Node(125f, 132f, 52f)
        graph.addNode(node)
        graph.addNode(node1)

        var arc = Arc(node.x, node.y, node1.x, node1.y)
        graph.addArc(arc)

        val myImageView: ImageView = findViewById(R.id.myImageView)

        gestureDetector =
            GestureDetectorCompat(this, object : GestureDetector.SimpleOnGestureListener() {
                override fun onLongPress(e: MotionEvent) {
                    val node = Node(e.x, e.y, 100f)
                    val x = e.y
                    val y = e.x

                    graph.addNode(node)
                    drawableGraph = DrawableGraph(graph, currentArc)
                    myImageView.setImageDrawable(drawableGraph)
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(event)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
                isDrawing = true
                currentArc = Arc(startX, startY, endX, endY)
                invalidateMenu()
            }

            MotionEvent.ACTION_MOVE -> {
                endX = event.x
                endY = event.y
                currentArc?.endX = event.x
                currentArc?.endY = event.y
                invalidateMenu()
            }

            MotionEvent.ACTION_UP -> {
                isDrawing = false
                var arc = Arc(startX, startY, endX, endY)
                graph.addArc(arc)
                currentArc = null
                invalidateMenu()
            }
        }

        return true
    }

    override fun invalidateMenu() {
        if (isDrawing) {
            drawableGraph = DrawableGraph(graph, currentArc)
            val myImageView: ImageView = findViewById(R.id.myImageView)
            myImageView.setImageDrawable(drawableGraph)
        }
    }


    //partie pour la sauvegarde
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_reset -> {
                // Logique pour réinitialiser le graphe
                resetGraph()
                true
            }

            R.id.action_save -> {
                saveGraphToInternalStorage(graph)
                true
            }
            /* R.id.action_load -> {
                // Logique pour charger un graphe depuis la mémoire interne
                true
            }*/
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun resetGraph() {
        // Effacer les données du graphe ou réinitialiser la structure de données
        graph.clear() // Supprime tous les nœuds et les arcs du graphe

        // Rafraîchir l'affichage du graphe après la réinitialisation (si nécessaire)
        drawableGraph = DrawableGraph(graph)
        val myImageView: ImageView = findViewById(R.id.myImageView)
        myImageView.setImageDrawable(drawableGraph)

        // Afficher un message de succès ou d'information
        Toast.makeText(this, "Graphe réinitialisé", Toast.LENGTH_SHORT).show()
    }

    // Fonction pour sauvegarder le graphe dans la mémoire interne
    private fun saveGraphToInternalStorage(graph: Graph) {
        try {
            // Nom du fichier de destination
            val fileName = "graph_data.dat"

            // Chemin complet du fichier de destination dans le stockage interne de l'application
            val filePath = File(filesDir, fileName)

            // Créer un nouveau fichier s'il n'existe pas
            if (!filePath.exists()) {
                filePath.createNewFile()
            }

            // Ouvrir un FileOutputStream pour écrire dans le fichier
            val fileOutputStream = FileOutputStream(filePath)

            // Créer un ObjectOutputStream pour écrire les données du graphe dans le flux de sortie
            val objectOutputStream = ObjectOutputStream(fileOutputStream)

            // Écrire le graphe dans le fichier
            objectOutputStream.writeObject(graph)

            // Fermer les flux
            objectOutputStream.close()
            fileOutputStream.close()

            // Afficher un message de succès
            Toast.makeText(this, "Graphe sauvegardé avec succès", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            // Gérer les erreurs éventuelles
            e.printStackTrace()
            Log.e("SaveGraph", "Erreur lors de la sauvegarde du graphe: ${e.message}")
            Toast.makeText(this, "Erreur lors de la sauvegarde du graphe", Toast.LENGTH_SHORT)
                .show()
        }
    }
}