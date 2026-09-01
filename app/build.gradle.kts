plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

val signingStoreFile = System.getenv("ANDROID_SIGNING_STORE_FILE")
val signingStorePassword = System.getenv("ANDROID_SIGNING_STORE_PASSWORD")
val signingKeyAlias = System.getenv("ANDROID_SIGNING_KEY_ALIAS")
val signingKeyPassword = System.getenv("ANDROID_SIGNING_KEY_PASSWORD")
val hasReleaseSigning = listOf(
    signingStoreFile,
    signingStorePassword,
    signingKeyAlias,
    signingKeyPassword,
).all { !it.isNullOrBlank() }

// MainCourse is the source of truth. During migration we overlay it on the legacy
// snapshot so every already-shipped lesson remains available until its file has moved.
val legacyPhpCourseDir = layout.projectDirectory.dir("src/main/assets/course/php")
val mainCoursePhpDir = rootProject.layout.projectDirectory.dir("academy-main-course/courses/php/course")
val generatedCourseAssetsDir = layout.buildDirectory.dir("generated/mainCourseAssets")

val syncPhpCourseFromMainCourse by tasks.registering(Sync::class) {
    group = "academy content"
    description = "Builds the runtime PHP Course Package from AS-Academy-MainCourse."

    into(generatedCourseAssetsDir.map { it.dir("course/php") })

    // Compatibility snapshot first; MainCourse always wins on duplicate paths.
    from(legacyPhpCourseDir)
    from(mainCoursePhpDir)

    doFirst {
        require(mainCoursePhpDir.asFile.exists()) {
            "AS-Academy-MainCourse submodule is missing. Run git submodule update --init --recursive."
        }
    }
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

    if (hasReleaseSigning) {
        signingConfigs {
            create("release") {
                storeFile = file(signingStoreFile!!)
                storePassword = signingStorePassword
                keyAlias = signingKeyAlias
                keyPassword = signingKeyPassword
            }
        }
    }

    buildTypes {
        getByName("release") {
            if (hasReleaseSigning) {
                signingConfig = signingConfigs.getByName("release")
            }
        }
    }

    buildFeatures { compose = true }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Core still reads the stable runtime path course/php/...; only its source changed.
    sourceSets.getByName("main").assets.srcDir(generatedCourseAssetsDir)
}

tasks.named("preBuild").configure {
    dependsOn(syncPhpCourseFromMainCourse)
}

dependencies {
    implementation(project(":core"))
    implementation(project(":course"))
    implementation(project(":main-ui"))
    implementation(project(":academy-course"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
}
