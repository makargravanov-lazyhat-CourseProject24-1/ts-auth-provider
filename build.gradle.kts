plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.spring.kotlin)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependencyManagement)
}
val springCloudVersion by extra("2024.0.0-RC1")

repositories {
    mavenCentral()
    maven("https://repo.spring.io/milestone/")
}

group = "ru.jetlabs"

dependencies {
    implementation(libs.spring.boot.starter)
    implementation(libs.spring.boot.webMVC)
    implementation(libs.kotlin.reflect)
    implementation(libs.lombok)
    implementation(libs.spring.boot.security)
    implementation(libs.spring.boot.securityTest)
    implementation(libs.spring.cloud.openfeign)
    implementation(libs.jjwt.api)
    runtimeOnly(libs.jjwt.impl)
    runtimeOnly(libs.jjwt.jackson)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencyManagement {
    imports {
        mavenBom(libs.bom.spring.cloud.dependencies.get().toString())
    }
}