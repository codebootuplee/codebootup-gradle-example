import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.cloud.contract.verifier.config.TestFramework

plugins {
    id("com.codebootup.kotlin.springboot") version "1.0.0-SNAPSHOT"
    id("com.codebootup.openapi-kotlin-code-generator") version "1.0.0-SNAPSHOT"
    id("org.springframework.cloud.contract") version "4.1.1"
}

repositories{
    mavenCentral()
}

dependencies{
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier:4.1.1")
}

openApiKotlinCodeGenerator{
    apiPackage.set("com.codebootup")
    sourceDirectory.set(layout.projectDirectory.dir("src\\main\\kotlin").asFile.absolutePath)
    openApiSpecification.set(layout.projectDirectory.file("src\\main\\resources\\books.yaml").asFile.absolutePath)
}

contracts{
    contractsMode.set(StubRunnerProperties.StubsMode.LOCAL)
    testFramework.set(TestFramework.JUNIT5)
    baseClassForTests.set("com.codebootup.ContractVerifierBase")
    contractsDslDir.set(File("${project.rootDir}/app/src/test/resources/contracts"))
}