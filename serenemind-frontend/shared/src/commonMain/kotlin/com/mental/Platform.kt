package com.mental

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform