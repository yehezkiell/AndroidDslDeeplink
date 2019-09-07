
object Versions {
    const val kotlinVersion = "1.3.20"
    const val constrainLayout = "1.1.2"
    const val androidGradleVersion = "3.4.2"
    const val googleMaterialVersion = "1.0.0"
    const val appCompatVersion = "1.0.2"
    const val kotlinKtxVersion = "1.0.2"
    const val junitVersion = "4.12"
    const val testRunnerVersion = "1.2.0"
    const val espressoCoreVersion = "3.2.0"
    const val deepLinkVersion = "4.1.0"
}

object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"

    const val buildToolsVersion = "29.0.0"
    const val compileSdkVersion = 28
    const val targetSdkVersion = 28
    const val minSdkVersion = 17
}


object Gradle {
    val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradleVersion}"
    val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
}

object Libraries {
    val kotlinKtx = "androidx.core:core-ktx:${Versions.kotlinKtxVersion}"
    val constrainLayout = "com.android.support.constraint:constraint-layout:${Versions.constrainLayout}"
    val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    val googleMaterial = "com.google.android.material:material:${Versions.googleMaterialVersion}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    val deepLink = "com.airbnb:deeplinkdispatch:${Versions.deepLinkVersion}"
    val deepLinkAnotation = "com.airbnb:deeplinkdispatch-processor:${Versions.deepLinkVersion}"
}

object TestImplementation {
    val jUnit = "junit:junit:${Versions.junitVersion}"
    val testRunner = "androidx.test:runner:${Versions.testRunnerVersion}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
}


