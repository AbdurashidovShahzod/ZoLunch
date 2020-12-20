package uz.unzosoft.zolunch.uiphone.ui.main.phone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_all_fast_food.*
import kotlinx.android.synthetic.main.activity_type_phone.*
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.adapters.PhoneAdapter
import uz.unzosoft.zolunch.models.Phone

class TypeActivityPhone : AppCompatActivity() {

    private lateinit var adapter: PhoneAdapter
    private var list = ArrayList<Phone>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_phone)
        initData()

        adapter = PhoneAdapter(this, list)
        listViewPhone.adapter = adapter
        listViewPhone.divider = null

        listViewPhone.setOnItemClickListener { adapterView, view, i, l ->
            startActivity(Intent(this, AddPhoneActivity::class.java))
        }


    }

    private fun initData() {
        list.add(Phone("Iphone"))
        list.add(Phone("Samsung"))
        list.add(Phone("Mi"))
        list.add(Phone("Sony"))
        list.add(Phone("Huawei"))
        list.add(Phone("Artel"))
    }
}