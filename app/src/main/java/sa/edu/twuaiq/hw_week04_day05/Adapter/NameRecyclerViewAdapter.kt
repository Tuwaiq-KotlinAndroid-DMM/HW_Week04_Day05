package sa.edu.twuaiq.hw_week04_day05.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.Model.NameModel
import sa.edu.twuaiq.hw_week04_day05.R

class NameRecyclerViewAdapter(
    val context: Context,
    val NameList: MutableList<NameModel>):
    RecyclerView.Adapter<NameRecyclerViewAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val NameTextView: TextView = view.findViewById(R.id.name_text_view)

    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val product_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,
            parent,
            false
        )
        return ProductViewHolder(product_layout)
    }



    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = NameList[position]

        holder.NameTextView.text = product.name




    }



    override fun getItemCount(): Int {
        return NameList.size
    }
}