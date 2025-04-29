rootProject.name = "reproducer-project"

include("test-project:sub-project")
include("dep-project:service")
include("shallow-project")

dependencyResolutionManagement{
    repositories{
        mavenCentral()
    }
}
