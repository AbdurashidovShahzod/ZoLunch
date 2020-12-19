package uz.unzosoft.zolunch.uifast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_add_fast_food.*
import uz.pdp.loginui.model.FastFood
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.data.SharedPreferenceUI

class AddFastFoodActivity : AppCompatActivity() {
    lateinit var gson: Gson


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_fast_food)
        SharedPreferenceUI.init(this)
        gson = Gson()

        saveBtn.setOnClickListener {
            val name = nameFastFood.text.toString()
            val required = requiredProducts.text.toString()
            val cooking = cookingProcedure.text.toString()
            val fastFood1 = SharedPreferenceUI.fastFood


            if (!TextUtils.isEmpty(name)
                && !TextUtils.isEmpty(required)
                && !TextUtils.isEmpty(cooking)
            ) {
                val listFastFood = ArrayList<FastFood>()

                if (fastFood1!!.isNotEmpty()) {
                    val typeJson = object : TypeToken<List<FastFood>>() {}.type
                    listFastFood.addAll(gson.fromJson(fastFood1, typeJson))
                }

                val fastFood = FastFood(name, required, cooking)
                var isHave = false


                for (i in listFastFood.indices) {
                    if (listFastFood[i].nomi == name) {
                        isHave = true
                        break
                    }
                }
                if (isHave) {
                    Toast.makeText(
                        this,
                        "Bunday Fast food ro'yxatda mavjud!!!", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    listFastFood.add(fastFood)
                    SharedPreferenceUI.clearData()
                    SharedPreferenceUI.fastFood = gson.toJson(listFastFood)
                    startActivity(Intent(this, AllFastFoodActivity::class.java))
                    finish()
                }
            } else {
                Toast.makeText(
                    this, "Ma'lumot to'ldirilmadi!!!", Toast.LENGTH_SHORT
                ).show()
            }


        }
    }
}