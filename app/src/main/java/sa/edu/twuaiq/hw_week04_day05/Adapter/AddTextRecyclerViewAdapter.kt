package sa.edu.twuaiq.hw_week04_day05.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.hw_week04_day05.Activities.AddWord
import sa.edu.twuaiq.hw_week04_day05.Modle.AddWordModle
import sa.edu.twuaiq.hw_week04_day05.R

class AddTextRecyclerViewAdapter(

    val context: Context,
    val addtextlist: MutableList<AddWordModle>
) :
    RecyclerView.Adapter<AddTextRecyclerViewAdapter.AddTextViewHolder>() {


    class AddTextViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val addtextTextView: TextView = view.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddTextViewHolder {
        val addtext_layout = LayoutInflater.from(parent.context).inflate(
            R.layout.iteam_layout,
            parent,
            false
        )
        return AddTextViewHolder(addtext_layout)
    }

    override fun onBindViewHolder(holder: AddTextViewHolder, position: Int) {
        val text1 = addtextlist[position]
        holder.addtextTextView.text = text1.addword
//        holder.itemView.setOnClickListener{
//val intent=Intent(context,AddWord::class.java)
//intent.putExtra("add_text",text1.addword)
//            context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return addtextlist.size
    }


}