package azhar.graduated.signupandlogin.data

import android.content.Context
import androidx.preference.PreferenceManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyPreference @Inject constructor(@ApplicationContext context : Context) {
    val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    fun getStoredTag(): Int{

        return prefs.getInt("PREF_TAG", 0)!!
    }

    fun setStoredTag(query: Int) {
        prefs.edit().putInt("PREF_TAG", query).apply()
    }
}