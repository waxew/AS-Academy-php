plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.asdevelopers.academy.php"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.asdevelopers.academy.php"
        minSdk = 23
        targetSdk = 37
        versionCode = 4
        versionName = "0.4.0"
    }

    buildFeatures { compose = true }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Course Package در مسیر استاندارد Android Assets قرار دارد:
    // app/src/main/assets/course/php
    // بنابراین Loader مرکزی Core بدون تنظیم سفارشی و بدون dependency مبهم Gradle آن را می‌خواند.
}

dependencies {
    implementation(project(":core"))
    implementation(project(":course"))
    implementation(project(":academy-course"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
}
