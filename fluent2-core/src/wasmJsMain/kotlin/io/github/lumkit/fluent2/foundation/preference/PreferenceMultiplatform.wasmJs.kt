package io.github.lumkit.fluent2.foundation.preference

import androidx.compose.runtime.Composable
import io.github.lumkit.fluent2.foundation.util.deBase64
import io.github.lumkit.fluent2.foundation.util.enBase64
import kotlinx.browser.localStorage

private infix fun String.and(key: String): String = "$this.$key"

/**
 * WasmJs平台创建首选项
 */
@Composable
actual fun createPreferenceMultiplatform(name: String): PreferenceMultiplatform =
    localStorage.let {
        object : PreferenceMultiplatform {
            override fun getString(key: String): String? = it.getItem(name and key)

            override fun getInt(key: String): Int = try {
                getString(key).toString().toInt()
            } catch (_: Exception) {
                0
            }

            override fun getLong(key: String): Long = try {
                getString(key).toString().toLong()
            } catch (_: Exception) {
                0L
            }

            override fun getFloat(key: String): Float = try {
                getString(key).toString().toFloat()
            } catch (_: Exception) {
                0f
            }

            override fun getDouble(key: String): Double = try {
                getString(key).toString().toDouble()
            } catch (_: Exception) {
                0f.toDouble()
            }

            override fun getBoolean(key: String): Boolean = try {
                getString(key).toString().toBoolean()
            } catch (_: Exception) {
                false
            }

            override fun getByteArray(key: String): ByteArray? = getString(key)?.deBase64()

            override fun setString(key: String, value: String) {
                it.setItem(name and key, value)
            }

            override fun setInt(key: String, value: Int) {
                setString(key, value.toString())
            }

            override fun setLong(key: String, value: Long) {
                setString(key, value.toString())
            }

            override fun setFloat(key: String, value: Float) {
                setString(key, value.toString())
            }

            override fun setDouble(key: String, value: Double) {
                setString(key, value.toString())
            }

            override fun setBoolean(key: String, value: Boolean) {
                setString(key, value.toString())
            }

            override fun setByteArray(key: String, value: ByteArray) {
                setString(key, value.enBase64())
            }

            override fun remove(key: String) {
                it.removeItem(name and key)
            }

            override fun clear() {
                keys().forEach { key ->
                    it.removeItem(key)
                }
            }

            override fun keys(): List<String> {
                val keysToRemove = mutableListOf<String>()
                for (i in 0 until it.length) {
                    val key = it.key(i) ?: continue
                    if (key.startsWith("$name.")) {
                        keysToRemove.add(key)
                    }
                }
                return keysToRemove
            }

            /**
             * wasmJs平台无需实现
             */
            override fun submit() {}
        }
    }