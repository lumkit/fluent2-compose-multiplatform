package io.github.lumkit.fluent2.foundation.util

/**
 * Base64工具类
 */
object Base64Util {
    private val base64Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray()
    private val base64Inv = IntArray(256) { -1 }

    init {
        for (i in base64Chars.indices) {
            base64Inv[base64Chars[i].code] = i
        }
    }

    fun encode(input: ByteArray): String {
        val output = StringBuilder()
        var padding = 0
        var i = 0

        while (i < input.size) {
            var b = input[i++].toInt() and 0xFF shl 16

            if (i < input.size) {
                b = b or (input[i++].toInt() and 0xFF shl 8)
            } else {
                padding++
            }

            if (i < input.size) {
                b = b or (input[i++].toInt() and 0xFF)
            } else {
                padding++
            }

            output.append(base64Chars[(b shr 18) and 0x3F])
            output.append(base64Chars[(b shr 12) and 0x3F])

            if (padding < 2) {
                output.append(base64Chars[(b shr 6) and 0x3F])
            } else {
                output.append('=')
            }

            if (padding < 1) {
                output.append(base64Chars[b and 0x3F])
            } else {
                output.append('=')
            }
        }

        return output.toString()
    }

    fun decode(input: String): ByteArray {
        val cleanInput = input.filter { it != '=' }
        val output = ByteArray(cleanInput.length * 3 / 4)

        var outputIndex = 0
        var i = 0

        while (i < cleanInput.length) {
            var b = base64Inv[cleanInput[i++].code] shl 18

            b = b or (base64Inv[cleanInput[i++].code] shl 12)

            if (i < cleanInput.length) {
                b = b or (base64Inv[cleanInput[i++].code] shl 6)
            }

            if (i < cleanInput.length) {
                b = b or base64Inv[cleanInput[i++].code]
            }

            output[outputIndex++] = (b shr 16).toByte()

            if (outputIndex < output.size) {
                output[outputIndex++] = (b shr 8).toByte()
            }

            if (outputIndex < output.size) {
                output[outputIndex++] = b.toByte()
            }
        }

        return output.copyOf(outputIndex)
    }
}

fun String.deBase64(): ByteArray = Base64Util.decode(this)
fun ByteArray.enBase64(): String = Base64Util.encode(this)