package mx.kodemia.bookodemiasael.adaptadores

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar
import mx.kodemia.bookodemiasael.Detalles
import mx.kodemia.bookodemiasael.MainActivity
import mx.kodemia.bookodemiasael.R
import mx.kodemia.bookodemiasael.model.DataClassHome

class RecyclerViewHome(val listaLibros: MutableList<DataClassHome>) :
    RecyclerView.Adapter<RecyclerViewHome.Libros>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHome.Libros {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Libros(layoutInflater.inflate(R.layout.item_card_view, parent, false))
    }

    override fun onBindViewHolder(holder: Libros, position: Int) {
        holder.info(listaLibros[position])
    }

    override fun getItemCount(): Int = listaLibros.size


    class Libros(val view: View) : RecyclerView.ViewHolder(view) {
        val cardView: MaterialCardView = view.findViewById(R.id.item_card_view)
        val book: ImageView = view.findViewById(R.id.iv_book)
        val titulo: TextView = view.findViewById(R.id.text_title)
        val autor: TextView = view.findViewById(R.id.text_autor)
        val categoria: TextView = view.findViewById(R.id.text_categoria)

        fun info(listaLibros: DataClassHome) {
            titulo.text = listaLibros.titulo_libro
            autor.text = listaLibros.autor_libro
            categoria.text = listaLibros.categoria_libro

            Glide.with(view).load(listaLibros.book).error(R.drawable.libro_2)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(book)

        }
    }

    fun insertarLibro(datosLibro: DataClassHome) {
        this.listaLibros.add(datosLibro)
        notifyItemInserted(itemCount)
    }
}
