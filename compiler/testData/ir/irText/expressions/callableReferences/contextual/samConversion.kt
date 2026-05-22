// LANGUAGE: +ContextParameters +CallableReferencesToContextual
// IGNORE_BACKEND: JVM_IR
// ^KT-86452

fun interface Sam {
    fun invoke()
}

context(_: String)
fun foo() {}

fun acceptSam(t: Sam) {}

fun String.test() {
    acceptSam(::foo)
}
