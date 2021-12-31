package fr.epsi.cafeteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.cafeteria.CategoryAdapter.ViewHolder

class CategoryAdapter(val categoryList: CategoryList): RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.categoryButton)
    }

    override fun getItemCount(): Int {
        return categoryList.items.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_category_button, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList.items.get(position)
        holder.button.text = category.title
        holder.button.setOnClickListener(View.OnClickListener {
            (holder.button.context as BaseActivity)
                .goToProductsList(category.category_id, category.title, category.products_url)
        })
    }

}