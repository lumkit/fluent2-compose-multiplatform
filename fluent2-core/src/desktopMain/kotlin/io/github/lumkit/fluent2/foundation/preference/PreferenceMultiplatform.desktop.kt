package io.github.lumkit.fluent2.foundation.preference

import androidx.compose.runtime.Composable
import java.util.prefs.Preferences

@Composable
actual fun createPreferenceMultiplatform(name: String): PreferenceMultiplatform =
    Preferences.userRoot()
        .node(name)
        .let {
            object : PreferenceMultiplatform {
                override fun getString(key: String): String? = it.get(key, null)

                override fun getInt(key: String): Int = it.getInt(key, 0)

                override fun getLong(key: String): Long = it.getLong(key, 0)

                override fun getFloat(key: String): Float = it.getFloat(key, 0f)

                override fun getDouble(key: String): Double = it.getDouble(key, 0.0)

                override fun getBoolean(key: String): Boolean = it.getBoolean(key, false)

                override fun getByteArray(key: String): ByteArray? = it.getByteArray(key, null)

                override fun setString(key: String, value: String) {
                    it.put(key, value)
                }

                override fun setInt(key: String, value: Int) {
                    it.putInt(key, value)
                }

                override fun setLong(key: String, value: Long) {
                    it.putLong(key, value)
                }

                override fun setFloat(key: String, value: Float) {
                    it.putFloat(key, value)
                }

                override fun setDouble(key: String, value: Double) {
                    it.putDouble(key, value)
                }

                override fun setBoolean(key: String, value: Boolean) {
                    it.putBoolean(key, value)
                }

                override fun setByteArray(key: String, value: ByteArray) {
                    it.putByteArray(key, value)
                }

                override fun remove(key: String) {
                    it.remove(key)
                }

                override fun clear() {
                    it.clear()
                }

                override fun keys(): List<String> = it.keys().toList()

                override fun submit() {
                    it.sync()
                }
            }
        }