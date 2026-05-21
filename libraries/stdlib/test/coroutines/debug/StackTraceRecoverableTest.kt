package test.coroutines.debug

import kotlin.coroutines.debug.StackTraceRecoverable
import kotlin.test.*

class StackTraceRecoverableTest {
    @Test
    fun testImplementingInCustomThrowable() {
        class BadResponseCodeException(
            val responseCode: Int,
            cause: Throwable?,
        ): Exception(cause), StackTraceRecoverable<BadResponseCodeException> {
            override fun copyForStackTraceRecovery(): BadResponseCodeException {
                return BadResponseCodeException(responseCode, this)
            }
        }
    }
}
