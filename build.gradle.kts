plugins {
    val kotlin = "2.1.0"
    val springBoot = "3.4.0"
    val springDependencyManagement = "1.1.6"

    kotlin("jvm") version kotlin
    kotlin("plugin.spring") version kotlin
    id("org.springframework.boot") version springBoot
    id("io.spring.dependency-management") version springDependencyManagement
}

repositories {
    mavenCentral()
}

group = "ru.jetlabs"

dependencies {
    val jjwt = "0.11.5"

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("io.jsonwebtoken:jjwt-api:$jjwt")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:$jjwt")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:$jjwt")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencyManagement {
    val springCloud = "2024.0.0"

    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloud")
    }
}