package uz.unzosoft.zolunch.uiphone.ui.main.phone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_phone.*
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.data.SharedPreferenceUI

class MainPhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_phone)
        
        phoneAddBtn.setOnClickListener {
            startActivity(Intent(this, TypeActivityPhone::class.java))
        }
        phonesBtn.setOnClickListener {
            startActivity(Intent(this, PhonesActivity::class.java))
        }
    }
}