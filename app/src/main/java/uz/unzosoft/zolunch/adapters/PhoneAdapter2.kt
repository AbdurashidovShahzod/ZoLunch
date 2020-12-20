package uz.unzosoft.zolunch.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_fast_food.view.*
import kotlinx.android.synthetic.main.item_phone.view.*
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.models.Phone

class PhoneAdapter2(context: Context, var list: List<Phone>) :
    ArrayAdapter<Phone>(context, R.layout.item_main_phone, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val itemView: View = convertView ?: LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_phone, parent, false)
        itemView.tvItemViewPhone.text = list[position].phoneName

        return itemView
    }


}