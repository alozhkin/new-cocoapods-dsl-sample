plugins {
    id("org.jetbrains.kotlin.multiplatform").version("1.4.255-SNAPSHOT")
    id("org.jetbrains.kotlin.native.cocoapods").version("1.4.255-SNAPSHOT")
}

group = "com.example"
version = "1.0"

repositories {
    mavenLocal()
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlinx.html/") }
}

group = "org.jetbrains.kotlin.sample.native"
version = "1.0"

kotlin {
    iosX64()

    cocoapods {
        noPodspec()
//        podfile = projectDir.resolve("ios-app/Podfile")
    }
}
