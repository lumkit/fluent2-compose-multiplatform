package io.github.lumkit.fluent2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform