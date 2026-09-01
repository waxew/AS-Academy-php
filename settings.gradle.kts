pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("academy-core/gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "AS-Academy-PHP"
include(":app")
include(":academy-course")

// Core: engine, database, repositories and content contracts.
include(":course")
project(":course").projectDir = file("academy-core/course")
include(":core")
project(":core").projectDir = file("academy-core/core")

// MainUi: shared presentation layer. The PHP host no longer owns shared screens.
include(":main-ui")
project(":main-ui").projectDir = file("academy-main-ui/main-ui")

// MainCourse is a content-only submodule. Its PHP package is consumed by the app
// through the generated/synced Android assets configured in :app.
