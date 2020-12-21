package uz.unzosoft.zolunch.uifast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_all_fast_food.*
import uz.unzosoft.zolunch.models.FastFood
import uz.unzosoft.zolunch.R
import uz.unzosoft.zolunch.adapters.FastFoodAdapter
import uz.unzosoft.zolunch.data.SharedPreferenceUI

class AllFastFoodActivity : AppCompatActivity() {

    lateinit var fastFoodAdapter: FastFoodAdapter
    private lateinit var gson: Gson
    private var list = ArrayList<FastFood>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_fast_food)
        listViewFastFood.divider = null
        SharedPreferenceUI.init(this)
        initData()
        fastFoodAdapter = FastFoodAdapter(this, list)
        listViewFastFood.adapter = fastFoodAdapter

        listViewFastFood.setOnItemClickListener { adapterView, view, i, l ->

            var intent = Intent(this, DescriptionFoodMenuActivity::class.java)

            var bundle = Bundle()
            /*
            Bundle ishlatsa ham bo'ladi!!!
             */

            bundle.putString("nameP", list[i].nomi)
            bundle.putString("required", list[i].kerakliMaxsulotlar)
            bundle.putString("cookingProcedure", list[i].tayyorlanishTartibi)

            intent.putExtras(bundle)
            startActivity(intent)

        }

        Log.d("List:", "onCreate:${list.toString()} ")
    }

    private fun initData() {
        var fastFood = SharedPreferenceUI.fastFood
        if (fastFood != "") {
            gson = Gson()
            var type = object : TypeToken<List<FastFood>>() {}.type
            list.addAll(gson.fromJson(fastFood, type))
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainFastFoodActivity::class.java))
        finish()
    }
}