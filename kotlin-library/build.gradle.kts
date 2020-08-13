plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")
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
        summary = "CocoaPods test library"
        homepage = "https://github.com/JetBrains/kotlin"

        ios.deploymentTarget = "13.5"
        osx.deploymentTarget = "13.5"

        // local pod
        pod("pod_dependency") {
            version = "1.0"
            source = path(project.file("../pod_dependency"))
        }

        specRepos {
            url("https://github.com/alozhkin/spec_repo")
        }
        // pod from added spec repo
        pod("example")

        // pod from git
        pod("AFNetworking") {
            source = git("https://github.com/AFNetworking/AFNetworking.git") {
                tag = "4.0.0"
            }
        }

        // pod archive by url
        pod("podspecWithFilesExample") {
            source = url("https://github.com/alozhkin/podspecWithFilesExample/raw/master/podspecWithFilesExample.tar")
        }
    }
}
