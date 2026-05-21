// LANGUAGE: +MultiPlatformProjects
// class: sample/Foo

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

expect class Foo

// MODULE: jvm()()(common)
// TARGET_PLATFORM: JVM

// 'expect' is a class and 'actual' is an interface
// COMPILATION_ERRORS

// FILE: Jvm.kt

package sample

<expr>actual interface Foo</expr>
