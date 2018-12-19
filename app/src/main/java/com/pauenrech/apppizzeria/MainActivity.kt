package com.pauenrech.apppizzeria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.pauenrech.apppizzeria.data.HamburguesaListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu_layout.*
import android.content.Intent
import android.graphics.Bitmap
import android.support.v4.util.LruCache
import android.util.Log
import android.view.animation.Animation
import android.widget.ImageView
import com.pauenrech.apppizzeria.model.Hamburguesa


class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<HamburguesaListAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(toolbar)
        rellenarListaHamburguesas()
        rellenarListaAcompañamientos()
        rellenarListaIngredientes()

        layoutManager = LinearLayoutManager(this)
        adapter = HamburguesaListAdapter(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

    }


    object ListaHamburgesas{
        public var hamburguesas: ArrayList<Hamburguesa>? = null
    }

    object ListaAcompañamientos{
        public var acompañamientos: ArrayList<Triple<String,String,Double>>? = null
    }

    object ListaIngredientes{
        public var ingredientes: ArrayList<Triple<String,String,Double>>? = null
    }

    fun rellenarListaHamburguesas(){

        ListaHamburgesas.hamburguesas = arrayListOf(
            Hamburguesa("300 (gr) Beef Burger",10.99, R.drawable.beef_burguer,R.drawable.beef_burguer_thumb),
            Hamburguesa("Double Beef Burger",8.99,R.drawable.doble_beef_burguer,R.drawable.doble_beef_burguer_thumb),
            Hamburguesa("Bacon Burger",7.99,R.drawable.bacon_burguer,R.drawable.bacon_burguer_thumb),
            Hamburguesa("Special Burger",9.99,R.drawable.special_burguer,R.drawable.special_burguer_thumb),
            Hamburguesa("Chicken Burger",7.99,R.drawable.chicken_burguer,R.drawable.chicken_burguer_thumb),
            Hamburguesa("Vegan Burger",9.99,R.drawable.vegan_burguer,R.drawable.vegan_burguer_thumb),
            Hamburguesa("Quinoa Burger",8.99,R.drawable.quinoa_burguer,R.drawable.quinoa_burguer_thumb)
        )
    }

    fun rellenarListaAcompañamientos(){

        ListaAcompañamientos.acompañamientos = arrayListOf(
            Triple("acomp1","Ensalada",2.0),
            Triple("acomp2","Patata asada", 4.0),
            Triple("acomp3","Patatas frias",3.0)
        )
    }

    fun rellenarListaIngredientes(){

        ListaIngredientes.ingredientes = arrayListOf(
            Triple("extra1","Salsa barbacoa",0.5),
            Triple("extra2","Cebolla cruda",0.5),
            Triple("extra3","Cebolla frita",0.5),
            Triple("extra4","Huevo Frito",1.0),
            Triple("extra5","Pepinillos",0.5),
            Triple("extra6","Aguacate",1.0)
        )

    }

    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
        onStartNewActivity()
    }

    override fun finish() {
        super.finish()
        onLeaveThisActivity()
    }

    protected fun onLeaveThisActivity() {
        overridePendingTransition(R.anim.slide_back_in, R.anim.slide_back_out)
    }

    protected fun onStartNewActivity() {
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
    }

    fun goToDetailsActivity(name: String, price: Double, image: Int){

    }
}