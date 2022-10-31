buildscript {
    val compose_ui_version: String by extra("1.2.1")
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.0-alpha05" apply false
    id("com.android.library") version "8.0.0-alpha05" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

tasks.create("incrementVersionCode") {
    val versionFile = file("./project.version")
    val readText = versionFile.readText()
    val currentVersionCode = readText.split("\n").find { it.contains("releaseVersionCode") }?.split(" ")?.get(2) ?: return@create
    val incrementedVersionCode = currentVersionCode?.toInt()?.plus(1).toString()
    val incrementedText = readText.replace(currentVersionCode, incrementedVersionCode)
    versionFile.writeText(incrementedText, Charsets.UTF_8)
}