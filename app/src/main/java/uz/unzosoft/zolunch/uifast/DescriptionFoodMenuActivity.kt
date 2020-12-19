package uz.unzosoft.zolunch.uifast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fast_food_description.*
import uz.unzosoft.zolunch.R

class DescriptionFoodMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fast_food_description)

        var extras = intent.extras

        val nameP = extras!!.getString("nameP")
        val required = extras.getString("required")
        val cookingProcedure = extras.getString("cookingProcedure")

        tvDescMain.text = nameP
        tvDescRequired.text = required
        tvDescCooking.text = cookingProcedure

    }
}