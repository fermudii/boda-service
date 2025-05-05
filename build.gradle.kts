plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "co.mudii"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

val KOTLIN_DEPENDENCY= "org.jetbrains.kotlin:kotlin"
val SPRING_BOOT_STARTER_DEPENDENCY = "org.springframework.boot:spring-boot-starter"

repositories {
	mavenCentral()
}

dependencies {
	// Implementation
	implementation("$KOTLIN_DEPENDENCY-reflect")
	implementation("$SPRING_BOOT_STARTER_DEPENDENCY-data-jpa")
	implementation("$SPRING_BOOT_STARTER_DEPENDENCY-web")
	implementation("$SPRING_BOOT_STARTER_DEPENDENCY-graphql")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("com.h2database:h2") // In-memory database

	// Development
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// Logging
	implementation("$SPRING_BOOT_STARTER_DEPENDENCY-logging")

	// Test
	testImplementation("$SPRING_BOOT_STARTER_DEPENDENCY-test")
	testImplementation("$KOTLIN_DEPENDENCY-test-junit5")
	testImplementation("org.springframework.graphql:spring-graphql-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
