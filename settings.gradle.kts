pluginManagement{
    repositories{
        mavenLocal()
        mavenCentral()
        maven{
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

rootProject.name = "codebootup-gradle-example"
include("app")
