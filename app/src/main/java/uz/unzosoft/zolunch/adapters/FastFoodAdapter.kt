package uz.unzosoft.zolunch.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.all_fast_food_item.view.*
import uz.unzosoft.zolunch.models.FastFood
import uz.unzosoft.zolunch.R

class FastFoodAdapter(context: Context, var list: List<FastFood>) :
    ArrayAdapter<FastFood>(context, R.layout.all_fast_food_item, list) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView: View = convertView
            ?: LayoutInflater.from(parent.context)
                .inflate(R.layout.all_fast_food_item, parent, false)
        itemView.tvItemView.text = list[position].nomi
        return itemView
    }


}