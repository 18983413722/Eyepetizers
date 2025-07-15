
plugins {
    id("kotlin-kapt")
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.eyepetizers"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.eyepetizers"
        minSdk = 24
        targetSdk = 34
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

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {
    implementation (libs.androidx.paging.runtime)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.glide.v4120)
    implementation (libs.adapter.rxjava3)
    implementation (libs.rxjava)
    implementation (libs.rxandroid)
    implementation(project(":lib_net"))
    kapt("cn.therouter:apt:1.2.1")
    implementation("com.android.support:recyclerview-v7:28.0.0")
    implementation("cn.therouter:router:1.2.1")
    implementation(project(":app:home"))
    implementation(project(":app:found"))
    implementation(project(":app:popular"))
    implementation(project(":app:square"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}