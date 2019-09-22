package xyz.sangcomz.indicatordecoratorsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val list: List<Pair<Int, String>>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val container = itemView
        private val textView = itemView.findViewById<AppCompatTextView>(R.id.textView)

        fun setData(data: Pair<Int, String>) {
            container.setBackgroundColor(ContextCompat.getColor(container.context, data.first))
            textView.text = data.second
        }
    }
}