// LANGUAGE: +MultiPlatformProjects
// callable: sample/foo

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

expect suspend fun foo()

// MODULE: jvm()()(common)
// TARGET_PLATFORM: JVM

// 'expect' is 'suspend' but 'actual' is not
// COMPILATION_ERRORS

// FILE: Jvm.kt

package sample

<expr>actual fun foo() {}</expr>
