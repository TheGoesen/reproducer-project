configurations.consumable("shadowJar"){
    attributes{
        attribute(Bundling.BUNDLING_ATTRIBUTE,objects.named(Bundling.SHADOWED))
    }
}
tasks.register("depTask") {
    group="build"
    doLast {
        println("ran depTask")
    }
    outputs.file("shadow.jar")
}
artifacts{
    add("shadowJar",tasks.named("depTask"))
}
