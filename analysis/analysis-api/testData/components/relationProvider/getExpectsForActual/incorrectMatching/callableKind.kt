// LANGUAGE: +MultiPlatformProjects
// function: sample/foo()

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

expect val foo: Int

// MODULE: jvm()()(common)
// TARGET_PLATFORM: JVM

// 'expect' is a property and 'actual' is a function
// COMPILATION_ERRORS

// FILE: Jvm.kt

package sample

<expr>actual fun foo(): Int = 42</expr>
