package uz.unzosoft.zolunch.uiphone.ui.main.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.uiphone.ui.main.viewmodel.PhoneTypesFragment

class PhoneTypesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phone_types_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PhoneTypesFragment.newInstance())
                .commitNow()
        }
    }
}