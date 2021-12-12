package fr.epsi.cafeteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.cafeteria.ProductAdapter.ViewHolder

class ProductAdapter(val products: ArrayList<Product>): RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val textViewProduct = view.findViewById<TextView>(R.id.textViewProduct)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_product, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.textViewProduct.text=product.name
    }

    override fun getItemCount(): Int {
        return products.size
    }

}