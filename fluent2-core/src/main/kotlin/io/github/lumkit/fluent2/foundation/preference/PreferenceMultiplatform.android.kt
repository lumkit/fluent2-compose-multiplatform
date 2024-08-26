package io.github.lumkit.fluent2.foundation.preference

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import io.github.lumkit.fluent2.foundation.util.deBase64
import io.github.lumkit.fluent2.foundation.util.enBase64

@Composable
actual fun createPreferenceMultiplatform(name: String): PreferenceMultiplatform {
    val context = LocalContext.current
    val preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    return object : PreferenceMultiplatform {
        override fun getString(key: String): String? = preferences.getString(key, null)

        override fun getInt(key: String): Int = preferences.getInt(key, 0)

        override fun getLong(key: String): Long = preferences.getLong(key, 0L)

        override fun getFloat(key: String): Float = preferences.getFloat(key, 0.0f)

        override fun getDouble(key: String): Double = getFloat(key).toDouble()

        override fun getBoolean(key: String): Boolean = preferences.getBoolean(key, false)

        override fun getByteArray(key: String): ByteArray? = getString(key)?.deBase64()

        override fun setString(key: String, value: String) {
            preferences.edit().putString(key, value).apply()
        }

        override fun setInt(key: String, value: Int) {
            preferences.edit().putInt(key, value).apply()
        }

        override fun setLong(key: String, value: Long) {
            preferences.edit().putLong(key, value).apply()
        }

        override fun setFloat(key: String, value: Float) {
            preferences.edit().putFloat(key, value).apply()
        }

        override fun setDouble(key: String, value: Double) {
            setFloat(key, value.toFloat())
        }

        override fun setBoolean(key: String, value: Boolean) {
            preferences.edit().putBoolean(key, value).apply()
        }

        override fun setByteArray(key: String, value: ByteArray) {
            setString(key, value.enBase64())
        }

        override fun remove(key: String) {
            preferences.edit().remove(key).apply()
        }

        override fun clear() {
            preferences.edit().clear().apply()
        }

        override fun keys(): List<String> = preferences.all.keys.toList()

        override fun submit() {
            preferences.edit().commit()
        }
    }
}