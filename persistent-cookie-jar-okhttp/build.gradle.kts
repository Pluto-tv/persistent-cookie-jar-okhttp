plugins {
    id("com.android.library")
    alias(libs.plugins.jetbrainsKotlinAndroid)
    `maven-publish`
}

group = "com.andreuzaitsev.persistentcookiejar"
version = "1.0.0-alpha01-2024.03.18"

android {
    namespace = "com.andreuzaitsev.persistentcookiejar"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

afterEvaluate {
    publishing {
        // These values are provided by the CI environment, args are retrieved from the command line.
        val nexusURL: String? by project
        val nexusUserName: String? by project
        val nexusUserPassword: String? by project
        repositories {
            maven {
                url = uri(nexusURL ?: "")
                credentials {
                    username = nexusUserName
                    password = nexusUserPassword
                }
            }
        }
        publications {
            publications.withType<MavenPublication> {
            // Provide artifacts information requited by Maven Central
                pom {
                    name.set("persistent-cookie-jar-okhttp Library")
                    description.set(
                        "Custom version of persistent-cookie-jar-okhttp Library"
                    )
                    url.set("https://github.com/Pluto-tv/persistent-cookie-jar-okhttp")

                    developers {
                        developer {
                            id.set("Pluto TV")
                            name.set("Android Team (MH)")
                        }
                    }
                    scm {
                        url.set("https://github.com/Pluto-tv/persistent-cookie-jar-okhttp")
                    }
                }
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.material)
    implementation(libs.okhttp)
    testImplementation(libs.mockito)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.robolectric)
    testImplementation(libs.junit)
    testImplementation(libs.androidx.test.core.ktx)
    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}