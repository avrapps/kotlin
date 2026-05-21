// LANGUAGE: +MultiPlatformProjects
// class: sample/Color

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

expect enum class Color { RED, GREEN, BLUE }

// MODULE: jvm()()(common)
// TARGET_PLATFORM: JVM

// The 'actual' enum is missing entries declared on the 'expect' enum
// COMPILATION_ERRORS

// FILE: Jvm.kt

package sample

<expr>actual enum class Color { RED, GREEN }</expr>
