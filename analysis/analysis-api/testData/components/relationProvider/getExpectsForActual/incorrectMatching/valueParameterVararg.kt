// LANGUAGE: +MultiPlatformProjects
// callable: sample/some

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

expect fun some(vararg n: Int)

// MODULE: jvm()()(common)
// TARGET_PLATFORM: JVM

// 'expect' parameter is 'vararg' but 'actual' parameter is not
// COMPILATION_ERRORS

// FILE: Jvm.kt

package sample

<expr>actual fun some(n: IntArray) {}</expr>
