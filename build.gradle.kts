plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.spring.kotlin)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependencyManagement)
}

repositories {
    mavenCentral()
}

group = "ru.jetlabs"

dependencies {
    implementation(libs.spring.boot.starter)
    implementation(libs.spring.boot.webMVC)
    implementation(libs.kotlin.reflect)
    implementation(libs.lombok)
    implementation(libs.spring.boot.security)
    implementation(libs.spring.boot.securityTest)
    implementation(libs.jjwt)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}