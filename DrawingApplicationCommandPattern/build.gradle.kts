plugins {
    kotlin("jvm") version "2.3.20"
    id("org.openjfx.javafxplugin") version "0.1.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

javafx {
    version = "25" // Specify your desired JavaFX version
    modules("javafx.controls", "javafx.graphics") // Add modules required by your app
}

kotlin {
    jvmToolchain(25)
}

application {
    mainClass.set("MainKt")
}

tasks.test {
    useJUnitPlatform()
}