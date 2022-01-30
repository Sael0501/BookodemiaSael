package mx.kodemia.bookodemiasael

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import mx.kodemia.bookodemiasael.adaptadores.RecyclerViewHome
import mx.kodemia.bookodemiasael.model.DataClassHome

class Home : AppCompatActivity() {


    val librosLista: MutableList<DataClassHome> = mutableListOf()
    var adapterAgregados = RecyclerViewHome(librosLista)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        addLibros()
        initRecyclerAgregados()

        tv_regresar_home.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
        }
    }

    private fun initRecyclerAgregados() {
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView_Home.layoutManager = myLinearLayoutManager
        recyclerView_Home.adapter = adapterAgregados
        recyclerView_Home.setHasFixedSize(true)

    }
    private fun addLibros(){
        librosLista.add(DataClassHome(R.drawable.libro_1, "El principito", "Desconocido", "Fantasia"))
        librosLista.add(DataClassHome(R.drawable.libro_2, "La metamorfosis", "Franz Kafka", "Metafora"))
        librosLista.add(DataClassHome(R.drawable.libro_2, "El Evangelio del mal", "Sabe", "Misterio/Terror"))
        librosLista.add(DataClassHome(R.drawable.libro_2, "La Sombra", "Sabe", "Suspenso"))
        librosLista.add(DataClassHome(R.drawable.libro_2, "La musica del silencio", "Mark", "Fantasia"))

    }

}