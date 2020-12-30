package uz.unzosoft.zolunch.uiphone.ui.main.mainphoneui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_type_phone.*
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.adapters.PhoneAdapter
import uz.unzosoft.zolunch.models.Phone
import uz.unzosoft.zolunch.uiphone.ui.main.phone.AddPhoneActivity

class TypesActivityUi : AppCompatActivity() {

    private lateinit var adapter: PhoneAdapter
    private var list = ArrayList<Phone>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_types_ui)
        initData()

        adapter = PhoneAdapter(this, list)
        listViewPhone.adapter = adapter
        listViewPhone.divider = null

        listViewPhone.setOnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(this, AddPhoneActivityUi::class.java)
            intent.putExtra("aaa", list[i].phoneName)
            startActivity(intent)
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