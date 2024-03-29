plugins {
    id("java")
}

group = "org.projekt_testy_junit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.mockito:mockito-core:3.+")
}

tasks.test {
    useJUnitPlatform()
}