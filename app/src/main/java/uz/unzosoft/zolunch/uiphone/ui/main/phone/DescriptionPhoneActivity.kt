package uz.unzosoft.zolunch.uiphone.ui.main.phone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_description_phone.*
import uz.unzosoft.zolunch.R

class DescriptionPhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_phone)
        val extras = intent.extras
        val name = extras!!.getString("descriptionName")
        val description = extras.getString("descriptionFeatures")

        tvDescPhoneName.text = name
        tvDescPhone.text = description

    }
}