package uz.unzosoft.zolunch.uiphone.ui.main.mainphoneui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_phone.*
import kotlinx.android.synthetic.main.activity_main_phone.*
import kotlinx.android.synthetic.main.activity_main_phone_ui.*
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.data.SharedPreferenceUI
import uz.unzosoft.zolunch.uiphone.ui.main.phone.PhonesActivity
import uz.unzosoft.zolunch.uiphone.ui.main.phone.TypeActivityPhone

class MainPhoneActivityUi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_phone_ui)

        addBtn.setOnClickListener {
            startActivity(Intent(this, TypesActivityUi::class.java))
        }

    }
}