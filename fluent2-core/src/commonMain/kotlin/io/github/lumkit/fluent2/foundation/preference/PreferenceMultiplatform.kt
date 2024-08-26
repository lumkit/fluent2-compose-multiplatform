package io.github.lumkit.fluent2.foundation.preference

import androidx.compose.runtime.Composable

interface PreferenceMultiplatform {
    fun getString(key: String): String?
    fun getInt(key: String): Int
    fun getLong(key: String): Long
    fun getFloat(key: String): Float
    fun getDouble(key: String): Double
    fun getBoolean(key: String): Boolean
    fun getByteArray(key: String): ByteArray?

    fun setString(key: String, value: String)
    fun setInt(key: String, value: Int)
    fun setLong(key: String, value: Long)
    fun setFloat(key: String, value: Float)
    fun setDouble(key: String, value: Double)
    fun setBoolean(key: String, value: Boolean)
    fun setByteArray(key: String, value: ByteArray)

    fun remove(key: String)
    fun clear()

    fun keys(): List<String>

    fun submit()
}

/**
 * 创建多平台首选项
 */
@Composable
expect fun createPreferenceMultiplatform(name: String): PreferenceMultiplatform