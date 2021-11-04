package com.example.pmm_unidad3_ejercicio5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pmm_unidad3_ejercicio5.R

class ItemDeporteAdapter(var items: ArrayList<ItemDeporte>) : RecyclerView.Adapter<ItemDeporteAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit


    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var checkBoxNombre: CheckBox
        private var imagen: ImageView

        init {
            checkBoxNombre = itemView.findViewById(R.id.cbDeporte)
            imagen = itemView.findViewById(R.id.ivImagenDeporte)
        }

        fun bindTarjeta(item: ItemDeporte, onClick: (View) -> Unit) = with(itemView) {
            checkBoxNombre.setText(item.nombre)
            imagen.setImageResource(item.imagen)
            checkBoxNombre.setOnClickListener {
                item.pulsado = checkBoxNombre.isChecked
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_deporte, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

