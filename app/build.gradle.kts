plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

// فقط Course Package اختصاصی PHP را به Assets اپ تبدیل می‌کنیم.
// استفاده از ریشه کل Repository به‌عنوان Assets باعث می‌شد Gradle خروجی‌های تولیدی Core را
// ورودی mergeDebugAssets تشخیص دهد و در Gradle 9 خطای implicit dependency ایجاد شود.
val prepareCourseAssets by tasks.registering(Sync::class) {
    from(rootProject.file("course/php"))
    into(layout.buildDirectory.dir("generated/courseAssets/course/php"))
}

android {
    namespace = "com.asdevelopers.academy.php"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.asdevelopers.academy.php"
        minSdk = 23
        targetSdk = 37
        versionCode = 1
        versionName = "0.1.0"
    }

    buildFeatures { compose = true }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Loader مرکزی مسیر course/php را انتظار دارد؛ این Provider وابستگی Task را نیز به Gradle اعلام می‌کند.
    sourceSets.getByName("main").assets.srcDir(
        prepareCourseAssets.map { it.destinationDir.parentFile.parentFile }
    )
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
