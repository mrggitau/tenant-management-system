// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("androidx.navigation.safeargs.kotlin") version "2.9.8" apply false
    alias(libs.plugins.android.application) apply false

    // THIS IS THE MISSING LINE FOR ROOM:
    id("com.google.devtools.ksp") version "2.1.0-1.0.29" apply false
}