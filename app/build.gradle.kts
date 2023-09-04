plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}
android {
    namespace = "com.example.hiltdemo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.hiltdemo"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    dependencies {

        implementation("androidx.core:core-ktx:1.9.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")

        implementation("com.google.dagger:hilt-android:2.44")
        kapt("com.google.dagger:hilt-android-compiler:2.44")
        implementation ("androidx.activity:activity-ktx:1.4.0")
        kapt("com.android.databinding:compiler:3.1.4")

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")

        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")

        implementation ("androidx.room:room-runtime:2.5.2")
        kapt ("androidx.room:room-compiler:2.5.2")
        implementation ("androidx.room:room-ktx:2.5.2")
        
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    }
    kapt {
        correctErrorTypes = true
    }

}
dependencies {
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}
