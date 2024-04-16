package ru.appsmile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.appsmile.ItemData
import ru.appsmile.first.R

class NumberAdapter(private val numberList: List<ItemData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class NumberViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_view)
    }

    class NumberSecondViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_view)
        val imageView: ImageView = view.findViewById(R.id.image_view)
    }

    override fun getItemViewType(position: Int): Int = if (numberList[position].number % 2 == 0) {
        RED_VIEW_TYPE
    } else {
        BLACK_VIEW_TYPE
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            RED_VIEW_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_number_list, parent, false)

                NumberViewHolder(view)
            }

            BLACK_VIEW_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_number_second_list, parent, false)

                NumberSecondViewHolder(view)
            }

            else -> throw Exception()
        }

    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when {
            holder is NumberViewHolder -> {
                holder.textView.text = numberList[position].number.toString()
            }

            holder is NumberSecondViewHolder -> {
                holder.textView.text = numberList[position].text

                if (numberList[position].number % 5 == 0) {
                    holder.imageView.setImageResource(R.drawable.bg_first)
                } else {
                    holder.imageView.setImageResource(R.drawable.bg_second)
                }
            }
        }
    }

    companion object {
        const val RED_VIEW_TYPE = 1
        const val BLACK_VIEW_TYPE = 2
    }
}