package uz.unzosoft.zolunch.uiphone.ui.main.phone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phones.*
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.adapters.PhoneAdapter
import uz.unzosoft.zolunch.adapters.PhoneAdapter2
import uz.unzosoft.zolunch.models.Phone

class PhonesActivity : AppCompatActivity() {
    private lateinit var list: ArrayList<Phone>
    private lateinit var adapter: PhoneAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phones)
        initData()
        adapter = PhoneAdapter2(this, list)
        gv.adapter = adapter
        gv.setOnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(this, PhoneListActivity::class.java)
            intent.putExtra("listPhone", list[i].phoneName)
            startActivity(intent)
        }

    }

    private fun initData() {
        list = ArrayList()
        list.add(Phone("Iphone"))
        list.add(Phone("Samsung"))
        list.add(Phone("Mi"))
        list.add(Phone("Sony"))
        list.add(Phone("Huawei"))
        list.add(Phone("Artel"))
    }
}