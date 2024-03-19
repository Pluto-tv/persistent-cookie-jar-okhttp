pluginManagement {

    java.util.Properties().apply {
        try {
            File("gradle.properties").reader().use { load(it) }
        } catch (error: Exception) {
            //do Nothing
        }
    }.also {
        print(it)

        val repoArtifactsURL: String = System.getenv("REPO_ARTIFACTS_URL") ?: it.getProperty("REPO_ARTIFACTS_URL")
        val repoUsername: String = System.getenv("REPO_USERID") ?: it.getProperty("REPO_USERID")
        val repoPassword: String = System.getenv("REPO_PASSWORD") ?: it.getProperty("REPO_PASSWORD")

        extra.set("repoArtifactsURL", repoArtifactsURL)
        extra.set("repoUsername", repoUsername)
        extra.set("repoPassword", repoPassword)
    }

    repositories {
        maven {
            url = uri(extra.get("repoArtifactsURL") as String)
            credentials {
                username = extra.get("repoUsername") as String
                password = extra.get("repoPassword") as String
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri(extra.get("repoArtifactsURL") as String)
            credentials {
                username = extra.get("repoUsername") as String
                password = extra.get("repoPassword") as String
            }
        }
    }
}


rootProject.name = "persistent-cookie-jar-okhttp"
include(":persistent-cookie-jar-okhttp")