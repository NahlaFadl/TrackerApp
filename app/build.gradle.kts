plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
//    id("dagger.hilt.android.plugin")
    id("com.google.dagger.hilt.android")
//    id("kotlin-android-extensions")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.trackapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.trackapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        multiDexEnabled = true

//        javaCompileOptions {
//            annotationProcessorOptions {
//                arguments["dagger.hilt.disableModulesHaveInstallInCheck"]="true"
//            }
//        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        dataBinding=true
    }
    hilt {
        enableExperimentalClasspathAggregation = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Material Design
//    implementation ("com.google.android.material:material:1.3.0-alpha01")

    // Architectural Components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    // Room
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")

    // Kotlin Extensions and Coroutines support for Room
    implementation ("androidx.room:room-ktx:2.6.1")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // Navigation Components
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.6")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.13.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.13.2")

    // Google Maps Location Services
    implementation ("com.google.android.gms:play-services-location:21.0.1")
    implementation ("com.google.android.gms:play-services-maps:18.2.0")

    // Dagger Core
    implementation ("com.google.dagger:dagger:2.43.2")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.43.2")

//    // Dagger Android
//    api ("com.google.dagger:dagger-android:2.28.1")
//    api ("com.google.dagger:dagger-android-support:2.28.1")
//    annotationProcessor ("com.google.dagger:dagger-android-processor:2.23.2")

    //Dagger - Hilt
//    implementation("com.google.dagger:hilt-android:2.28-alpha")
//    kapt("com.google.dagger:hilt-android-compiler:2.28-alpha")

//    implementation("com.google.dagger:hilt-android:2.44")
//    annotationProcessor ("com.google.dagger:hilt-compiler:2.44")

//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//    annotationProcessor("androidx.hilt:hilt-compiler:1.0.0-alpha03")


    // Easy Permissions
    implementation ("pub.devrel:easypermissions:3.0.0")

    // Timber
    implementation ("com.jakewharton.timber:timber:4.7.1")

    // MPAndroidChart
//    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")

    implementation ("android.arch.lifecycle:extensions:1.1.1")

    annotationProcessor("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")


//    annotationProcessor("com.google.dagger:hilt-android-compiler:2.38.1")

    implementation("androidx.multidex:multidex:2.0.1")


    //hilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")

    // For instrumentation tests
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.50")
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.50")

    // For local unit tests
    testImplementation("com.google.dagger:hilt-android-testing:2.50")
    kaptTest("com.google.dagger:hilt-compiler:2.50")
}
kapt {
    correctErrorTypes =true
}