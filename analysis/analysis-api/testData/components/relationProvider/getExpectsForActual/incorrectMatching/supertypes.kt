// LANGUAGE: +MultiPlatformProjects
// class: sample/Foo

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

interface Base

expect class Foo : Base

// MODULE: jvm()()(common)
// TARGET_PLATFORM: JVM

// 'actual' class is missing a supertype declared on the 'expect' class
// COMPILATION_ERRORS

// FILE: Jvm.kt

package sample

<expr>actual class Foo</expr>
