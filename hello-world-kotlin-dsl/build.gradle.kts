plugins {
    java
    groovy
    id("com.github.ngyewch.gradle-fjage-plugin") version "0.2.0"
}

repositories {
    jcenter()
}

dependencies {
    "fjage"("com.github.org-arl:fjage:1.6.2")
    "fjage"("org.codehaus.groovy:groovy:2.5.8")

    implementation("org.yaml:snakeyaml:1.25")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    register("runTest", org.arl.fjage.gradle.FjageGroovyBootTask::class) {
        scripts = listOf("etc/initrc-console-shell", "scripts/01_hello")
        systemProperties = mapOf("java.util.logging.config.file" to "logging.properties")
    }
}
