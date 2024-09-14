plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
    `maven-publish`
}

group = "world.estaria"
version = "1.0.1"

repositories {
    mavenCentral()

    // simplecloud repository
    maven("https://repo.thesimplecloud.eu/artifactory/list/gradle-release-local/")
}

dependencies {
    implementation(kotlin("stdlib"))

    // avionik dependencies
    compileOnly("world.avionik:minecraft-common:1.0.2")
    runtimeOnly("world.avionik:minecraft-common:1.0.2")
    implementation("world.avionik:database-simplified-kit:1.1.0")
}

publishing {
    repositories {
        maven {
            name = "estaria"
            url = uri("https://repo.estaria.world/releases")
            credentials(PasswordCredentials::class.java)
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}
