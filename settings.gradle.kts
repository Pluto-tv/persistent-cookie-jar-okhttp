pluginManagement {

    java.util.Properties().apply {
        File("${settingsDir.parent}/persistent-cookie-jar-okhttp/gradle.properties").reader().use { load(it) }
    }.also {
        val nexusURL: String = System.getenv("NEXUS_URL") ?: it.getProperty("NEXUS_URL")
        val nexusUsername: String = System.getenv("NEXUS_USERID") ?: it.getProperty("NEXUS_USERID")
        val nexusPassword: String = System.getenv("NEXUS_PASSWORD") ?: it.getProperty("NEXUS_PASSWORD")

        extra.set("nexusURL", nexusURL)
        extra.set("nexusUsername", nexusUsername)
        extra.set("nexusPassword", nexusPassword)
    }

    repositories {
        maven {
            url = uri(extra.get("nexusURL") as String)
            credentials {
                username = extra.get("nexusUsername") as String
                password = extra.get("nexusPassword") as String
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri(extra.get("nexusURL") as String)
            credentials {
                username = extra.get("nexusUsername") as String
                password = extra.get("nexusPassword") as String
            }
        }
    }
}


rootProject.name = "persistent-cookie-jar-okhttpn"
include(":persistent-cookie-jar-okhttp")