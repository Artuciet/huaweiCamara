pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven{setUrl("https://developer.huawei.com/repo/")}//imagino que esto seria como reemplazo de: "maven{url:'https://developer.huawei.com/repo/'}"
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://developer.huawei.com/repo/")//imagino que esto seria como reemplazo de: "maven{url:'https://developer.huawei.com/repo/'}" que iria en la ventana de build gradle de la HSelfieCamera y no de la app.
    }
}

rootProject.name = "HSelfieCamera"
include(":app")
