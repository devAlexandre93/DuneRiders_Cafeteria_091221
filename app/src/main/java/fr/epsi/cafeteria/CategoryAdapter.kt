package fr.epsi.cafeteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter: RecyclerView.Adapter<ViewHolder>() {

    val buttonTitles = listOf("First button", "Second button", "Third button", "Fourth button")

    override fun getItemCount(): Int {
        return buttonTitles.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.category_button, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val buttonTitle = buttonTitles.get(position)
        holder.buttonTitle.text = buttonTitle
    }

}

class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
    val buttonTitle = view.findViewById<Button>(R.id.categoryButton)
}