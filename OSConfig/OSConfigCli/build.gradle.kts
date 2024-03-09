plugins {
    id("java")
}

group = "dave.opensearch"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.5")
    implementation("joda-time:joda-time:2.12.7")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.0")
    implementation("org.opensearch.client:opensearch-java:2.8.1")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.2.1")
}

tasks.test {
    useJUnitPlatform()
}