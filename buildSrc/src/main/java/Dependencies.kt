import Versions.fragment
import Versions.navVersion
import Versions.supportVersion

object Versions {
    const val kotlinVersion = "1.3.41"
    const val constrainLayout = "1.1.2"
    const val androidGradleVersion = "3.4.2"
    const val supportVersion = "1.0.0"
    const val appCompatVersion = "1.0.2"
    const val kotlinKtxVersion = "1.0.2"
    const val junitVersion = "4.12"
    const val testRunnerVersion = "1.2.0"
    const val espressoCoreVersion = "3.2.0"
    const val daggerVersion = "2.16"
    const val retrofit = "2.6.0"
    const val archLifecycle = "2.1.0"
    const val coroutines = "1.3.3"
    const val okhttpLogging = "3.11.0"
    const val glide = "4.9.0"
    const val navVersion = "2.1.0"
    const val fragment = "1.2.0-alpha02"

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
    val constrainLayout =
        "com.android.support.constraint:constraint-layout:${Versions.constrainLayout}"
    val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    val googleMaterial = "com.google.android.material:material:${Versions.supportVersion}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    val daggerAndroidSupportCompiler =
        "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.archLifecycle}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.archLifecycle}"
    val liveData = "androidx.lifecycle:lifecycle-livedata:${Versions.archLifecycle}"
    val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0-rc02"

    val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.archLifecycle}"

    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"


    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navVersion"
    val fragmentRuntimeKtx = "androidx.fragment:fragment-ktx:$fragment"
    val fragmentRuntime = "androidx.fragment:fragment:${fragment}"
    val navigationKtx = "androidx.navigation:navigation-ui-ktx:$navVersion"

    val coreKtx = "androidx.core:core-ktx:$supportVersion"
}

object TestImplementation {
    val jUnit = "junit:junit:${Versions.junitVersion}"
    val testRunner = "androidx.test:runner:${Versions.testRunnerVersion}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
}


