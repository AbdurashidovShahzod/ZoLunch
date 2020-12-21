package uz.unzosoft.zolunch.uiphone.ui.main.phone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_add_phone.*
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.data.SharedPreferenceUI
import uz.unzosoft.zolunch.models.FastFood
import uz.unzosoft.zolunch.models.PhoneU

class AddPhoneActivity : AppCompatActivity() {
    private lateinit var gson: Gson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_phone)
        SharedPreferenceUI.init(this)
        gson = Gson()

        addContactBtn.setOnClickListener {

            var name = namePhoneBtn.text.toString()
            var features = nameFeaturesBtn.text.toString()
            val phone1 = SharedPreferenceUI.phoneString


            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(features)) {

                val listPhone = ArrayList<PhoneU>()

                if (phone1!!.isNotEmpty()) {

                    val typeJson = object : TypeToken<List<PhoneU>>() {}.type
                    listPhone.addAll(gson.fromJson(phone1, typeJson))
                }
                var phoneU = PhoneU(name, features)
                var isHave = false

                for (i in listPhone.indices) {
                    if (listPhone[i].namePhone.toLowerCase().trim()
                        == name.toLowerCase().trim()
                    ) {
                        isHave = true
                        break
                    }
                }

                if (isHave) {
                    Toast.makeText(
                        this,
                        "Bunday markadagi telefon mavjud!!!", Toast.LENGTH_SHORT
                    )
                        .show()

                } else {
                    listPhone.add(phoneU)
                    SharedPreferenceUI.clearData()
                    SharedPreferenceUI.phoneString = gson.toJson(listPhone)
                    startActivity(Intent(this, MainPhoneActivity::class.java))
                    finish()
                    Log.d("PHONE", "onCreate:${listPhone.toString()}")
                }


            } else {
                Toast.makeText(
                    this, "Siz ma'lumot to'ldirmadingiz ", Toast.LENGTH_SHORT
                ).show()
            }

        }

    }
}