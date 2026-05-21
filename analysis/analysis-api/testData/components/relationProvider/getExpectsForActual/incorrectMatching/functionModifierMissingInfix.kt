// LANGUAGE: +MultiPlatformProjects
// callable: sample/foo

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

expect infix fun Int.foo(other: Int): Int

// MODULE: jvm()()(common)
// TARGET_PLATFORM: JVM

// The 'actual' function is missing the 'infix' modifier declared on the 'expect'
// COMPILATION_ERRORS

// FILE: Jvm.kt

package sample

<expr>actual fun Int.foo(other: Int): Int = 0</expr>
