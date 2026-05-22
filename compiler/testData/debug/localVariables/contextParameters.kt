// USE_INLINE_SCOPES_NUMBERS
// FILE: test.kt
context(a: String, _: String, b: String, _: String)
fun testAmbigious(): String = a

context(a: String)
fun test1(): String = a

context(a: Int, _: String)
fun test2(): String {
    return test1()
}

fun box(): String {
    context(1, "OK") {
        testAmbigious()
        return test2()
    }
}

// EXPECTATIONS JVM_IR
// test.kt:15 box:
// fake.kt:1 box:
// test.kt:15 box: $i$a$-context-TestKt$box$1\1\15\0:int=0:int
// test.kt:16 box: $i$a$-context-TestKt$box$1\1\15\0:int=0:int
// test.kt:4 testAmbigious: a:java.lang.String="OK":java.lang.String, $context-String$1:java.lang.String="OK":java.lang.String, b:java.lang.String="OK":java.lang.String, $context-String$2:java.lang.String="OK":java.lang.String
// test.kt:16 box: $i$a$-context-TestKt$box$1\1\15\0:int=0:int
// test.kt:15 box: $i$a$-context-TestKt$box$1\1\15\0:int=0:int
// test.kt:17 box: $i$a$-context-TestKt$box$1\1\15\0:int=0:int
// test.kt:9 test2: a:int=1:int, $context-String:java.lang.String="OK":java.lang.String
// test.kt:11 test2: a:int=1:int, $context-String:java.lang.String="OK":java.lang.String
// test.kt:7 test1: a:java.lang.String="OK":java.lang.String
// test.kt:11 test2: a:int=1:int, $context-String:java.lang.String="OK":java.lang.String
// test.kt:17 box: $i$a$-context-TestKt$box$1\1\15\0:int=0:int
