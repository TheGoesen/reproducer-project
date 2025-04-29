plugins {
    id("java")
}

tasks.register("integrationTestOld", Test::class.java) {
    dependsOn(":dep-project:resolvableConfigurations")
    dependsOn(":dep-project:service:depTask") // <-- this fails with org.gradle.api.internal.initialization.DefaultClassLoaderScope@72c766e6 must be locked before it can be used to compute a classpath!
    // dependsOn(":shallow-project:depTask") // <-- this works just fine
}


testing {
    suites {
        register<JvmTestSuite>("integrationTest") {
            dependencies {
                implementation(project(":dep-project:service")){
                    attributes{
                        attribute(Bundling.BUNDLING_ATTRIBUTE,objects.named(Bundling.SHADOWED))
                    }
                }
            }

        }
    }
}



