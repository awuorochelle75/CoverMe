plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.coverme"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coverme"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("String", "CONSUMER_KEY", "\"DARAJA_CONSUMER_KEY\"")
            buildConfigField("String", "CONSUMER_SECRET", "\"DARAJA_CONSUMER_SECRET\"")
        }

        getByName("debug") {
            // Custom BuildConfig fields for debug
            buildConfigField("String", "CONSUMER_KEY", "\"DARAJA_CONSUMER_KEY\"")
            buildConfigField("String", "CONSUMER_SECRET", "\"DARAJA_CONSUMER_SECRET\"")
        }
    }

    // Enable buildConfig field feature
    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.jakewharton:butterknife:10.1.0")
    annotationProcessor("com.jakewharton:butterknife-compiler:10.1.0")
    implementation("com.jakewharton.timber:timber:4.7.1")
    implementation("com.github.jumadeveloper:networkmanager:0.0.2")
    implementation("cn.pedant.sweetalert:library:1.3")
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.squareup.retrofit2:converter-gson:2.5.0")
    implementation("com.squareup.okhttp3:okhttp:3.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.12.0")
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("com.squareup.okio:okio:2.1.0")
}
