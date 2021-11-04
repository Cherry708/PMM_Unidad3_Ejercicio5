package com.example.pmm_unidad3_ejercicio5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmm_unidad3_ejercicio5.databinding.ActivityDeportesBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActivityDeportes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deportes)

        val binding = ActivityDeportesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaItems = ArrayList<ItemDeporte>()
        listaItems.add(ItemDeporte(R.drawable.baloncesto,R.string.deporte1,false))
        listaItems.add(ItemDeporte(R.drawable.beisbol,R.string.deporte2,false))
        listaItems.add(ItemDeporte(R.drawable.ciclismo,R.string.deporte3,false))
        listaItems.add(ItemDeporte(R.drawable.futbol,R.string.deporte4,false))
        listaItems.add(ItemDeporte(R.drawable.golf,R.string.deporte5,false))
        listaItems.add(ItemDeporte(R.drawable.hipica,R.string.deporte6,false))
        listaItems.add(ItemDeporte(R.drawable.natacion,R.string.deporte7,false))
        listaItems.add(ItemDeporte(R.drawable.pinpon,R.string.deporte8,false))
        listaItems.add(ItemDeporte(R.drawable.tenis,R.string.deporte9,false))


        val recView = findViewById<RecyclerView>(R.id.rvDeporte)
        val fabSeleccion = findViewById<FloatingActionButton>(R.id.fabSeleccion)

        recView.setHasFixedSize(true)
        recView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val adaptador = ItemDeporteAdapter(listaItems)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        
        
        adaptador.onClick = {}
        fabSeleccion.setOnClickListener{
            var mostrarJuegosSeleccionados = ""
            val listaSeleccionados = ArrayList<String>()

            for (item in listaItems)
                if (item.pulsado)
                    listaSeleccionados.add(resources.getString(item.nombre))

            if (listaSeleccionados.isEmpty())
                mostrarJuegosSeleccionados = "Debes seleccionar un deporte."
            else {
                mostrarJuegosSeleccionados = "Selección: "
                for (nombre in listaSeleccionados) {
                    //Ultimo|Unico, lleva punto
                    if (listaSeleccionados.indexOf(nombre) == listaSeleccionados.size - 1)
                        mostrarJuegosSeleccionados += "${nombre}."
                    //Penultimo, lleva y
                    else if (listaSeleccionados.indexOf(nombre) == listaSeleccionados.size - 2)
                        mostrarJuegosSeleccionados += "${nombre} y "
                    //Ninguno, lleva coma
                    else mostrarJuegosSeleccionados += "${nombre}, "
                }
            }
            Toast.makeText(this,mostrarJuegosSeleccionados, Toast.LENGTH_SHORT).show()
        }
    }
}