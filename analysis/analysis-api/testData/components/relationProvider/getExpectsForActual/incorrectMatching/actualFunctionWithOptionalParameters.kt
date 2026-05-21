// LANGUAGE: +MultiPlatformProjects
// callable: sample/some

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

expect fun some(n: Int)

// MODULE: jvm()()(common)
// TARGET_PLATFORM: JVM

// The 'actual' function declares a default value that the 'expect' does not
// COMPILATION_ERRORS

// FILE: Jvm.kt

package sample

<expr>actual fun some(n: Int = 42) {}</expr>
