package fr.epsi.cafeteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(val categoryList: CategoryList): RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return categoryList.items.count()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_category_button, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList.items.get(position)
        holder.buttonTitle.text = category.title
    }

}

class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
    val buttonTitle = view.findViewById<Button>(R.id.categoryButton)
}