// LANGUAGE: +MultiPlatformProjects
// class: sample/Foo

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

expect open class Foo

// MODULE: jvm()()(common)
// TARGET_PLATFORM: JVM

// 'expect' is 'open' but 'actual' is 'final'
// COMPILATION_ERRORS

// FILE: Jvm.kt

package sample

<expr>actual class Foo</expr>
