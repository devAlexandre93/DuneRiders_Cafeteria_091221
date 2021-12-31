package fr.epsi.cafeteria


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.epsi.cafeteria.ProductsListAdapter.ViewHolder

class ProductsListAdapter(val productsList: ProductsList): RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayoutProductList)
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewProductList)
        val textViewName = view.findViewById<TextView>(R.id.textViewProductName)
        val textViewDescription = view.findViewById<TextView>(R.id.textViewProductDescription)
    }

    override fun getItemCount(): Int {
        return productsList.items.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_product_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productsList.items.get(position)
        holder.textViewName.text = product.name
        holder.textViewDescription.text = product.description
        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)
        holder.contentLayout.setOnClickListener(View.OnClickListener {
            (holder.contentLayout.context as BaseActivity)
                .goToProductDetails(product.name, product.description, product.picture_url)
        })
    }

}