package uz.unzosoft.zolunch.uifast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_fast_food.*
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.data.SharedPreferenceUI

class MainFastFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fast_food)


        fastFoodAddBtn.setOnClickListener {
            startActivity(Intent(this, AddFastFoodActivity::class.java))
        }

        fastMenuBtn.setOnClickListener {
            startActivity(Intent(this, AllFastFoodActivity::class.java))
        }
    }

}