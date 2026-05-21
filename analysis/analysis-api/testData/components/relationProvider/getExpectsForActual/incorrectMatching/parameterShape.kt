// LANGUAGE: +MultiPlatformProjects
// callable: sample/foo

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

expect fun foo()

// MODULE: jvm()()(common)
// TARGET_PLATFORM: JVM

// 'expect' is a non-extension function and 'actual' is an extension function
// COMPILATION_ERRORS

// FILE: Jvm.kt

package sample

<expr>actual fun String.foo() {}</expr>
