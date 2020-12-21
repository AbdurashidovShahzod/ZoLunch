package uz.unzosoft.zolunch.data

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceUI {
    private const val NAME = "login"
    private const val MODE = Context.MODE_PRIVATE
    lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        var editor = edit()
        operation(editor)
        editor.apply()
    }

    fun clearData() {
        fastFood = ""
        phoneString = ""
    }

    var text: String?
        get() = sharedPreferences.getString("ui", "")
        set(value) = SharedPreferenceUI.sharedPreferences.edit() {
            if (value != null) {
                it.putString("ui", "")
            }
        }

    var users: String?
        get() = sharedPreferences.getString("user", "")
        set(value) = SharedPreferenceUI.sharedPreferences.edit() {
            if (value != null) {
                it.putString("user", "")
            }
        }

    var fastFood: String?
        get() = sharedPreferences.getString("fast", "")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("fast", value)
            }
        }

    var phoneString: String?
        get() = sharedPreferences.getString("phone", "")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("phone", value)
            }
        }

}