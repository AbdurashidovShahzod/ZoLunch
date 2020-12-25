package uz.unzosoft.zolunch.uiphone.ui.main.phone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_phone_list.*
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.adapters.PhoneAdapterAll
import uz.unzosoft.zolunch.data.SharedPreferenceUI
import uz.unzosoft.zolunch.models.PhoneU

class PhoneListActivity : AppCompatActivity() {

    private var listAll = ArrayList<PhoneU>()
    private lateinit var adapter: PhoneAdapterAll
    private lateinit var gson: Gson
    private var listNew = ArrayList<PhoneU>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_list)
        SharedPreferenceUI.init(this)

        initData()
        adapter = PhoneAdapterAll(this, listNew)
        listViewPhoneAll.divider = null
        listViewPhoneAll.adapter = adapter
        listViewPhoneAll.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, DescriptionPhoneActivity::class.java)
            intent.putExtra("descriptionName", listNew[i].namePhone)
            intent.putExtra("descriptionFeatures", listNew[i].features)
            startActivity(intent)

        }


    }

    private fun initData() {
        gson = Gson()
        var phone = SharedPreferenceUI.phoneString
        if (phone != "") {
            val extras = intent.extras
            val name = extras!!.getString("listPhone")
            tvV.text = name.toString()


            val type = object : TypeToken<List<PhoneU>>() {}.type
            listAll.addAll(gson.fromJson(phone, type))

            for (i in listAll.indices) {
                if (listAll[i].namePhone.toLowerCase().trim().startsWith(
                        name!!.toLowerCase()
                            .trim().toString()
                    )
                ) {
                    listNew.addAll(listOf(listAll[i]))
                }
            }
        }
    }
}