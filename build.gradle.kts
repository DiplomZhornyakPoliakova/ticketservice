plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.7.7"
}

version = "0.1"
group = "ua.nure.bachelor.ticktrip"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("jakarta.annotation:jakarta.annotation-api")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")
    implementation("org.jetbrains:annotations:23.0.0")
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")
    compileOnly("jakarta.json.bind:jakarta.json.bind-api:3.0.0")
    annotationProcessor("io.micronaut.data:micronaut-data-processor")
    annotationProcessor("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.beanvalidation:micronaut-hibernate-validator")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa:3.8.1")
    implementation("io.micronaut.sql:micronaut-hibernate-jpa")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("io.micronaut.sql:micronaut-jooq")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.postgresql:postgresql")
    implementation("io.micronaut:micronaut-validation")
    implementation("com.google.zxing:core:3.5.1")

}


application {
    mainClass.set("ua.nure.bachelor.ticktrip.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("ua.nure.bachelor.ticktrip.*")
    }
}



