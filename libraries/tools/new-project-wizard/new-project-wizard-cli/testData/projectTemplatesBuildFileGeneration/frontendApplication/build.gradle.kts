plugins {
    kotlin("js") version "KOTLIN_VERSION"
}
group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-dev")
    }
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlinx")
    }
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers")
    }
}
dependencies {
    testImplementation(kotlin("test-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.1-KOTLIN_VERSION")
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.109-kotlin-KOTLIN_VERSION")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.109-kotlin-KOTLIN_VERSION")
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.109-kotlin-KOTLIN_VERSION")
}
kotlin {
    js {
        browser {
            binaries.executable()
            webpackTask {
                cssSupport.enabled = true
            }
            runTask {
                cssSupport.enabled = true
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                    cssSupport.enabled = true
                }
            }
        }
    }
}